import java.sql.Timestamp;

class User{
	private final String firstName;
	private final String lastName;
	private final String userName;
	private String mobileNo;
	private Address address;
	private Timestamp lastLoggedIn;
	private Avatar avatar;

	public User(String firstName,
				String lastName,
				String userName,
				String mobileNo,
				Address address,
				Avatar avatar){
//		Timestamp currentTime = new Timestamp();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.address = address;
//		this.lastLoggedIn = currentTime.getTime();
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
}
