import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author  Kamil Klosowski
 * @since   1/12/2017
 */
public class BidDao {

    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    public List<Bid> getUserBids(int userId) throws SQLException {

        List<Bid> bids = new ArrayList<>();
        ResultSet bidsResultSet = connection.query(
                String.format("SELECT * FROM Bid WHERE user_id = %d", userId));

        while (bidsResultSet.next()){
            bids.add(DBUtils.constructBidFromRS(bidsResultSet));
        }

        return bids;
    }

    public List<Bid> getUserBids(User user) throws SQLException {
        return getUserBids(user.getUserId());
    }

    public List<Bid> getAuctionBids(int auctionId) throws SQLException {

        List<Bid> bids = new ArrayList<>();
        ResultSet bidsResultSet = connection.query(
                String.format("SELECT * FROM Bid WHERE auction_id = %d", auctionId));

        while (bidsResultSet.next()){
            bids.add(DBUtils.constructBidFromRS(bidsResultSet));
        }
        return bids;
    }

    public Bid getHighestBid(int auctionId){
        Bid highestBid = null;
        try {
            highestBid = getAuctionBids(auctionId).stream().sorted(Comparator.comparing(Bid::getAmount)).findFirst().get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return highestBid;
    }

    public void insertBid(Bid bid, Auction auction) throws SQLException {
        insertBid(bid, auction.getAuctionId());
    }

    public int insertBid(Bid bid, int auctionId) throws SQLException {
        return connection.insert(String.format("INSERT INTO Bid VALUES(%d, %.2f, %d, %d)",
                bid.getUserId(),
                bid.getAmount(),
                bid.getTimestamp().getTime(),
                auctionId));
    }

    public int deleteBid(Bid bid) throws SQLException {
        return connection.insert(String.format("DELETE FROM Bid WHERE user_id = %d AND timestamp = %d",
                bid.getUserId(),
                bid.getTimestamp().getTime()));
    }
}
