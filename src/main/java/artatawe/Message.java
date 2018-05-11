package artatawe;

/**
 * The type Message.
 */
public class Message {
    /**
     * The sending user.
     */
    User fromUser;
    /**
     * The receiving user.
     */
    User toUser;
    /**
     * The Content of the message.
     */
    String content;
    /**
     * The Timestamp.
     */
    long timestamp;


    /**
     * Instantiates a new Message.
     *
     * @param fromUser  the from user
     * @param toUser    the to user
     * @param content   the content
     * @param timestamp the timestamp
     */
    public Message(User fromUser, User toUser, String content, long timestamp) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.timestamp = timestamp;
    }

    /**
     * Gets sending user.
     *
     * @return sending user
     */
    public User getFromUser() {
        return fromUser;
    }

    /**
     * Sets sending user.
     *
     * @param fromUser sending user
     */
    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * Gets receiving user.
     *
     * @return receiving user
     */
    public User getToUser() {
        return toUser;
    }

    /**
     * Sets receiving user.
     *
     * @param toUser receiving user
     */
    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
