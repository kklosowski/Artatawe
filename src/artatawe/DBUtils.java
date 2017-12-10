package artatawe;

import dataAccessObjects.AddressDao;
import dataAccessObjects.ArtworkDao;
import dataAccessObjects.BidDao;
import dataAccessObjects.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBUtils {
    /**
     * Construct result set into user object
     * @param rs Result set that wanted to construct into user object.
     * @return Return a user object after construct.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static User constructUserFromRS(ResultSet rs) throws SQLException {
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

    /**
     * Construct result set into address object
     * @param rs Result set that wanted to construct into address object.
     * @return Return a address object after construct.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static Address constructAddressFromRS(ResultSet rs) throws SQLException {
        return new Address(rs.getString("address_line1"),
                rs.getString("address_line2"),
                rs.getString("address_line3"),
                rs.getString("city"),
                rs.getString("postcode"),
                rs.getString("country"));
    }

    /**
     * Construct result set into auction object
     * @param rs Auction's result set that wanted to construct into auction object.
     * @return Return a auction object after construct.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static Auction constructAuctionFromRS(ResultSet rs) throws SQLException {
        UserDao userDao = new UserDao();
        ArtworkDao artworkDao = new ArtworkDao();
        BidDao bidDao = new BidDao();
        return new Auction(rs.getInt("auction_id"),
                userDao.getUser(rs.getInt("user_id")),
                bidDao.getHighestBid(rs.getInt("user_id")).getAmount(),
                rs.getDouble("reserved_price"),
                rs.getInt("bids_left"),
                artworkDao.getArtwork(rs.getInt("artwork_id")));
    }

    /**
     * Construct result sets into sculpture object
     * @param rsArtwork Artwork's result set that wanted to construct into sculpture object.
     * @param rsSculpture Sculpture's result set that wanted to construct into sculpture object.
     * @return Return a sculpture object after construct.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static Sculpture constructSculpture(ResultSet rsArtwork, ResultSet rsSculpture) throws SQLException {
        return new Sculpture(
                rsArtwork.getInt("artwork_id"),
                rsArtwork.getString("title"),
                rsArtwork.getString("description"),
                rsArtwork.getString("artist"),
                rsArtwork.getString("primary_picture_url"),
                rsArtwork.getInt("year_created"),
                rsSculpture.getString("material"),
                rsSculpture.getDouble("dimension_x"),
                rsSculpture.getDouble("dimension_y"),
                rsSculpture.getDouble("dimension_z"));
    }

    /**
     * Construct result set into painting object
     * @param rsArtwork Artwork's result set that wanted to construct into painting object.
     * @param rsPainting Sculpture's result set that wanted to construct into painting object.
     * @return Return a painting object after construct.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static Painting constructPaintingFromRS(ResultSet rsArtwork, ResultSet rsPainting) throws SQLException {
        return new Painting(
                rsArtwork.getInt("artwork_id"),
                rsArtwork.getString("title"),
                rsArtwork.getString("description"),
                rsArtwork.getString("artist"),
                rsArtwork.getString("primary_picture_url"),
                rsArtwork.getInt("year_created"),
                rsPainting.getDouble("dimension_x"),
                rsPainting.getDouble("dimension_y"));
    }

    /**
     * Construct result set into bid object
     * @param rs Result set that wanted to construct into bid object.
     * @return Return a bid object after construct.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static Bid constructBidFromRS(ResultSet rs) throws SQLException {
        return new Bid(rs.getInt("user_id"),
                rs.getDouble("amount"),
                rs.getTimestamp("timestamp"));
    }

    /**
     * Construct result set into timestamp in millisecond
     * @param rs Result set that wanted to construct into timestamp.
     * @return Return a timestamp in millisecond after construct.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static long constructLoginLogFromRS(ResultSet rs) throws SQLException {
        return rs.getLong("timestamp");
    }

    /**
     * Construct result set into favorite user id.
     * @param rs Result set that wanted to construct into favorite user's id.
     * @return Return a user's id .
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static int constructFavouriteFromRS(ResultSet rs) throws SQLException {
        return rs.getInt("fav_id");
    }

}
