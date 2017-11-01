import java.sql.Timestamp;
import java.util.ArrayList;

//TODO: Add creator comment

public class Auction {
    /**
     * Bid history
     */
    private ArrayList<Bid> bids = new ArrayList<>();
    /**
     * The artwork being placed on auction
     */
    private Artwork artwork;
    /**
     * The user who created the auction
     */
    private User creator;
    /**
     *  Current price of an item
     */
    private double currentPrice;
    /**
     *  Minimum reservation price
     */
    private double reservePrice;
    /**
     *  Date the auction was created
     */
    private Timestamp dateAdded;
    /**
     *  Maximum number of bids
     */
    private int maxBids;


    public Auction(Artwork artwork, User creator, double currentPrice, double reservePrice, int maxBids) {
        this.artwork = artwork;
        this.creator = creator;
        this.currentPrice = currentPrice;
        this.reservePrice = reservePrice;
        this.maxBids = maxBids;
        dateAdded = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Place a bid
     *
     * @return 0 if the bid is placed successfully, 1 or 2 otherwise (see below)
     */
    public int placeBid(User user, double amount) {
        //Check if the bid is above reserve price and the current highest bidder
        if (amount < reservePrice || amount < currentPrice) {
            return 1; //Placed bid below reserve price or highest bidder
        }
        //Check if the max amount of bids has already been exceeded
        else if (bids.size() >= maxBids) {
            return 2; //Maximum amount of bids has been exceeded
        }
        //Add a new Bid entry if all both checks are postive
        else {
            bids.add(new Bid(user, amount));
            currentPrice += amount;
            return 0; //Bid successfully placed
        }
    }

    /**
     * Number of allowed bids left
     * @return bids amount
     */
    public int bidsLeft(){
        return maxBids - bids.size();
    }

    /**
     * Gets the most recently placed bid
     *
     * @return The most recently placed bid
     */
    public Bid getMostRecentBid() {
        return bids.get(bids.size() - 1);
    }

    /**
     * Gets a bid at the specified positon in the list
     *
     * @return A Bid object
     */
    public Bid getBidByIndex(int index) {
        return bids.get(index);
    }


    public Artwork getArtwork() {
        return artwork;
    }

    public User getCreator() {
        return creator;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getReservePrice() {
        return reservePrice;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public int getMaxBids() {
        return maxBids;
    }
}
