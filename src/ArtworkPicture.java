class ArtworkPicture extends Picture {
	private int artworkId;

	public ArtworkPicture(String path, int artworkId){
		super(path);
		this.artworkId = artworkId;
	}
}
