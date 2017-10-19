import java.util.Date;
import java.util.List;

/**
 * Created by Eter on 13/10/2017.
 */
public class Seller extends User {

    private List<Auction> currentAuctions;
    private List<Auction> completedAuctions;

    public Seller(String username, String firstName, String lastName, String mobileNumber, Address address, Date lastLogin, String profileImage, List<User> favouriteUsers, List<Bid> bidHistory, List<Auction> wonAuctions, List<Auction> currentAuctions, List<Auction> completedAuctions) {
        super(username, firstName, lastName, mobileNumber, address, lastLogin, profileImage, favouriteUsers, bidHistory, wonAuctions);
        this.currentAuctions = currentAuctions;
        this.completedAuctions = completedAuctions;
    }
}
