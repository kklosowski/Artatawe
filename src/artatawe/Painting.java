package artatawe;

/**
 * Paiting is a class that contains all the actions needed for constructing a painting object.
 *
 * @author Morgan David
 * @version 1.0
 */

public class Painting extends Artwork {
    
    /*
    * The width of the painting
    */
    private double width;
    
    /** 
    * The height of the paintng
    */
    private double height;

    /**
     * Constructs an object of type Painting.
     * @param width The width of the painting.
     * @param height The height of the painting.
     */
    public Painting(String title, String description, String artist, String primaryPicture, int yearCreated, double width, double height) {
        super(title, description, artist, primaryPicture, yearCreated);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs an object of type Painting.
     * @param artworkId The Id of the painting.
     * @param width The width of the painting.
     * @param height The height of the painting.
     */
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
