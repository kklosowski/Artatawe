package artatawe;

import dataAccessObjects.AddressDao;
import dataAccessObjects.ArtworkDao;
import dataAccessObjects.BidDao;
import dataAccessObjects.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBUtils {

    public static artatawe.User constructUserFromRS(ResultSet rs) throws SQLException {
        AddressDao addressDao = new AddressDao();
        UserDao userDao = new UserDao();
        return new artatawe.User(rs.getInt("user_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("username"),
                rs.getString("mobile_number"),
                addressDao.getAddress(rs.getInt("user_id")),
                new Timestamp(userDao.getLoginLog(rs.getInt("user_id"))),
                rs.getString("avatar_filename")
        );
    }

    public static artatawe.Address constructAddressFromRS(ResultSet rs) throws SQLException {
        return new artatawe.Address(rs.getString("address_line1"),
                rs.getString("address_line2"),
                rs.getString("address_line3"),
                rs.getString("city"),
                rs.getString("postcode"),
                rs.getString("country"));
    }

    public static artatawe.Auction constructAuctionFromRS(ResultSet rs) throws SQLException {
        UserDao userDao = new UserDao();
        ArtworkDao artworkDao = new ArtworkDao();
        BidDao bidDao = new BidDao();
        return new artatawe.Auction(rs.getInt("auction_id"),
                userDao.getUser(rs.getInt("user_id")),
                bidDao.getHighestBid(rs.getInt("user_id")).getAmount(),
                rs.getDouble("reserved_price"),
                rs.getInt("bids_left"),
                artworkDao.getArtwork(rs.getInt("artwork_id")));
    }

    public static artatawe.Sculpture constructSculpture(ResultSet rsArtwork, ResultSet rsSculture) throws SQLException {
        return new artatawe.Sculpture(
                rsArtwork.getInt("artwork_id"),
                rsArtwork.getString("title"),
                rsArtwork.getString("description"),
                rsArtwork.getString("artist"),
                rsArtwork.getString("primary_picture_url"),
                rsArtwork.getInt("year_created"),
                rsSculture.getString("material"),
                rsSculture.getDouble("dimension_x"),
                rsSculture.getDouble("dimension_y"),
                rsSculture.getDouble("dimension_z"));
    }

    public static artatawe.Painting constructPaintingFromRS(ResultSet rsArtwork, ResultSet rsPainting) throws SQLException {
        return new artatawe.Painting(
                rsArtwork.getInt("artwork_id"),
                rsArtwork.getString("title"),
                rsArtwork.getString("description"),
                rsArtwork.getString("artist"),
                rsArtwork.getString("primary_picture_url"),
                rsArtwork.getInt("year_created"),
                rsPainting.getDouble("dimension_x"),
                rsPainting.getDouble("dimension_y"));
    }

    public static artatawe.Bid constructBidFromRS(ResultSet rs) throws SQLException {
        return new artatawe.Bid(rs.getInt("user_id"),
                rs.getDouble("amount"),
                rs.getTimestamp("timestamp"));
    }

    public static long constructLoginLogFromRS(ResultSet rs) throws SQLException {
        return rs.getLong("timestamp");
    }

    public static int constructFavouriteFromRS(ResultSet rs) throws SQLException {
        return rs.getInt("fav_id");
    }

}
