package artatawe;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Auction is a class to create new auctions containing 
 * all the needed information for an auction and handling the actions
 * associated with an auction.
 *
 * @author Michael Lam
 * @version 1.0
 * @since 27-10-17
 */

public class Auction {
    
    /**
     * The ID of an auction.
     */
    private int auctionId;
    /**
     * The history of a bid.
     */
    private List<Bid> bids = new ArrayList<>();
    /**
     * The artwork being placed on an auction.
     */
    private Artwork artwork;
    /**
     * The user who created the auction.
     */
    private User creator;
    /**
     * The current price of the artwork being auctioned.
     */
    private double currentPrice;
    /**
     * The minimum reservation price of the artwork being auctioned.
     */
    private double reservePrice;
    /**
     *The date the auction was created.
     */
    private Timestamp dateAdded;
    /**
     *The maximum number of bids that can be placed on a auction.
     */
    private int maxBids;

    /**
     * An auction constructor with the information specifying an auction.
     *  @param creator The user who created the auction.
     *  @param currentPrice The current price of the artwork being auctioned.
     *  @param reservePrice The minimum reversation price of the artwork being auctioned.
     *  @param maxBids The maximum number of bids that can be placed on a auction.
     *  @param artwork The artwork being placed for auctioning.
     */
    public Auction(User creator, double currentPrice, double reservePrice, int maxBids, Artwork artwork) {
        this.artwork = artwork;
        this.creator = creator;
        this.currentPrice = currentPrice;
        this.reservePrice = reservePrice;
        this.maxBids = maxBids;
        this.dateAdded = new Timestamp(System.currentTimeMillis());
    }

    /**
     * An auction constructor with the information specifying an auction.
     *  @param actionId The ID of the auction.
     *  @param creator The user who created the auction.
     *  @param currentPrice The current price of the artwork being auctioned.
     *  @param reservePrice The minimum reversation price of the artwork being auctioned.
     *  @param maxBids The maximum number of bids that can be placed on a auction.
     *  @param artwork The artwork being placed for auctioning.
     */
    public Auction(int actionId, User creator, double currentPrice, double reservePrice, int maxBids, Artwork artwork) {
        this(creator, currentPrice, reservePrice, maxBids, artwork);
        this.auctionId = actionId;
    }

    /**
     * Method for placing a bid on a auction.
     * @return 0 If the bid is placed successfully, 1 or 2 otherwise.
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
     * Method that assigns a new list for bids, all values from the old list are lost.
     * @param bids Sets the amount of bids on an auction.
     */
    public void setNewBidList(List<Bid> bids) {
        this.bids = bids;
    }

    /**
     * Method for getting the number of allowed bids left on an auction.
     * @return bids The amount of bids left on an auction.
     */
    public int bidsLeft() {
        return maxBids - bids.size();
    }

    /**
     * Method getting the most recently placed bid on a auction.
     * @return The most recently placed bid.
     */
    public Bid getMostRecentBid() {
        return bids.get(bids.size() - 1);
    }

    /**
     * Method getting a bid at the specified positon in the list.
     * @return The Bid object at the specified position.
     */
    public Bid getBidByIndex(int index) {
        return bids.get(index);
    }

    /**
     * Gets the artwork being placed on an auction.
     * @return The artwork placed on an auction.
     */
    public Artwork getArtwork() {
        return artwork;
    }

    /**
     * Gets the user who created the auction.
     * @return The user who created the auction.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Gets the current price of the artwork.
     * @return The current price of the artwork.
     */
    public double getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Gets the reserve price of the auction.
     * @return The reserve price of the auction
     */
    public double getReservePrice() {
        return reservePrice;
    }

    /**
     * Gets the creation date of the auction.
     * @return The creation date of the auction.
     */
    public Timestamp getDateAdded() {
        return dateAdded;
    }

    /**
     * Gets the maximum amount of bids allowed.
     * @return The maximum amount of bids allowed
     */
    public int getMaxBids() {
        return maxBids;
    }
    
    /**
     * Gets the Id of the auction.
     * @return The Id of the auction.
     */
    public int getAuctionId() {
        return auctionId;
    }
    
    /**
     * Sets the Id of the auction.
     * @param auctionId The ID of the auction.
     */
    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }
}
