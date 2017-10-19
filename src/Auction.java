import java.util.Date;
import java.util.List;

/**
 * Created by Eter on 12/10/2017.
 */
public class Auction {

    private Artwork item;
    private double highestBid;
    private List<Bid> bidHistory;
    private boolean completed;
    private Date creationDate;



    public Auction(Artwork item, double highestBid, List<Bid> bidHistory, boolean completed) {
        this.item = item;
        this.highestBid = highestBid;
        this.bidHistory = bidHistory;
        this.completed = completed;
    }
}
