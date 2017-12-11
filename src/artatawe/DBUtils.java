package artatawe;

import dataAccessObjects.AddressDao;
import dataAccessObjects.ArtworkDao;
import dataAccessObjects.BidDao;
import dataAccessObjects.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Contains various helpful functions related to database access.
 * @author Morgan David, Michael, Marcelli Wac, Tereza Pashinska, Kamil Klosowski, Goh Shu Yu
 * @version 1.0
 * @since 1-12-17
 */
public class DBUtils{

        /**
         * Construct result set from user object
         * @param rs Result set that wanted to construct into user object.
         * @return Return a user object after construction.
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
                rs.getString("avatar_filename"),
                userDao.getUsersFavourite(rs.getInt("user_id"))
        );
    }

    /**
     * Construct an address object from the result set.
     * @param rs The result set that is going to be used to construct an address object.
     * @return Return a address object after construction.
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
     * Construct an auction object from the result set.
     * @param rs The result set that is going to be used to construct an auction object.
     * @return Return a auction object after construction.
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
     * Construct a sculpute object from the result set.
     * @param rsArtwork Artwork's result set that is going to be used to construct an artwork object.
     * @param rsSculpture Sculpture's result set that is going to be used to construct a sculpute object.
     * @return Return a sculpture object after construction.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static Sculpture constructSculpture(ResultSet rsArtwork, ResultSet rsSculpture) throws SQLException {
        ArtworkDao artworkDao = new ArtworkDao();
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
                rsSculpture.getDouble("dimension_z"),
                artworkDao.getSculptureAdditionalPic(rsArtwork.getInt("artwork_spec_id")));
    }

    /**
     * Construct a painting object from the result set.
     * @param rsArtwork Artwork's result set that is going to be used to construct an artwork object.
     * @param rsPainting Painting's result set that is going to be used to construct a painting object.
     * @return Return a painting object after construction.
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
     * Construct a bid object from the result set.
     * @param rs The result set that is going to be used to construct a bid object.
     * @return Return a bid object after construction.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static Bid constructBidFromRS(ResultSet rs) throws SQLException {
        return new Bid(rs.getInt("user_id"),
                rs.getDouble("amount"),
                rs.getTimestamp("timestamp"));
    }

    /**
     * Construct a timestamp object from the result set.
     * @param rs The result set that is going to be used to construct a timestamp object.
     * @return Return a timestamp in millisecond after construction.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static long constructLoginLogFromRS(ResultSet rs) throws SQLException {
        return rs.getLong("timestamp");
    }

    /**
     * Construct a favorite user's Id from result set.
     * @param rs The result set that is going to be used to construct a favorite user's Id.
     * @return Return a user's id after construction.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public static int constructFavouriteFromRS(ResultSet rs) throws SQLException {
        return rs.getInt("fav_id");
    }

}
