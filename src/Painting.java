import java.sql.Timestamp;
import java.util.List;


public class Painting extends Artwork{

	private double width;
	private double height;

	public Painting(String title, String description, String artist, List<ArtworkPicture> pictures, int primaryPictureIndex, int yearCreated, double width, double height) {
		super(title, description, artist, pictures, primaryPictureIndex, yearCreated);
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
