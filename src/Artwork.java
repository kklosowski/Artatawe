/**
* Contains data and methods which apply to all artwork types.
* @author  Morgan David
* @version 1.0
* @since   27-10-17 
*/

import java.time.Year;
import java.util.Date;

public class Artwork {
	protected String title;
	protected String description;
	protected User creator; //The user who created the auction
	protected String artCreator; //the artist who created the art
	protected double price; 
	protected double reservePrice; 
	protected List[String] images;
	protected int primaryImageIndex; //Primary image to display larger than others in the list
	protected Dimensions dimensions;
	protected Year yearCreated;
	protected Date dateAdded;
	protected int maxBids;
	
	public Artwork(String title, String description, double reservePrice, int maxBids, Dimensions dimension,Year yearCreated){
		this.title = title;
		this.price = price;
		this.description = description;
		this.reservePrice = reservePrice;
		this.dimensions = dimensions;
		this.yearCreated = yearCreated;
		this.dateAdded = getDate();
		this.maxBids = maxBids;
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
	 * Sets the price of this artwork
	 * @param price the price of the artwork
	 */
	public void setPrice(double price){
		this.price = price;
	}
	/**
	 * Gets the price of this artwork.
	 * @return the price of this artwork
	 */
	public double getPrice(){
		return price;
	}
	/**
	 * Gets the reserve price for this artwork.
	 * @return the reserve price of this artwork
	 */
	public double getReservePrice(){
		return reservePrice;
	}
	
	/**
	 * Sets the reserve price for this artwork.
	 * @param reservePrice the reserve price of this artwork
	 */
	public void setReservePrice(double reservePrice){
		this.reservePrice = reservePrice;
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
	 * Gets the date this artwork was added.
	 * @return the date this artwork was added
	 */
	public Date getDateAdded(){
		return dateAdded;
	}
	/**
	 * Gets the year this artwork was created.
	 * @return the year this artwork was created
	 */
	public Year getYearCreated(){
		return yearCreated;
	}
	/**
	 * Sets the year this artwork was created.
	 * @param yearCreated the year this artwork was created
	 */
	public void setYearCreated(Year yearCreated){
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
