import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Kamil Klosowski, Michael Lam, Goh Shu Yu
 * @since   4/12/2017
 */
public class ArtworkDao {
    /**
     * Get the connection form the class - sqlitegingleton.
     * */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    /**
     * Artwork table name in database.
     * */
    private final String ARTWORK_TABLE = "artwork";
    private final String SCULPTURE = "sculpture";
    private final String PAINTING = "painting";


    public Artwork getArtwork(int artwork_id) throws SQLException{
        String searchArtworkQuery = String.format("SELECT * FROM %s WHERE artwork_id = %d",
                ARTWORK_TABLE, artwork_id);
        ResultSet rs = connection.query(searchArtworkQuery);
        if (rs.next()) {
            return searchArtworkByType(rs);
        }
        return null;
    }
    public List<Artwork> getAllArtwork()throws SQLException{
        List<Artwork> artworks = new ArrayList<>();
        String getQuery = String.format("SELECT * FROM %s",ARTWORK_TABLE);
        ResultSet rs = connection.query(getQuery);
        while (rs.next()) {
            artworks.add(searchArtworkByType(rs));
        }
        return artworks;
    }
    private Artwork searchArtworkByType(ResultSet rs) throws SQLException{
        if (rs.getString("artwork_type").equals(SCULPTURE)){
            String searchSculpture = String.format("SELECT * FROM %s WHERE artwork_spec_id = %d ",SCULPTURE,rs.getInt("artwork_id"));
            ResultSet sculptureRs = connection.query(searchSculpture);
            if (sculptureRs.next()){
                return DBUtils.constructSculpture(rs,sculptureRs);
            }
        }else if (rs.getString("artwork_type").equals(PAINTING)){
            String searchPainting = String.format("SELECT * FROM %s WHERE artwork_spec_id = %d ",PAINTING,rs.getInt("artwork_id"));
            ResultSet paintingRs = connection.query(searchPainting);
            if (paintingRs.next()){
                return DBUtils.constructPaintingFromRS(rs,paintingRs);
            }
        }
        return null;
    }

    public int updateArtwork(Artwork artwork) throws SQLException{
        System.out.println("trying " );
        String updateArtworkQuery = String.format("UPDATE %s SET title = '%s', description = '%s'," +
                        " artist = '%s', year_created = %d WHERE artwork_id = %d",ARTWORK_TABLE,artwork.getTitle(),artwork.getDescription(),
                artwork.getArtist(),artwork.getYearCreated(),artwork.getArtworkId());
        System.out.println("update " + updateArtworkQuery);
        int result = connection.insert(updateArtworkQuery);
        System.out.println("result " + result);
        if (result>0){
            if (artwork instanceof Sculpture){
                Sculpture sculpture = (Sculpture) artwork;
                String updateSculpture = String.format("UPDATE '%s' SET dimension_x = %f,dimension_y = %f, " +
                                "dimension_z = %f , material = '%s' WHERE artwork_spec_id = %d",SCULPTURE,sculpture.getHeight()
                        ,sculpture.getWidth(),sculpture.getDepth(),sculpture.getMaterial(),sculpture.getArtworkId());
                return connection.insert(updateSculpture);
            }else if (artwork instanceof Painting){
                Painting painting = (Painting) artwork;
                String updateSculpture = String.format("UPDATE '%s' SET dimension_x = %f,dimension_y = %f " +
                                " WHERE artwork_spec_id = %d",PAINTING,painting.getHeight()
                        ,painting.getWidth(),painting.getArtworkId());
                return connection.insert(updateSculpture);
            }
        }
        return 0;
    }

    public int deleteArtwork(Artwork artwork) throws SQLException{
        int result = 0;
        if (artwork instanceof Sculpture){
            String deleteScuplture = String.format("DELETE FROM '%s' WHERE artwork_spec_id = %d ", SCULPTURE,artwork.getArtworkId());
            result = connection.insert(deleteScuplture);
        }else if (artwork instanceof Painting){
            String deletePainting = String.format("DELETE FROM '%s' WHERE artwork_spec_id = %d ", PAINTING,artwork.getArtworkId());
            result = connection.insert(deletePainting);
        }
        if (result>0){
            String deleteArtworkQuery = String.format("DELETE FROM %s WHERE artwork_id = %d",
                    ARTWORK_TABLE, artwork.getArtworkId());
            return connection.insert(deleteArtworkQuery);
        }
        return 0;
    }

    int insertArtwork(Artwork artwork) throws SQLException{
        List<Artwork> artworks = getAllArtwork();
        int lastId =0;
        if (artworks.size()>0){
            lastId = artworks.get(artworks.size()-1).getArtworkId();
        }
        String type = "";
        if (artwork instanceof Sculpture){
            type = SCULPTURE;
        }else if (artwork instanceof Painting){
            type = PAINTING;
        }
        String inserQuery = String.format("INSERT INTO %s (artwork_id,artwork_type,artwork_spec_id,title,description,artist,year_created,picture_location) VALUES (%d,'%s',%d,'%s','%s','%s',%d, '%s')",ARTWORK_TABLE,
                ++lastId,type,lastId,artwork.getTitle(),artwork.getDescription(),artwork.getArtist(),artwork.getYearCreated(),artwork.getPrimaryPicture());
        int result = connection.insert(inserQuery);
        if (result>0){
            if (artwork instanceof Sculpture){
                Sculpture sculpture = (Sculpture) artwork;
                String inserSculpture = String.format("INSERT INTO %s (artwork_spec_id,dimension_x, dimension_y, dimension_z,material) VALUES (%d,%f,%f,%f,'%s')",SCULPTURE,
                        lastId,sculpture.getWidth(),sculpture.getHeight(),sculpture.getDepth(),sculpture.getMaterial());
                return connection.insert(inserSculpture);
            }else if (artwork instanceof Painting){
                Painting painting = (Painting)  artwork;
                String inserPainting = String.format("INSERT INTO %s (artwork_spec_id,dimension_x, dimension_y) VALUES (%d,%f,%f)",PAINTING,
                        lastId,painting.getWidth(),painting.getHeight());
                return connection.insert(inserPainting);
            }
        }
        return 0;
    }
}
