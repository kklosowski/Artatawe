package artatawe;

/**
 * Stores general information for artworks.
 * @author Morgan David
 * @version 1.0
 * @since  27.11.2017
 */
public abstract class Artwork {
    
    /**
     * The ID of the Artwork.
     * */
    protected int artworkId;
    /**
     * The title of the Artwork.
     * */
    protected String title;
    /**
     * The description of the Artwork.
     * */
    protected String description;
    /**
     * The name of the artist who created the Artwork.
     * */
    protected String artist;
     /**
     * The path to the primary picture of the Artwork.
     * */
    protected String primaryPicture;
     /**
     * The year the Artwork was created.
     * */
    protected int yearCreated;

    protected String type;

    
     /**
     * Artwork constructor with the information specifying the artwork, including specifiying artworkId.
     *  @param artworkId        The id of an artwork.
     *  @param title            The title of an artwork.
     *  @param description      The description of an artwork.
     *  @param artist           The artist who created the artwork.
     *  @param primaryPicture   The path to the primary picture of an artwork.
     *  @param yearCreated      The year the artwork was created.
     * */
    public Artwork(int artworkId, String title, String description, String artist, String primaryPicture, int yearCreated) {
        this.artworkId = artworkId;
        this.title = title;
        this.description = description;
        this.artist = artist;
        this.primaryPicture = primaryPicture;
        this.yearCreated = yearCreated;
    }
    
      /**
     * Artwork constructor with the information specifying the artwork.
     *  @param title            The title of an artwork.
     *  @param description      The description of an artwork.
     *  @param artist           The artist who created the artwork.
     *  @param primaryPicture   The path to the primary picture of an artwork.
     *  @param yearCreated      The year the artwork was created.
     * */

    public Artwork(String title, String description, String artist, String primaryPicture, int yearCreated) {
        this.title = title;
        this.description = description;
        this.artist = artist;
        this.primaryPicture = primaryPicture;
        this.yearCreated = yearCreated;
    }

    /**
     * Gets the ID of this artwork.
     * @return The ID of this artwork.
     */
    public int getArtworkId() {
        return this.artworkId;
    }

    /**
     * Gets the title of this artwork.
     * @return The title of this artwork.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this artwork.
     * @param title the title of this artwork.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of this artwork.
     * @return The description of this artwork.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this artwork.
     * @param description The description of this artwork.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the artist of this artwork.
     * @return The artist of this artwork.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist of this artwork.
     * @param artist The artist of this artwork.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets the year this artwork was created.
     * @return The year this artwork was created
     */
    public int getYearCreated() {
        return this.yearCreated;
    }

    /**
     * Sets the year this artwork was created.
     * @param yearCreated The year this artwork was created
     */
    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    /**
     * Gets the path of the primary picture of this artwork.
     * @return The path of the primary picture of this artwork.
     */
    public String getPrimaryPicture() {
        return this.primaryPicture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
