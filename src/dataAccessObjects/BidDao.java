package dataAccessObjects;

import artatawe.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Database access object for the Bid class
 * @author Kamil Klosowski
 * @since 1/12/2017
 */
public class BidDao {
    /**
     * Get the connection form the class - SQLiteSingleton.
     */

    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    /**
     * Get all of the bits by a user and search by user id.
     * @param userId User's id that wanted to get the bids.
     * @return Return a list of bids by the user id.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Bid> getUserBids(int userId) throws SQLException {

        List<Bid> bids = new ArrayList<>();
        ResultSet bidsResultSet = connection.query(
                String.format("SELECT * FROM Bid WHERE user_id = %d", userId));

        while (bidsResultSet.next()) {
            bids.add(DBUtils.constructBidFromRS(bidsResultSet));
        }

        return bids;
    }
    /**
     * Get all of the bits by a user.
     * @param user User that wanted to get the bids.
     * @return Return a list of bids by the user.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Bid> getUserBids(User user) throws SQLException {
        return getUserBids(user.getUserId());
    }
    /**
     * Get all of the bits of an auction and search by auction id.
     * @param auctionId Auction's id that wanted to get the bids.
     * @return Return a list of bids by the auction id.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Bid> getAuctionBids(int auctionId) throws SQLException {

        List<Bid> bids = new ArrayList<>();
        ResultSet bidsResultSet = connection.query(
                String.format("SELECT * FROM Bid WHERE auction_id = %d", auctionId));

        while (bidsResultSet.next()) {
            bids.add(DBUtils.constructBidFromRS(bidsResultSet));
        }
        return bids;
    }

    /**
     * Get the highest bit of an auction .
     * @param auctionId Auction's id that search the highest bids.
     * @return Return a the highest bids of the auction .
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public Bid getHighestBid(int auctionId) {
        Bid highestBid = null;
        try {
            highestBid = getAuctionBids(auctionId).stream().sorted(Comparator.comparing(Bid::getAmount)).findFirst().get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return highestBid;
    }
    /**
     * Place new bid into database.
     * @param bid New bid information that user placed.
     * @param auction Auction that user wanted to bid.
     * @return Return any integer except 0 if insert successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int insertBid(Bid bid, Auction auction) throws SQLException {
        return insertBid(bid, auction.getAuctionId());
    }
    /**
     * Place new bid into database.
     * @param bid New bid information that user placed.
     * @param auctionId Auction's id that user wanted to bid.
     * @return Return any integer except 0 if insert successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int insertBid(Bid bid, int auctionId) throws SQLException {
        return connection.insert(String.format("INSERT INTO Bid VALUES(%d, %.2f, %d, %d)",
                bid.getUserId(),
                bid.getAmount(),
                bid.getTimestamp().getTime(),
                auctionId));
    }
    /**
     * Delete a bid from database.
     * @param bid The bid that wanted to remove from database..
     * @return Return any integer except 0 if delete successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int deleteBid(Bid bid) throws SQLException {
        return connection.insert(String.format("DELETE FROM Bid WHERE user_id = %d AND timestamp = %d",
                bid.getUserId(),
                bid.getTimestamp().getTime()));
    }
}
