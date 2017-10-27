/**
* Contains an entry of a successfully placed bid
* @author randompasser (Michael)
* @since 27-10-17 
*/

import java.sql.Timestamp;

public class Bid{
    private User user; //The user who placed the bid
    private double amount; //Amount of the bid
    private Timestamp timePlaced; //Timestamp of the bid

    public Bid(User user, double amount){
        this.user = user;
        this.amount = amount;
        //Timestamp currentTime = new Timestamp();
    }
    /**
    * Gets the user who placed this bid
    * @return the user who placed this bid
    */
    public User getUser(){
        return user;
    }
    /**
    * Gets the amount of this bid
    * @return the amount of this bid
    */
    public double getAmount(){
        return amount;
    }
    /**
    * Gets the timestamp of this bid
    * @return the timestamp of this bid
    */
    public Timestamp getTimestamp(){
        return timePlaced;
    }
}
    
