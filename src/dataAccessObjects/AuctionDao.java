package dataAccessObjects;

import artatawe.Auction;
import artatawe.DBUtils;
import artatawe.SQLiteSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Database access object for the Auction class
 * @author Kamil Klosowski, Morgan David
 * @version 1.0
 * @since 1-12-17
 */
public class AuctionDao {
    /**
     * Get the connection form the class - SQLiteSingleton.
     */
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();

    /**
     * Retrieve all of the auctions from the database.
     * @return Return a list of auctions from the database.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Auction> getAllAuctions(String type, boolean byUser, int userId) throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        String query = "SELECT * FROM Auction INNER JOIN Artwork ON Auction.artwork_id = Artwork.artwork_id";
        if(type != "all"){
            query += " WHERE artwork.type = '" + type + "'";
        }
        if(byUser){
            query += " AND auction.user_id = " + userId + ";";
        }
        ResultSet auctionResultSet = connection.query(String.format("SELECT * FROM Auction"));

        while (auctionResultSet.next()) {
            Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);
            auctions.add(this.getAuction(auction.getAuctionId()));
        }

        return auctions;
    }
    /**
     * Retrieve those auctions that user has participated in from the database.
     * @return Return a list of auctions from the database.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public List<Auction> getAutionsByUser(int userId) throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        String retrieveQuery = String.format("SELECT * FROM auction a, " +
                "(SELECT auction_id FROM bid WHERE user_id = %d ) b " +
                "WHERE a.auction_id = b.auction_id ",userId);
        ResultSet auctionResultSet = connection.query(retrieveQuery);

        while (auctionResultSet.next()) {
            Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);
            auctions.add(this.getAuction(auction.getAuctionId()));
        }

        return auctions;
    }
    /**
     * Get an auction from database by auction's id.
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
     * @param auction The auction that is wanted to be inserted into the database.
     * @return Return any integer except 0 if insert successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int insertAuction(Auction auction) throws SQLException{
        System.out.println("time "+ auction.getDateAdded());
        String query = String.format("INSERT INTO Auction (artwork_id,bids_total,reserved_price,timestamp,user_id)" +
                        " VALUES(%d, %d, %.2f, %d, %d)",
                getLastId()+1,
                auction.getMaxBids(),
                auction.getReservePrice(),
                auction.getDateAdded().getTime(),
                auction.getCreator().getUserId());
        return connection.insert(query);
    }
    /**
     * Delete an auction from the database.
     * @param auction The auction that is wanted to be deleted from database.
     * @return Return any integer except 0 if delete successfully, if not it will return 0.
     * @throws SQLException Throws sql exception if there is any connection error.
     */
    public int deleteAuction(Auction auction) throws SQLException {
        String query = String.format("DELETE FROM Auction WHERE auction_id  = %s",
                auction.getAuctionId());
        return connection.insert(query);

    }

    //get last auction's id of an auction table in the database.
    public int getLastId() throws SQLException {
        String query = "SELECT seq FROM sqlite_sequence WHERE name='auction'";
        return connection.query(query).getInt("seq");
    }
}
