import java.util.ArrayList;

public class Auction{
    private ArrayList<Bid> bids = new ArrayList<>(); //Bid history
    private Artwork artwork; //The artwork being placed on auction

    public Auction(Artwork artwork){
        this.artwork = artwork;
    }

/**
* Place a bid
* @return 0 if the bid is placed successfully, 1 or 2 otherwise (see below) 
*/
    public int placeBid(User user, double amount){
        //Check if the bid is above reserve price and the current highest bidder
        if(amount < artwork.getReservePrice() || amount < artwork.getPrice()){
            return 1; //Placed bid below reserve price or highest bidder
        }
        //Check if the max amount of bids has already been exceeded
        else if(bids.size() >= artwork.getMaxBids()){
            return 2; //Maximum amount of bids has been exceeded
        }
        //Add a new Bid entry if all both checks are postive
        else {
            bids.add(new Bid(user, amount));
            artwork.setPrice(artwork.getPrice()+amount);
            return 0; //Bid successfully placed
        }
    }

    /**
    * Gets the most recently placed bid
    * @return The most recently placed bid
    */
    public Bid getMostRecentBid(){
        return bids.get(bids.size()-1);
    }

    /**
    * Gets a bid at the specified positon in the list
    * @return A Bid object
    */
    public Bid getBidByIndex(int index){
        return bids.get(index);
    }
}
