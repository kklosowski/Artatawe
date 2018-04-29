package artatawe;

/**
 * Stores data to construct a painting
 *
 * @author Morgan David
 * @version 1.0
 * @since 27.10.2017
 */
public class Painting extends Artwork {
    /**
     * Width of the painting
     */
    private double width;
    /**
     * Height of the paintng
     */
    private double height;

    /**
     * Painting constructor without artworkId.
     *
     * @param title
     * @param description
     * @param artist
     * @param primaryPicture
     * @param yearCreated
     * @param width
     * @param height
     */
    public Painting(String title, String description, String artist, String primaryPicture, int yearCreated, double width, double height) {
        super(title, description, artist, primaryPicture, yearCreated);
        this.width = width;
        this.height = height;
    }

    /**
     * Painting constructor with artworkId.
     *
     * @param artworkId
     * @param title
     * @param description
     * @param artist
     * @param primaryPicture
     * @param yearCreated
     * @param width
     * @param height
     */
    public Painting(int artworkId, String title, String description, String artist, String primaryPicture, int yearCreated, double width, double height) {
        super(artworkId, title, description, artist, primaryPicture, yearCreated);
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the width of the painting
     *
     * @return Width of the painting
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets the height of the painting
     *
     * @return Height of the painting
     */
    public double getHeight() {
        return this.height;
    }
}
