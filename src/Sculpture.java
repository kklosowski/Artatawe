import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Sculpture {

	private String title;
	private Optional<String> description;
	private String photo;
	private String creator;
	private Year yearCreated;
	private double reservedPrice;
	private int bidsAllowed;
	private Date dateAdded;
	private Dimensions dimensions;
	private String material;
	private List<String> photos;
	
	
	public Sculpture(String title, Optional<String> description,String photo,String creator,Year yearCreated, double reservedPrice,
			int bidsAllowed, Date dateAdded,Dimensions dimension, String material, List<String> photos){
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.creator = creator;
		this.yearCreated = yearCreated;
		this.reservedPrice = reservedPrice;
		this.bidsAllowed = bidsAllowed;
		this.dateAdded = dateAdded;
		this.dimensions = dimensions;
		this.material = material;
		this.photos = photos;
		
	}
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Optional<String> getDescription() {
		return description;
	}


	public void setDescription(Optional<String> description) {
		this.description = description;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getCreator() {
		return creator;
	}


	public void setCreator(String creator) {
		this.creator = creator;
	}


	public Year getYearCreated() {
		return yearCreated;
	}


	public void setYearCreated(Year yearCreated) {
		this.yearCreated = yearCreated;
	}


	public double getReservedPrice() {
		return reservedPrice;
	}


	public void setReservedPrice(double reservedPrice) {
		this.reservedPrice = reservedPrice;
	}


	public int getBidsAllowed() {
		return bidsAllowed;
	}


	public void setBidsAllowed(int bidsAllowed) {
		this.bidsAllowed = bidsAllowed;
	}


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}


	public Dimensions getDimensions() {
		return dimensions;
	}


	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public List<String> getPhotos() {
		return photos;
	}

	public void addPhoto(List<String>photos){
		this.photos = photos;
	}
	
}
