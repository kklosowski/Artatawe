/**
 * Class for creating a sculpture object.
 * @author Tereza Pashinska
 * version 1.0
 * Since 27.10.2017
 *
 */
import java.util.List;
import java.sql.Timestamp;

public class Sculpture extends Artwork {

	/**
	 *The material of the sculpture 
	 */
	private String material;
	/**
	 *Additional photos added
	 */
	private List<String> photos;


	/**
	 * Constructs an object of type Sculpture
	 * @param material
	 * 				The material of the sculpture.
	 * @param photos
	 * 				List of photos added
	 */
	public Sculpture (String title, String description, int reservePrice, int maxBids, Dimensions dimensions, int yearCreated, Timestamp dateAdded, String material, List<String> photos){
		super (title, description, reservePrice, maxBids, dimensions, yearCreated, dateAdded);
		this.material = material;
		this.photos = photos;
	}

	/**
	 * Method getting the material of a sculpture
	 * @return The material.
	 */
	public String getMaterial() {
		return material;
	}


	/**
	 * Resets the material.
	 * @param The material of the sculpture.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}


	/**
	 * Method getting the list of photos
	 * @return List of photos
	 */
	public List<String> getPhotos() {
		return photos;
	}

	/**
	 * Method adding photos.
	 * @param list of photos
	 */
	public void addPhoto(List<String>photos){
		this.photos = photos;
	}
	
}
