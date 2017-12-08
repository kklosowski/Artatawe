import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DBUtils {

    public static User constructUserFromRS(ResultSet rs)throws SQLException{
        AddressDao addressDao = new AddressDao();
        UserDao userDao = new UserDao();
        return new User(rs.getInt("user_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("username"),
                rs.getString("mobile_number"),
                addressDao.getAddress(rs.getInt("user_id")),
                new Timestamp(userDao.getLoginLog(rs.getInt("user_id"))),
                rs.getString("avatar_filename")
                );
    }
    public static Address constructAddressFromRS(ResultSet rs) throws SQLException{
        return new Address(rs.getString("address_line1"),
                rs.getString("address_line2"),
                rs.getString("address_line2"),
                rs.getString("city"),
                rs.getString("postcode"),
                rs.getString("country"));
    }

    public static Auction constructAuctionFromRS(ResultSet rs) throws SQLException{
        UserDao userDao = new UserDao();
        ArtworkDao artworkDao = new ArtworkDao();
        return new Auction(artworkDao.getArtwork(rs.getInt("artwork_id")),
                           userDao.getUser(rs.getInt("user_id")),
                           rs.getDouble("current_price"),
                           rs.getDouble("reserve_price"),
                           rs.getInt("max_bids"));
    }

        public static Sculpture constructSculpture(ResultSet rsArtwrok, ResultSet rsSculture) throws SQLException{
        return new Sculpture(
                rsArtwrok.getInt("artwork_id"),
                rsArtwrok.getString("title"),
                rsArtwrok.getString("description"),
                rsArtwrok.getString("artist"),
                rsArtwrok.getString("picture_location"),
                rsArtwrok.getInt("year_created"),
                rsSculture.getString("material"),
                rsSculture.getDouble("dimension_x"),
                rsSculture.getDouble("dimension_y"),
                rsSculture.getDouble("dimension_z"));
    }
    public static Painting constructPaintingFromRS(ResultSet rsArtwrok, ResultSet rsPainting) throws SQLException{
        return new Painting(
                rsArtwrok.getInt("artwork_id"),
                rsArtwrok.getString("title"),
                rsArtwrok.getString("description"),
                rsArtwrok.getString("artist"),
                rsArtwrok.getString("picture_location"),
                rsArtwrok.getInt("year_created"),
                rsPainting.getDouble("dimension_x"),
                rsPainting.getDouble("dimension_y"));
    }

    public static Bid constructBidFromRS(ResultSet rs) throws SQLException {
        return new Bid(rs.getInt("user_id"),
                rs.getDouble("amount"),
                rs.getTimestamp("timestamp"));
    }
    public static long constructLoginLogFromRS(ResultSet rs) throws SQLException{
        return rs.getLong("timestamp");
    }
    public static int constructFavouriteFromRS(ResultSet rs) throws SQLException{
        return rs.getInt("fav_id");
    }

}
