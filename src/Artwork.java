import java.time.Year;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Eter on 12/10/2017.
 */
public class Artwork {

    private String title;
    private Optional<String> description;
    private String photo;
    private String creator;
    private Year yearCreated;
    private double reservePrice;
    private int bidsAllowed;
    private Date dateAdded;
    private Dimensions dimensions;

    public Artwork(String title, Optional<String> description, String photo, String creator, Year yearCreated, double reservePrice, int bidsAllowed, Date dateAdded, Dimensions dimensions) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.creator = creator;
        this.yearCreated = yearCreated;
        this.reservePrice = reservePrice;
        this.bidsAllowed = bidsAllowed;
        this.dateAdded = dateAdded;
        this.dimensions = dimensions;
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

    public double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(double reservePrice) {
        this.reservePrice = reservePrice;
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
}
