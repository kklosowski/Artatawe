class ProfilePicture extends Picture {
	private User user;

	public ProfilePicture(String path, User user){
		super(path);
		this.user = user;
	}

	public User getUser(){
		return this.user;
	}
}
