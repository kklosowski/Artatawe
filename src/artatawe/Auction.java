/**
 * Contains information about an auction
 *
 * @author randompasser (Michael)
 * @since 27-10-17
 */

package artatawe;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Auction {

    private int auctionId;
    /**
     * Bid history
     */
    private List<Bid> bids = new ArrayList<>();
    /**
     * The artwork being placed on auction
     */
    private Artwork artwork;
    /**
     * The user who created the auction
     */
    private User creator;
    /**
     * Current price of an item
     */
    private double currentPrice;
    /**
     * Minimum reservation price
     */
    private double reservePrice;
    /**
     * Date the auction was created
     */
    private Timestamp dateAdded;
    /**
     * Maximum number of bids
     */
    private int maxBids;

    public Auction(User creator, double currentPrice, double reservePrice, int maxBids, Artwork artwork) {
        this.artwork = artwork;
        this.creator = creator;
        this.currentPrice = currentPrice;
        this.reservePrice = reservePrice;
        this.maxBids = maxBids;
        this.dateAdded = new Timestamp(System.currentTimeMillis());
    }

    public Auction(int actionId, User creator, double currentPrice, double reservePrice, int maxBids, Artwork artwork) {
        this(creator, currentPrice, reservePrice, maxBids, artwork);
        this.auctionId = actionId;
    }

    /**
     * Place a bid
     *
     * @return 0 if the bid is placed successfully, 1 or 2 otherwise (see below)
     */
    public int placeBid(User user, double amount) {
        //Check if the bid is above reserve price and the current highest bidder
        if (amount < reservePrice || amount <= currentPrice) {
            return 1; //Placed bid below reserve price or highest bidder
        }
        //Check if the max amount of bids has already been exceeded
        else if (bids.size() >= maxBids) {
            return 2; //Maximum amount of bids has been exceeded
        }
        //Check if user is not the last one that placed bid
        else if (bids.get(bids.size() - 1).getUserId() == user.getUserId()) {
            return 3;
        }
        //Add a new Bid entry if all both checks are postive
        else {
            bids.add(new Bid(user.getUserId(), amount));
            currentPrice = amount;
            return 0; //Bid successfully placed
        }
    }

    /**
     * assigns a new list, all values from old list are lost.
     *
     * @param bids amount
     */
    public void setNewBidList(List<Bid> bids) {
        this.bids = bids;
    }

    /**
     * Number of allowed bids left
     *
     * @return bids amount
     */
    public int bidsLeft() {
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

    /**
     * Gets the artwork being placed on auction
     *
     * @return A Artwork object
     */
    public Artwork getArtwork() {
        return artwork;
    }

    /**
     * Gets the user who created the auction
     *
     * @return A user object
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Gets the current price of the auction
     *
     * @return Current price of the auction
     */
    public double getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Gets the reserve price of the auction
     *
     * @return Reserve price of the auction
     */
    public double getReservePrice() {
        return reservePrice;
    }

    /**
     * Gets the creation date of the auction
     *
     * @return Creation date of the auction
     */
    public Timestamp getDateAdded() {
        return dateAdded;
    }

    /**
     * Gets the maximum amount of bids allowed
     *
     * @return Maximum amount of bids allowed
     */
    public int getMaxBids() {
        return maxBids;
    }

    public int getAuctionId() {
        return auctionId;
    }
}
