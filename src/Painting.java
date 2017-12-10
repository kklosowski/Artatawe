package artatawe;

public class Painting extends artatawe.Artwork{

	private double width;
	private double height;

	public Painting(String title, String description, String artist, String primaryPicture, int yearCreated, double width, double height) {
		super(title, description, artist, primaryPicture, yearCreated);
		this.width = width;
		this.height = height;
	}

	public Painting(int artworkId, String title, String description, String artist, String primaryPicture, int yearCreated, double width, double height) {
		super(artworkId, title, description, artist, primaryPicture, yearCreated);
		this.width = width;
		this.height = height;
	}

	public double getWidth(){
		return this.width;
	}

	public double getHeight(){
		return this.height;
	}
}
