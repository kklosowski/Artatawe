package artatawe;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * User is the class that stores user-related data and thier last
 * login date.
 *
 * @author Marceli Wac
 */
public class User {
    /**
     * user's id
     */
    private int userId;

    /**
     * user's first name
     */
    private final String firstName;

    /**
     * user's last name
     */
    private final String lastName;

    /**
     * user's nickname (or username) also used as login credentials
     */
    private final String userName;

    /**
     * user's mobile number
     */
    private String mobileNo;

    /**
     * user's postal address
     */
    private Address address;

    /**
     * timestamp of user's last log-in
     */
    private Timestamp lastLoggedIn;

    /**
     * user's profile picture
     */
    private String profilePicture;

    /**
     * user's list of all favourite users
     */
    private ArrayList<User> favouriteUsers;

    /**
     * Class constructor specifying all of user information except
     * the last login date which is set automatically to the current
     * date.
     *
     * @param firstName      user's first name
     * @param lastName       user's last name
     * @param userName       user's nickname (or username)
     * @param mobileNo       user's mobile number
     * @param address        user's postal address
     * @param profilePicture user's profile picture
     */
    public User(int userId,
                String firstName,
                String lastName,
                String userName,
                String mobileNo,
                Address address,
                Timestamp lastLoggedIn,
                String profilePicture) {
        //TODO: Find a way to get a next unique id for the user
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.address = address;
        this.lastLoggedIn = lastLoggedIn;
        this.profilePicture = profilePicture;
    }

    public User(String firstName, String lastName, String userName, String mobileNo, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    public User(String firstName, String lastName, String userName, String mobileNo, Address address, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.address = address;
        this.profilePicture = profilePicture;
    }
    /* Gets the ID of the user */
    public int getUserId() {
        return this.userId;
    }
    /* Gets the first name of the user */
    public String getFirstName() {
        return this.firstName;
    }
    /* Gets the last name of the user */
    public String getLastName() {
        return this.lastName;
    }
    /* Gets the user name of the user */
    public String getUserName() {
        return this.userName;
    }
    /* Gets the mobile number of the user */
    public String getMobileNo() {
        return this.mobileNo;
    }
    /* Gets the address of the user */
    public Address getAddress() {
        return this.address;
    }
    /* Gets the timpstamp of the last successful login */
    public Timestamp getLastLoggedIn() {
        return this.lastLoggedIn;
    }
    /* Gets the name of the profile picture */
    public String getProfilePicture() {
        return this.profilePicture;
    }
    /**
    * Sets the mobile number of the user
    * @param newMobileNo Mobile number
    */
    public void setMobileNo(String newMobileNo) {
        this.mobileNo = newMobileNo;
    }
    /**
    * Sets the address of the user
    * @param newAddress Address
    */    
    public void setAddress(Address newAddress) {
        this.address = newAddress;
    }
    /**
    * Sets the last logged in timpstamp of the user
    * @param newLastLoggedIn timestamp of the last login
    */
    public void setLastLoggedIn(Timestamp newLastLoggedIn) {
        this.lastLoggedIn = newLastLoggedIn;
    }
    /**
    * Sets the name of the profile picture of the user
    * @param newProfilePicture Name of the profile picture
    */
    public void setProfilePicture(String newProfilePicture) {
        this.profilePicture = newProfilePicture;
    }
    /**
    * Add an user to the favourite list
    * @param nextFav an User object
    */
    public void addFavourite(User nextFav) {
        this.favouriteUsers.add(nextFav);
    }
    /**
    * Remove an user from the favourite list
    * @param UserId UserID of the user to be removed
    */
    public void removeFavourite(int UserId) {
        //TODO: Implement this method
    }
    /**
    * Gets the list of favourite users of this user
    * @return ArrayList of favourite users
    */
    public ArrayList<User> getFavouriteUsers() {
        return this.favouriteUsers;
    }
}
