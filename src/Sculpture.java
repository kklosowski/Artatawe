import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Eter on 12/10/2017.
 */
public class Sculpture extends Artwork{

    private String material;
    private List<String> photos;

    public Sculpture(String title, Optional<String> description, String photo, String creator, Year yearCreated, double reservePrice, int bidsAllowed, Date dateAdded, Dimensions dimensions, String material, List<String> photos) {
        super(title, description, photo, creator, yearCreated, reservePrice, bidsAllowed, dateAdded, dimensions);
        this.material = material;
        this.photos = photos;
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

    public void addPhoto(List<String> photos) {
        this.photos = photos;
    }
}
