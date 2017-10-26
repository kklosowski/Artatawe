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
	protected Dimension dimensions;
	protected Year yearCreated;
	protected Date dateAdded;
	protected int maxBids;
	
	public Artwork(String title, String description, double reservePrice, int maxBids, Dimension dimension,Year yearCreated){
		this.title = title;
		this.price = price;
		this.description = description;
		this.reservePrice = reservePrice;
		this.dimensions = dimensions;
		this.yearCreated = yearCreated;
		this.dateAdded = getDate();
		this.maxBids = maxBids;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getReservePrice(){
		return reservePrice;
	}
	
	public void setReservePrice(double reservePrice){
		this.reservePrice = reservePrice;
	}
	
	public Dimension getDimensions(){
		return dimensions;
	}
	
	public void setDimensions(Dimension dimensions){
		this.dimensions = dimensions;
	}
	
	public Date getDateAdded(){
		return dateAdded;
	}
	
	public Year getYearCreated(){
		return yearCreated;
	}
	
	public void setYearCreated(Year yearCreated){
		this.yearCreated = yearCreated;
	}
	
	public List<String> getImages(){
		return images;
	}
	
	public void setImages(List<String> images){
		this.images = images;
	}
}
