package dataAccessObjects;

import artatawe.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Database access object for the Artwork class
 * @author  Goh Shu Yu, Michael Lam
 * @version 1.0
 * @since 4/12/2017
 */
public class ArtworkDao {
    /**
     * Get the connection form the class - SQLiteSingleton.
     */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    /**
     * Name of artwork table in database.
     */
    private final String ARTWORK_TABLE = "artwork";
    /**
     * Name of painting table in database.
     */
    private final String SCULPTURE = "sculpture";
    /**
     * Name of painting table in database.
     */
    private final String PAINTING = "painting";
    /**
     * Name of sculpture picture table in database.
     */
    private final String SCULPTURE_PIC = "sculpturepic";


    /**
     * Retrieve an artwork from database by given artwork's id.
     * @param artwork_id The artwork's id that is wanted to be searched.
     * @return Return an artwork by given artwork id, return null if it doesn't exist in database.
     * @throws SQLException Throws sql exception if there is any connection error.
     * */
    public Artwork getArtwork(int artwork_id) throws SQLException {
        String searchArtworkQuery = String.format("SELECT * FROM %s WHERE artwork_id = %d",
                ARTWORK_TABLE, artwork_id);
        ResultSet rs = connection.query(searchArtworkQuery);
        if (rs.next()) {
            return searchArtworkByType(rs);
        }
        return null;
    }

    /**
     * Retrieve all artworks from the database.
     * @return Return a list of artworks.
     * @throws SQLException Throws sql exception if there is any connection error.
     * */
    public List<Artwork> getAllArtwork() throws SQLException {
        List<Artwork> artworks = new ArrayList<>();
        String getQuery = String.format("SELECT * FROM %s", ARTWORK_TABLE);
        ResultSet rs = connection.query(getQuery);
        while (rs.next()) {
            artworks.add(searchArtworkByType(rs));
        }
        return artworks;
    }
// A method to search and return an artwork from database regarding to different type of artwork (sculpture / painting)
    private Artwork searchArtworkByType(ResultSet rs) throws SQLException {
        if (rs.getString("artwork_type").equals(SCULPTURE)) {
            String searchSculpture = String.format("SELECT * FROM %s WHERE artwork_spec_id = %d ", SCULPTURE, rs.getInt("artwork_id"));
            ResultSet sculptureRs = connection.query(searchSculpture);
            if (sculptureRs.next()) {
                return DBUtils.constructSculpture(rs, sculptureRs);
            }
        } else if (rs.getString("artwork_type").equals(PAINTING)) {
            String searchPainting = String.format("SELECT * FROM %s WHERE artwork_spec_id = %d ", PAINTING, rs.getInt("artwork_id"));
            ResultSet paintingRs = connection.query(searchPainting);
            if (paintingRs.next()) {
                return DBUtils.constructPaintingFromRS(rs, paintingRs);
            }
        }
        return null;
    }

    /**
     * Update the artwork information into the database.
     * @param artwork The artwork that is wanted to be updated into the database.
     * @return Return any integer except 0 if update successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     * */
    public int updateArtwork(Artwork artwork) throws SQLException {
        System.out.println("trying ");
        String updateArtworkQuery = String.format("UPDATE %s SET title = '%s', description = '%s'," +
                        " artist = '%s', year_created = %d WHERE artwork_id = %d", ARTWORK_TABLE, artwork.getTitle(), artwork.getDescription(),
                artwork.getArtist(), artwork.getYearCreated(), artwork.getArtworkId());
        System.out.println("update " + updateArtworkQuery);
        int result = connection.insert(updateArtworkQuery);
        System.out.println("result " + result);
        if (result > 0) {
            if (artwork instanceof Sculpture) {
                Sculpture sculpture = (Sculpture) artwork;
                String updateSculpture = String.format("UPDATE '%s' SET dimension_x = %f,dimension_y = %f, " +
                                "dimension_z = %f , material = '%s' WHERE artwork_spec_id = %d", SCULPTURE, sculpture.getHeight()
                        , sculpture.getWidth(), sculpture.getDepth(), sculpture.getMaterial(), sculpture.getArtworkId());
                return connection.insert(updateSculpture);
            } else if (artwork instanceof Painting) {
                Painting painting = (Painting) artwork;
                String updateSculpture = String.format("UPDATE '%s' SET dimension_x = %f,dimension_y = %f " +
                                " WHERE artwork_spec_id = %d", PAINTING, painting.getHeight()
                        , painting.getWidth(), painting.getArtworkId());
                return connection.insert(updateSculpture);
            }
        }
        return 0;
    }

