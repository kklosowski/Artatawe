package artatawe;

import java.util.List;

/**
 * Class for creating a sculpture object.
 *
 * @author Tereza Pashinska
 * version 1.0
 * Since 27.10.2017
 */


public class Sculpture extends Artwork {

    /**
     * The material of the sculpture.
     */
    private String material;
    /**
     * The width of the sculpture.
     */
    private double width;
    /**
     * The height of the sculpture.
     */
    private double height;
    /**
     * The depth of the sculpture.
     */
    private double depth;
    /**
     * The list containing additional pictures of the sculpture.
     */
    private List<String> additionalPictures;

    /**
     * Constructs an object of type Sculpture
     *
     * @param material           The material of the sculpture.
     * @param additionalPictures List of additional photos added.
     * @param height             The height of the sculpture.
     * @param depth              The depth of the sculpture.
     * @param width              The width of the sculpture.
     */
    public Sculpture(String title,
                     String description,
                     String artist,
                     String primaryPicture,
                     int yearCreated,
                     String material,
                     double width,
                     double height,
                     double depth,
                     List<String> additionalPictures) {
        super(title, description, artist, primaryPicture, yearCreated);
        this.material = material;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.additionalPictures = additionalPictures;
    }

    /**
     * Constructs an object of type Sculpture
     *
     * @param artworkId          The Id of the sculpture.
     * @param material           The material of the sculpture.
     * @param additionalPictures List of additional photos added.
     * @param height             The height of the sculpture.
     * @param depth              The depth of the sculpture.
     * @param width              The width of the sculpture.
     */
    public Sculpture(int artworkId,
                     String title,
                     String description,
                     String artist,
                     String primaryPicture,
                     int yearCreated,
                     String material,
                     double width,
                     double height,
                     double depth,
                     List<String> additionalPictures) {
        super(artworkId, title, description, artist, primaryPicture, yearCreated);
        this.material = material;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.additionalPictures = additionalPictures;
    }

    /**
     * Method getting the material of a sculpture
     *
     * @return The material.
     */
    public String getMaterial() {
        return material;
    }


    /**
     * Resets the material.
     *
     * @param material The material of the sculpture.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Method getting the width of a sculpture.
     *
     * @return The width of a sculpture.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Method getting the height of a sculpture.
     *
     * @return The height of a sculpture.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Method getting the depth of a sculpture.
     *
     * @return The depth of a sculpture.
     */
    public double getDepth() {
        return this.depth;
    }

    /**
     * Method getting the all additional pictures.
     *
     * @return The additional pictures in list.
     */
    public List<String> getAdditionalPictures() {
        return additionalPictures;
    }
}
