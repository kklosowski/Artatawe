import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Kamil Klosowski, Morgan David
 * @since   1/12/2017
 */
public class AuctionDao {
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();

    public List<Auction> getAllAuctions() throws SQLException{
        List<Auction> auctions = new ArrayList<>();
        ResultSet auctionResultSet = connection.query(String.format("SELECT * FROM Auction"));

        while (auctionResultSet.next()){
            Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);
            auctions.add(this.getAuction(auction.getAuctionId()));
        }

        return auctions;
    }

    public Auction getAuction(int auctionId) throws SQLException{
        ResultSet auctionResultSet = connection.query(
                String.format("SELECT * FROM Auction WHERE auction_id = %s", auctionId));
        Auction auction = DBUtils.constructAuctionFromRS(auctionResultSet);

        BidDao bidDao = new BidDao();

        auction.setNewBidList(bidDao.getAuctionBids(auctionId));

        return auction;
    }

    public void updateAuction(Auction auction, int auctionId) throws SQLException{
        connection.query(String.format("UPDATE Auction " +
                        "SET artwork_id = %s, user_id = %s, current_price = %s, reserve_price = %s, date_added = %s, max_bids = %s " +
                        "WHERE auction_id = %s",
                auction.getArtwork().getArtworkId(),
                1,
                auction.getCurrentPrice(),
                auction.getReservePrice(),
                auction.getDateAdded(),
                auction.getMaxBids(),
                auction.getAuctionId()));
    }
    public void insertAuction(Auction auction) throws SQLException{
        connection.insert(String.format("INSERT INTO Auction (%s, %s, %s, %s, %s, %s, %s)",
                auction.getAuctionId(),
                auction.getArtwork().getArtworkId(),
                auction.getCreator().getUserId(),
                auction.getCurrentPrice(),
                auction.getReservePrice(),
                auction.getDateAdded(),
                auction.getMaxBids()));
    }

    public void deleteAuction(Auction auction) throws SQLException{
        connection.query(String.format("DELETE FROM Auction WHERE auction_id = %1%s",
                auction.getAuctionId()));

    }
}
