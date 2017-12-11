package artatawe;

import java.sql.Timestamp;
import java.util.List;

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
    private List<Integer> favouriteUsers;

    /**
     * Class constructor specifying all of user information.
     *
     * @param userId         user's id
     * @param firstName      user's first name
     * @param lastName       user's last name
     * @param userName       user's nickname (or username)
     * @param mobileNo       user's mobile number
     * @param address        user's postal address
     * @param lastLoggedIn   user's last login timestamp
     * @param profilePicture user's profile picture url
     * @param favouriteUsers user's favourite users
     */
    public User(int userId,
                String firstName,
                String lastName,
                String userName,
                String mobileNo,
                Address address,
                Timestamp lastLoggedIn,
                String profilePicture,
                List<Integer> favouriteUsers) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.address = address;
        this.lastLoggedIn = lastLoggedIn;
        this.profilePicture = profilePicture;
        this.favouriteUsers = favouriteUsers;
    }

    /**
     * Class constructor specifying all of user information except
     * the last login date, lastLoggedIn and favouriteUsers.
     *
     * @param firstName      user's first name
     * @param lastName       user's last name
     * @param userName       user's nickname (or username)
     * @param mobileNo       user's mobile number
     * @param address        user's postal address
     * @param profilePicture user's profile picture url
     */
    public User(String firstName,
                String lastName,
                String userName,
                String mobileNo,
                Address address,
                String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.address = address;
        this.profilePicture = profilePicture;
    }

    /**
     * Class constructor specifying all of user information except
     * the last login date, lastLoggedIn, profilePicture and favouriteUsers.
     *
     * @param firstName      user's first name
     * @param lastName       user's last name
     * @param userName       user's nickname (or username)
     * @param mobileNo       user's mobile number
     * @param address        user's postal address
     */
    public User(String firstName,
                String lastName,
                String userName,
                String mobileNo,
                Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    /**
     * Gets the ID of the user .
     * @return Return user's id.
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Gets the first name of the user .
     * @return Return user's first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of the user.
     * @return Return user's last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the user name of the user .
     * @return Return user's username.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Gets the mobile number of the user .
     * @return Return user's mobile number.
     */
    public String getMobileNo() {
        return this.mobileNo;
    }

    /**
     * Gets the address of the user.
     * @return Return an address object that stored user's address detail.
     */
    public Address getAddress() {
        return this.address;
    }

    /** Gets the timpstamp of the last successful login
     * @return Return user's last logged in timestamp
    */
    public Timestamp getLastLoggedIn() {
        return this.lastLoggedIn;
    }

    /**
     *  Gets the name of the profile picture
     *  @return Return user's profile picture url.
     */
    public String getProfilePicture() {
        return this.profilePicture;
    }

    /**
    * Sets the mobile number of the user
    * @param newMobileNo New mobile number of the user.
    */
    public void setMobileNo(String newMobileNo) {
        this.mobileNo = newMobileNo;
    }

    /**
    * Sets the address of the user
    * @param newAddress A new address that stored user's address detail.
    */    
    public void setAddress(Address newAddress) {
        this.address = newAddress;
    }

    /**
    * Sets the last logged in timestamp of the user
    * @param newLastLoggedIn Timestamp of the last login
    */
    public void setLastLoggedIn(Timestamp newLastLoggedIn) {
        this.lastLoggedIn = newLastLoggedIn;
    }

    /**
    * Sets the name of the profile picture of the user
    * @param newProfilePicture URL of the profile picture
    */
    public void setProfilePicture(String newProfilePicture) {
        this.profilePicture = newProfilePicture;
    }

    /**
    * Add an user to the favourite list
    * @param nextFav A favourite user object
    */
    public void addFavourite(int nextFav) {
        this.favouriteUsers.add(nextFav);
    }

    /**
    * Remove an user from the favourite list
    * @param favId UserID of the user to be removed
    */
    public void removeFavourite(int favId) {
        for (int i = 0; i<favouriteUsers.size();i++){
            if (favouriteUsers.get(i)==favId){
                favouriteUsers.remove(i);
                return;
            }
        }
    }

    /**
    * Gets the list of favourite users of this user
    * @return List of favourite users
    */
    public List<Integer> getFavouriteUsers() {
        return this.favouriteUsers;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address=" + address +
                ", lastLoggedIn=" + lastLoggedIn +
                ", profilePicture='" + profilePicture + '\'' +
                ", favouriteUsers=" + favouriteUsers +
                '}';
    }
}
