import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author  Kamil Klosowski, Michael Lam
 * @since   4/12/2017
 */
public class ArtworkDao {
    /**
     * Get the connection form the class - sqlitegingleton.
     * */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    /**
     * Address table name in database.
     * */
    private final String ADDRESS_TABLE_NAME = "artwork";


    public Artwork getArtwork(int artwork_id) throws SQLException{
        String searchArtworkQuery = String.format("SELECT * FROM %s WHERE artwork_id = %d", ADDRESS_TABLE_NAME, artwork_id);
        ResultSet rs = connection.query(searchArtworkQuery);

        if (rs.next()) {
            return DBUtils.constructArtworkFromRS(rs);
        }
        return null;
    }

    public int updateArtwork(Artwork artwork) throws SQLException{
        int artwork_id = artwork.getArtworkId();
        String title = artwork.getTitle();
        String description = artwork.getDescription();
        String artist = artwork.getArtist();
        String primaryPicture = artwork.getPrimaryPicture();
        int yearCreated = artwork.getYearCreated();

        String updateArtworkQuery = String.format("UPDATE %s SET artwork_id = %1%s, title = %2%s, description = %3%s, artist = %4%s, year_created = %5%d", ADDRESS_TABLE_NAME, artwork_id, title, description, artist, yearCreated);
        return connection.insert(updateArtworkQuery);
    }

    public int deleteArtwork(Artwork artwork) throws SQLException{
        int artwork_id = artwork.getArtworkId();
        String deleteArtworkQuery = String.format("DELETE FROM %s WHERE artwork_id = %d", ADDRESS_TABLE_NAME, artwork_id);
        return connection.insert(deleteArtworkQuery);
    }

    public int insertArtwork(Artwork artwork) throws SQLException{
        int artwork_id = artwork.getArtworkId();
        String title = artwork.getTitle();
        String description = artwork.getDescription();
        String artist = artwork.getArtist();
        String primaryPicture = artwork.getPrimaryPicture();
        int yearCreated = artwork.getYearCreated();

        String insertArtworkQuery = String.format("INSERT INTO %s (artwork_id, title, description, artist, year_created)", ADDRESS_TABLE_NAME);
        insertArtworkQuery += String.format(" VALUES (%1%d, %2%s, %3%s, %4%s, %5%d)", title, description, artist, yearCreated);

        return connection.insert(insertArtworkQuery); 
    }
}
