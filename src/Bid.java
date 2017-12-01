/**
* Contains an entry of a successfully placed bid
* @author randompasser (Michael)
* @since 27-10-17 
*/

import java.sql.Timestamp;

public class Bid{

    /**
     * The user who placed the bid
     */
    private int userId;
    /**
     * Amount of the bid
     */
    private double amount;
    /**
     * Timestamp of the bid
     */
    private Timestamp timePlaced;

    public Bid(int user, double amount){
        this.userId = user;
        this.amount = amount;
        this.timePlaced = new Timestamp(System.currentTimeMillis());
    }

    public Bid(int user, double amount, Timestamp timePlaced) {
        this.userId = user;
        this.amount = amount;
        this.timePlaced = timePlaced;
    }

    /**
    * Gets the user who placed this bid
    * @return the user who placed this bid
    */
    public int getUserId(){
        return userId;
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
    
