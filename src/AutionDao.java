import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Kamil Klosowski
 * @since   1/12/2017
 */
public class AutionDao {
    private final SQLiteSingleton connection = SQLiteSingleton.getConnection();
    //TODO : error here

    public List<Auction> getAllAuctions() throws SQLException{
        List<Auction> auctions = new ArrayList<>();
        ResultSet auctionResultSet = connection.query(
                String.format("SELECT * FROM Auction"));

        while (auctionResultSet.next()){
            auctions.add(DBUtils.constructAuctionFromRS(auctionResultSet));
        }

        return auctions;
    }

    public Auction getAuction(int auctionId) throws SQLException{
        ResultSet auctionResultSet = connection.query(
                String.format("SELECT * FROM Auction WHERE auction_id = %s", auctionId));
        return DBUtils.constructAuctionFromRS(auctionResultSet);
    }

    public void updateAuction(Auction auction, int auctionId) throws SQLException{
        connection.query(String.format("UPDATE Auction SET artwork_id = %1%s, user_id = %2%s, current_price = %3%s, reserve_price = %4%s, date_added = %5%s, max_bids = %6%s WHERE auction_id = %7%s",
                auction.getArtwork().getArtworkId(),
                1,
                auction.getCurrentPrice(),
                auction.getReservePrice(),
                auction.getDateAdded(),
                auction.getMaxBids(),
                auction.getAuctionId()));
    }
    public void insertAuction(Auction auction) throws SQLException{
        connection.insert(String.format("INSERT INTO Auction (%1%s, %2%s, %3%s, %4%s, %5%s, %6%s, %7%s)",
                auction.getAuctionId(),
                auction.getArtwork().getArtworkId(),
                1,
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
