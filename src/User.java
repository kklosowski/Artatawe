import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * User is the class that stores user-related data and thier last
 * login date.
 * @author	Marceli Wac
 */
class User{
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
	 * @param firstName			user's first name
	 * @param lastName			user's last name
	 * @param userName			user's nickname (or username)
	 * @param mobileNo			user's mobile number
	 * @param address			user's postal address
	 * @param profilePicture	user's profile picture
	 */
	public User(int userId,
				String firstName,
				String lastName,
				String userName,
				String mobileNo,
				Address address,
				Timestamp lastLoggedIn,
				String profilePicture){
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

	public int getUserId(){
		return this.userId;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public String getLastName(){
		return this.lastName;
	}

	public String getUserName(){
		return this.userName;
	}

	public String getMobileNo(){
		return this.mobileNo;
	}

	public Address getAddress(){
		return this.address;
	}

	public Timestamp getLastLoggedIn(){
		return this.lastLoggedIn;
	}

	public String getProfilePicture(){
		return this.profilePicture;
	}

	public void setMobileNo(String newMobileNo){
		this.mobileNo = newMobileNo;
	}

	public void setAddress(Address newAddress){
		this.address = newAddress;
	}

	public void setLastLoggedIn(Timestamp newLastLoggedIn){
		this.lastLoggedIn = newLastLoggedIn;
	}

	public void setProfilePicture(String newProfilePicture){
		this.profilePicture = newProfilePicture;
	}

	public void addFavourite(User nextFav){
		this.favouriteUsers.add(nextFav);
	}

	public void removeFavourite(int UserId){

	}

	public ArrayList<User> getFavouriteUsers(){
		return this.favouriteUsers;
	}
}
