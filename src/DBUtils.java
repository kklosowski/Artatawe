import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DBUtils {

    public static User constructUserFromRS(ResultSet rs)throws SQLException{
        AddressDao addressDao = new AddressDao();
        return new User(rs.getInt("user_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("username"),
                rs.getString("mobile_phone"),
                addressDao.getAddress(rs.getInt("user_id")),
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
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

    public static Auction constructAuctionFromRS(ResultSet rs){
        return null;
    }

    public static Artwork constructArtworkFromRS(ResultSet rs){
        return null;
    }

    public static Bid constructBidFromRS(ResultSet rs) throws SQLException {
        return new Bid(rs.getInt("user_id"),
                rs.getDouble("amount"),
                rs.getTimestamp("timestamp"));
    }

}
