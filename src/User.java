class User{
	private final String firstName;
	private final String lastName;
	private final String userName;
	private final Timestamp firstJoined;
	private String mobileNo;
	private Address address;
	private Timestamp lastLoggedIn;
	private Avatar avatar;

	String public getFirstName(){
		return this.firstName;
	}

	String public getLastName(){
		return this.lastName;
	}

	String public getUserName(){
		return this.userName;
	}

	Timestamp public getFirstJoined(){
		return this.firstJoined;
	}

	String public getMobileNo(){
		return this.mobileNo;
	}

	Address public getAddress(){
		return this.address;
	}

	Timestamp public getLastLoggedIn(){
		return this.lastLoggedIn;
	}

	Avatar public getAvatar(){
		return this.avatar;
	}
}
