import java.sql.Timestamp;

public class Painting extends Artwork{
	public Painting(String title, String description, double reservePrice, int maxBids, Dimensions dimensions, int yearCreated, Timestamp dateAdded){
		super(title, description,reservePrice, maxBids, dimensions, yearCreated, dateAdded);
	}
}
