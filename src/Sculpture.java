/**
 * Class for creating a sculpture object.
 * @author Tereza Pashinska
 * version 1.0
 * Since 27.10.2017
 *
 */
import java.util.List;


public class Sculpture extends Artwork {

	/**
	 *The material of the sculpture
	 */
	private String material;
	private double width;
	private double height;
	private double depth;
	private List<String> additionalPictures;

	//TODO delete if this is not longer using
	public Sculpture(){

	}

	/**
	 * Constructs an object of type Sculpture
	 * @param material
	 * 				The material of the sculpture.
//	 * @param photos
	 * 				List of photos added
	 */
	//TODO add list
	public Sculpture(String title, String description, String artist, String primaryPicture, int yearCreated, String material, double width, double height, double depth) {
		super(title, description, artist, primaryPicture, yearCreated);
		this.material = material;
		this.width = width;
		this.height = height;
		this.depth = depth;
//		this.additionalPictures = additionalPictures;
	}

	public Sculpture(int artworkId, String title, String description, String artist, String primaryPicture, int yearCreated, String material, double width, double height, double depth) {
		super(artworkId, title, description, artist, primaryPicture, yearCreated);
		this.material = material;
		this.width = width;
		this.height = height;
		this.depth = depth;
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

	public double getWidth(){
		return this.width;
	}

	public double getHeight(){
		return this.height;
	}

	public double getDepth(){
		return this.depth;
	}
}
