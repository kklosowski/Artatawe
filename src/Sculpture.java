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

	public Sculpture(String title, String description, String artist, List<String> images, int primaryImageIndex, Dimensions dimensions, int yearCreated, String material, List<String> photos) {
		super(title, description, artist, images, primaryImageIndex, dimensions, yearCreated);
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
	 * @param material The material of the sculpture.
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
	 * Method adding a photo to the list.
	 * @param photo of photos
	 */
	public void addPhoto(String photo){
		photos.add(photo);
	}
	
}
