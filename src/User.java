import java.sql.Timestamp;
import java.util.Date;

/**
 * User is the class that stores user-related data and thier last
 * login date.
 * @author	Marceli Wac
 */
class User{

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
	private Avatar avatar;

	/**
	 * Class constructor specifying all of user information except
	 * the last login date which is set automatically to the current
	 * date.
	 *
	 * @param firstName		user's first name
	 * @param lastName		user's last name
	 * @param userName		user's nickname (or username)
	 * @param mobileNo		user's mobile number
	 * @param address		user's postal address
	 * @param avatar		user's profile picture
	 */
	public User(String firstName,
				String lastName,
				String userName,
				String mobileNo,
				Address address,
				Avatar avatar){
		Date date = new Date();
		Timestamp currentTime = new Timestamp(date.getTime());
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.address = address;
		this.lastLoggedIn = currentTime;
		this.avatar = avatar;
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

	public Avatar getAvatar(){
		return this.avatar;
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

	public void setAvatar(Avatar newAvatar){
		this.avatar = newAvatar;
	}
}
