import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static User constructUserFromRS(ResultSet rs){
        return null;
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
