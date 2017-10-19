import java.time.Year;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Eter on 12/10/2017.
 */
public class Painting extends Artwork {

    public Painting(String title, Optional<String> description, String photo, String creator, Year yearCreated, double reservePrice, int bidsAllowed, Date dateAdded, Dimensions dimensions) {
        super(title, description, photo, creator, yearCreated, reservePrice, bidsAllowed, dateAdded, dimensions);
    }
}
