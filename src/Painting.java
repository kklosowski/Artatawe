import java.sql.Timestamp;
import java.util.List;

//TODO: Implement the Painting Class

public class Painting extends Artwork{
	public Painting(String title, String description, String artist, List<ArtworkPicture> pictures, int primaryPictureIndex, Dimensions dimensions, int yearCreated) {
		super(title, description, artist, pictures, primaryPictureIndex, dimensions, yearCreated);
	}
}
