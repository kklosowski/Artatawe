package artatawe;

import java.sql.Timestamp;

/**
 * Bid is class that contains an entry of a successfully placed bid.
 *
 * @author Michael
 * @version 1.0
 * @since 27-10-17
 */

public class Bid {

    /**
     * The Id of the user who placed the bid.
     */
    private int userId;
    /**
     * The amount of the bid.
     */
    private double amount;
    /**
     * The timestamp of the bid.
     */
    private Timestamp timePlaced;

    /**
     * Bid constructor with the information specifying a bid.
     *
     * @param user   The user who placed the bid.
     * @param amount The amount of a bid the user has placed.
     */
    public Bid(int user, double amount) {
        this.userId = user;
        this.amount = amount;
        this.timePlaced = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Bid constructor with the information specifying a bid.
     *
     * @param user       The user who placed the bid.
     * @param amount     The amount of a bid the user has placed.
     * @param timePLaced The time of when the user placed the bid.
     */
    public Bid(int user, double amount, Timestamp timePlaced) {
        this.userId = user;
        this.amount = amount;
        this.timePlaced = timePlaced;
    }

    /**
     * Gets the user who placed this bid.
     *
     * @return The user who placed this bid.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets the amount of this bid.
     *
     * @return The amount of this bid.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the timestamp of this bid.
     *
     * @return The timestamp of this bid.
     */
    public Timestamp getTimestamp() {
        return timePlaced;
    }
}
    
