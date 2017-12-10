package dataAccessObjects;

import artatawe.Auction;
import artatawe.DBUtils;
import artatawe.SQLiteSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kamil Klosowski, Morgan David
 * @since 1/12/2017
 */
public class AuctionDao {
    /**
     * Get the connection form the class - SQLiteSingleton.
     */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();

    /**
     * Retrieve all of the auction from database..
     * @return Return a list of auction from database.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Auction> getAllAuctions() throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        ResultSet auctionResultSet = connection.query(String.format("SELECT * FROM Auction"));

        while (auctionResultSet.next()) {
            Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);
            auctions.add(this.getAuction(auction.getAuctionId()));
        }

        return auctions;
    }
    /**
     * Get an auction from database by auction id.
     * @param auctionId The id of an auction that wanted to search.
     * @return Return an searched auction.
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
     * Update an auction information into database.
     * @param auction The auction that wanted to update into database.
     * @return Return any integer except 0 if update successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int updateAuction(Auction auction, int auctionId) throws SQLException {
        return connection.insert(String.format("UPDATE Auction " +
                        "SET artwork_id = %s, user_id = %s, current_price = %s, reserve_price = %s, date_added = %s, max_bids = %s " +
                        "WHERE auction_id = %s",
                auction.getArtwork().getArtworkId(),
                auction.getCreator().getUserId(),
                auction.getCurrentPrice(),
                auction.getReservePrice(),
                auction.getDateAdded(),
                auction.getMaxBids(),
                auction.getAuctionId()));
    }
    /**
     * Insert an auction into database.
     * @param auction The auction that wanted to insert into database.
     * @return Return any integer except 0 if insert successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int insertAuction(Auction auction) throws SQLException {
        return connection.insert(String.format("INSERT INTO Auction (%s, %s, %s, %s, %s, %s, %s)",
                auction.getAuctionId(),
                auction.getArtwork().getArtworkId(),
                auction.getCreator().getUserId(),
                auction.getCurrentPrice(),
                auction.getReservePrice(),
                auction.getDateAdded(),
                auction.getMaxBids()));
    }
    /**
     * Delete an auction from database.
     * @param auction The auction that wanted to delete from database.
     * @return Return any integer except 0 if delete successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int deleteAuction(Auction auction) throws SQLException {
        return connection.insert(String.format("DELETE FROM Auction WHERE auction_id = %s",
                auction.getAuctionId()));

    }
}