    /**
     * Delete an artwork from the database.
     * @param artwork The artwork that is wanted to be removed from the database.
     * @return Return any integer except 0 if delete successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     * */
    public int deleteArtwork(Artwork artwork) throws SQLException {
        int result = 0;
        if (artwork instanceof Sculpture) {
            String deleteScuplture = String.format("DELETE FROM '%s' WHERE artwork_spec_id = %d ", SCULPTURE, artwork.getArtworkId());
            result = connection.insert(deleteScuplture);
        } else if (artwork instanceof Painting) {
            String deletePainting = String.format("DELETE FROM '%s' WHERE artwork_spec_id = %d ", PAINTING, artwork.getArtworkId());
            result = connection.insert(deletePainting);
        }
        if (result > 0) {
            String deleteArtworkQuery = String.format("DELETE FROM %s WHERE artwork_id = %d",
                    ARTWORK_TABLE, artwork.getArtworkId());
            return connection.insert(deleteArtworkQuery);
        }
        return 0;
    }
    /**
     * Insert an artwork into the database.
     * @param artwork The artwork that is wanted to be inserted into the database.
     * @return Return any integer except 0 if insert successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     * */
    public int insertArtwork(Artwork artwork) throws SQLException {
        int lastId = getLastId();
        String type = "";
        if (artwork instanceof Sculpture) {
            type = SCULPTURE;
        } else if (artwork instanceof Painting) {
            type = PAINTING;
        }
        String inserQuery = String.format("INSERT INTO %s (artwork_id,artwork_type,artwork_spec_id,title,description,artist,year_created,primary_picture_url) VALUES (%d,'%s',%d,'%s','%s','%s',%d, '%s')", ARTWORK_TABLE,
                ++lastId, type, lastId, artwork.getTitle(), artwork.getDescription(), artwork.getArtist(), artwork.getYearCreated(), artwork.getPrimaryPicture());
        int result = connection.insert(inserQuery);
        if (result > 0) {
            if (artwork instanceof Sculpture) {
                Sculpture sculpture = (Sculpture) artwork;
                String inserSculpture = String.format("INSERT INTO %s (artwork_spec_id,dimension_x, dimension_y, dimension_z,material) VALUES (%d,%f,%f,%f,'%s')", SCULPTURE,
                        lastId, sculpture.getWidth(), sculpture.getHeight(), sculpture.getDepth(), sculpture.getMaterial());
                return connection.insert(inserSculpture);
            } else if (artwork instanceof Painting) {
                Painting painting = (Painting) artwork;
                String inserPainting = String.format("INSERT INTO %s (artwork_spec_id,dimension_x, dimension_y) VALUES (%d,%f,%f)", PAINTING,
                        lastId, painting.getWidth(), painting.getHeight());
                return connection.insert(inserPainting);
            }
        }
        return 0;
    }

    /**
     * Retrieve all of a sculpture's additional pictures from the database.
     * @param sculptureId Sculpture's id that is wanted to be able to get the additional pictures.
     * @return Return a list of string that contain sculpture additional pictures' url.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<String> getSculptureAdditionalPic(int sculptureId)throws SQLException{
        List<String> sculpturePic = new ArrayList<>();
        String retrieveQuery = String.format("SELECT * FROM %s WHERE artwork_spec_id = %d ",SCULPTURE_PIC,sculptureId);
        ResultSet rs = connection.query(retrieveQuery);

        while (rs.next()){
            sculpturePic.add(rs.getString("picture_url"));
        }
        return sculpturePic;
    }

    /**
     * Insert an additional picture of a sculpture into the database.
     * @param sculptureId The sculpture that is wanted to be inserted new picture into the database.
     * @param image_url The sculpture's image url.
     * @return Return any integer except 0 if insert successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     * */
    public int insertSculptureAdditionalPic(int sculptureId, String image_url)throws SQLException{
        String insertQuery = String.format("INSERT INTO %s (artwork_spec_id,picture_url) VALUES (%d,'%s')",
                SCULPTURE_PIC,sculptureId,image_url);
        return connection.insert(insertQuery);
    }

    /**
     * Delete an additional picture of a sculpture from the database.
     * @param sculptureId The sculpture  from which the user wants to delete a picture from the database.
     * @param image_url The sculpture's image url that is wanted to be deleted from the database.
     * @return Return any integer except 0 if delete successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     * */
    public int deleteSculptureAdditionalPic(int sculptureId, String image_url)throws SQLException{
        String insertQuery = String.format("DELETE FROM %s WHERE artwork_spec_id = %d and picture_url = '%s'",
                SCULPTURE_PIC,sculptureId,image_url);
        return connection.insert(insertQuery);
    }
    //get last artwork id of an artwork table in database.
    private int getLastId() throws SQLException {
        String query = "SELECT seq FROM sqlite_sequence WHERE name='artwork'";
        return connection.query(query).getInt("seq");
    }
    // A method to search and return an artwork from database regarding to different type of artwork (sculpture / painting)
    private Artwork searchArtworkByType(ResultSet rs) throws SQLException {
        if (rs.getString("artwork_type").equals(SCULPTURE)) {
            String searchSculpture = String.format("SELECT * FROM %s WHERE artwork_spec_id = %d ", SCULPTURE, rs.getInt("artwork_id"));
            ResultSet sculptureRs = connection.query(searchSculpture);
            if (sculptureRs.next()) {
                return DBUtils.constructSculpture(rs, sculptureRs);
            }
        } else if (rs.getString("artwork_type").equals(PAINTING)) {
            String searchPainting = String.format("SELECT * FROM %s WHERE artwork_spec_id = %d ", PAINTING, rs.getInt("artwork_id"));
            ResultSet paintingRs = connection.query(searchPainting);
            if (paintingRs.next()) {
                return DBUtils.constructPaintingFromRS(rs, paintingRs);
            }
        }
        return null;
    }

}
