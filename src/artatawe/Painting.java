package artatawe;
/**
 * This class contains the data and methods for a painting
 */
public class Painting extends Artwork {
    /* Width of the painting */
    private double width;
    /* Height of the paintng */
    private double height;

    public Painting(String title, String description, String artist, String primaryPicture, int yearCreated, double width, double height) {
        super(title, description, artist, primaryPicture, yearCreated);
        this.width = width;
        this.height = height;
    }

    public Painting(int artworkId, String title, String description, String artist, String primaryPicture, int yearCreated, double width, double height) {
        super(artworkId, title, description, artist, primaryPicture, yearCreated);
        this.width = width;
        this.height = height;
    }
    /**
     * Gets the width of the painting
     * @return Width of the painting
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * Gets the height of the painting
     * @return Height of the painting
     */
    public double getHeight() {
        return this.height;
    }
}
