/**
* Contains data and methods which apply to all artwork types.
* @author  Morgan David
* @version 1.0
* @since   27-10-17
*/

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public class Artwork {
	protected String title;
	protected String description;
	protected String artist; //the artist who created the art
	protected List<String> images;
	protected int primaryImageIndex; //Primary image to display larger than others in the list
	protected Dimensions dimensions;
	protected int yearCreated;

	public Artwork(String title, String description, String artist, List<String> images, int primaryImageIndex, Dimensions dimensions, int yearCreated) {
		this.title = title;
		this.description = description;
		this.artist = artist;
		this.images = images;
		this.primaryImageIndex = primaryImageIndex;
		this.dimensions = dimensions;
		this.yearCreated = yearCreated;
	}

	/**
	 * Gets the title of this artwork.
	 * @return the title of this artwork
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Sets the title of this artwork.
	 * @param title the title of this artwork
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Sets the description of this artwork.
	 * @return the description of this artwork.
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Sets the description of this artwork.
	 * @param description the description of this artwork.
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * Sets the artist of this artwork.
	 * @return the artist of this artwork.
	 */
	public String getArtist(){
		return artist;
	}
	
	/**
	 * Sets the artist of this artwork.
	 * @param artist the artist of this artwork.
	 */
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	/**
	 * Gets the dimensions of this artwork.
	 * @return the dimensions of this artwork
	 */
	public Dimensions getDimensions(){
		return dimensions;
	}

	/**
	 * Sets the dimensions of this artwork.
	 * @param dimensions the dimensions of this artwork
	 */
	public void setDimensions(Dimensions dimensions){
		this.dimensions = dimensions;
	}


	/**
	 * Gets the year this artwork was created.
	 * @return the year this artwork was created
	 */
	public int getYearCreated(){
		return this.yearCreated;
	}

	/**
	 * Sets the year this artwork was created.
	 * @param yearCreated the year this artwork was created
	 */
	public void setYearCreated(int yearCreated){
		this.yearCreated = yearCreated;
	}

	/**
	 * Gets the list of images for this artwork.
	 * @return the list of images of this artwork
	 */
	public List<String> getImages(){
		return images;
	}

	/**
	 * Sets the list of images for this artwork.
	 * @param images the list of images of this artwork
	 */
	public void setImages(List<String> images){
		this.images = images;
	}

}
