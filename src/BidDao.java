import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                String.format("SELECT * FROM Bid WHERE user_id = %s", userId));

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
                String.format("SELECT * FROM Bid WHERE auction_id = %s", auctionId));

        while (bidsResultSet.next()){
            bids.add(DBUtils.constructBidFromRS(bidsResultSet));
        }
        return bids;
    }

    public void insertBid(Bid bid, Auction auction) throws SQLException {
        insertBid(bid, auction.getAuctionId());
    }

    public void insertBid(Bid bid, int auctionId) throws SQLException {
        connection.insert(String.format("INSERT INTO Bid (%1%s, %2%s, %3%s, %4%s)",
                bid.getUserId(),
                bid.getAmount(),
                bid.getTimestamp(),
                auctionId));
    }

    public void deleteBid(Bid bid) throws SQLException {
        connection.query(String.format("DELETE FROM Bid WHERE user_id = %1%s AND timestamp = %2%s",
                bid.getUserId(),
                bid.getTimestamp()));
    }
}
