package dataAccessObjects;

import artatawe.Auction;
import artatawe.DBUtils;
import artatawe.SQLiteSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Auction dao.
 */
public class AuctionDao {
    /**
     * Get the connection form the class - SQLiteSingleton.
     */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();

    /**
     * Retrieve all of the auctions from the database.
     *
     * @return Return a list of auctions from the database.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Auction> getAllAuctions(String type, boolean byUser, int userId) throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        String query = "SELECT * FROM Auction INNER JOIN Artwork ON Auction.artwork_id = Artwork.artwork_id";
        if (type != "all") {
            query += " WHERE Artwork.artwork_type = '" + type + "'";
        }
        if (byUser) {
            query += " AND Auction.user_id = " + userId + ";";
        }
        ResultSet auctionResultSet = connection.query(String.format(query));

        while (auctionResultSet.next()) {
            Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);
            auctions.add(this.getAuction(auction.getAuctionId()));
        }

        return auctions;
    }

    /**
     * Retrieve those auctions that user has participated in from the database.
     *
     * @return Return a list of auctions from the database.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Auction> getAutionsByUser(int userId) throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        String retrieveQuery = String.format("SELECT * FROM auction a, " +
                "(SELECT auction_id FROM bid WHERE user_id = %d ) b " +
                "WHERE a.auction_id = b.auction_id ", userId);
        ResultSet auctionResultSet = connection.query(retrieveQuery);

        while (auctionResultSet.next()) {
            Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);
            auctions.add(this.getAuction(auction.getAuctionId()));
        }

        return auctions;
    }

    /**
     * Get an auction from database by auction's id.
     *
     * @param auctionId The id of an auction that is wanted to be searched.
     * @return Return the wanted auction.
     * @throws SQLException Throws sql exception if there is any connection error.
     */

    public Auction getAuction(int auctionId) throws SQLException {
        ResultSet auctionResultSet = connection.query(
                String.format("SELECT * FROM Auction WHERE auction_id = %s", auctionId));
        Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);

        BidDao bidDao = new BidDao();

        auction.setNewBidList(bidDao.getAuctionBids(auctionId));

        return auction;
    }

    /**
     * Update an auction information into the database.
     *
     * @param auction The auction that is wanted to be update into the database.
     * @return Return any integer except 0 if update successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int updateAuction(Auction auction, int auctionId) throws SQLException {
        return connection.insert(String.format("UPDATE Auction " +
                        "SET artwork_id = %s, user_id = %s, reserved_price = %s, max_bids = %s " +
                        "WHERE auction_id = %s",
                auction.getArtwork().getArtworkId(),
                auction.getCreator().getUserId(),
                auction.getReservePrice(),
                auction.getMaxBids(),
                auctionId));
    }

    /**
     * Insert an auction into the database.
     *
     * @param auction The auction that is wanted to be inserted into the database.
     * @return Return any integer except 0 if insert successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int insertAuction(Auction auction) throws SQLException {

        ArtworkDao artworkDao = new ArtworkDao();
        artworkDao.insertArtwork(auction.getArtwork());

        String query = String.format("INSERT INTO Auction (artwork_id,max_bids,reserved_price,timestamp,user_id)" +
                        " VALUES(%d, %d, %.2f, %d, %d)",
                artworkDao.getLastId(),
                auction.getMaxBids(),
                auction.getReservePrice(),
                auction.getDateAdded().getTime(),
                auction.getCreator().getUserId());

        return connection.insert(query);
    }

    /**
     * Delete an auction from the database.
     *
     * @param auction The auction that is wanted to be deleted from database.
     * @return Return any integer except 0 if delete successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int deleteAuction(Auction auction) throws SQLException {
        String query = String.format("DELETE FROM Auction WHERE auction_id  = %s",
                auction.getAuctionId());
        return connection.insert(query);

    }


    /**
     * Gets last auction's id of an auction table in the database.
     *
     * @return last auction's id
     * @throws SQLException
     */
    public int getLastId() throws SQLException {
        String query = "SELECT seq FROM sqlite_sequence WHERE name='auction'";
        return connection.query(query).getInt("seq");
    }


    /**
     * Checks if user has an auction in wishlist
     *
     * @param userId    the user id
     * @param auctionId the auction id
     * @return isWished boolean
     * @throws SQLException the sql exception
     */
    public boolean isWished(int userId, int auctionId) throws SQLException {
        ResultSet wishedResultSet = connection.query(
                String.format("SELECT * FROM wish_list WHERE auction_id = %s and user_id = %s", auctionId, userId));
        return wishedResultSet.isBeforeFirst();
    }


    /**
     * Either adds or removes an auction from wished.
     *
     * @param userId    the user id
     * @param auctionId the auction id
     * @param wish      wish status
     * @return result code
     * @throws SQLException the sql exception
     */
    public int updateWished(int userId, int auctionId, boolean wish) throws SQLException {
        String query;
        if (wish) {
            query = String.format("INSERT INTO wish_list (user_id, auction_id) VALUES(%s, %s)", userId, auctionId);
        } else {
            query = String.format("DELETE FROM wish_list WHERE auction_id = %s and user_id = %s", auctionId, userId);
        }
        return connection.insert(query);
    }


    /**
     * Gets auctions wished by user.
     *
     * @param userId the user id
     * @return the auctions wished by user
     * @throws SQLException the sql exception
     */
    public List<Auction> getAuctionsWishedByUser(int userId) throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        ResultSet wishedResultSet = connection.query(
                String.format("SELECT auction_id FROM wish_list WHERE user_id = %s", userId));

        while (wishedResultSet.next()) {
            auctions.add(getAuction(wishedResultSet.getInt("auction_id")));
        }

        return auctions;
    }
}