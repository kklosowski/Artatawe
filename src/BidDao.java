import java.util.List;

/**
 *
 * @author  Kamil Klosowski
 * @since   1/12/2017
 */
public class BidDao {
    public List<Bid> getUserBids(int userId){
        return null;
    }

    public List<Bid> getUserBids(User user){
        return getUserBids(user.getUserId());
    }

    public List<Bid> getAuctionBids(int auctionId){
        return null;
    }

    public int insertBid(Bid bid, Auction auction){
        return insertBid(bid, auction.getAuctionId());
    }

    public int insertBid(Bid bid, int auctionId){
        return 0;
    }

    public int deleteBid(Bid bid){
        return 0;
    }
}
