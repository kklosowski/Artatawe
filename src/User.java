import java.util.Date;
import java.util.List;

/**
 * Created by Eter on 12/10/2017.
 */
public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private Address address;
    private Date lastLogin;
    private String profileImage;
    private List<User> favouriteUsers;
    private List<Bid> bidHistory;
    private List<Auction> wonAuctions;

    //Stub Constructor
    public User(String username, String firstName, String lastName, String mobileNumber, Address address, Date lastLogin, String profileImage, List<User> favouriteUsers, List<Bid> bidHistory, List<Auction> wonAuctions) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.lastLogin = lastLogin;
        this.profileImage = profileImage;
        this.favouriteUsers = favouriteUsers;
        this.bidHistory = bidHistory;
        this.wonAuctions = wonAuctions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<User> getFavouriteSellers() {
        return favouriteUsers;
    }

    public void addFavouriteSeller(List<User> favouriteSellers) {
        this.favouriteUsers = favouriteSellers;
    }

    public List<Bid> getBidHistory() {
        return bidHistory;
    }

    public void addBidToHistory(List<Bid> bidHistory) {
        this.bidHistory = bidHistory;
    }

    public List<Auction> getWonAuctions() {
        return wonAuctions;
    }

    public void addWonAuction(List<Auction> wonAuctions) {
        this.wonAuctions = wonAuctions;
    }
}
