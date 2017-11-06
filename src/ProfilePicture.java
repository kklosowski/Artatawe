class ProfilePicture extends Picture {
	private int userId;

	public ProfilePicture(String path, int userId){
		super(path);
		this.userId = userId;
	}

	public int getUserId(){
		return this.userId;
	}
}
