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
        Artwork artwork = new Sculpture();
        return new Auction(artwork,//Don't know how to handle the fact that the Auction constructor takes an Auction, and User object rather than an ID. Using ID for now.
                           userDao.getUser(rs.getInt("user_id")),
                           rs.getDouble("current_price"),
                           rs.getDouble("reserve_price"),
                           rs.getInt("max_bids"));
      
    }

    public static Artwork constructArtworkFromRS(ResultSet rs){
        return null;
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
