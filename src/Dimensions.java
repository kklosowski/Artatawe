
/**
  * Class responsible for the dimensions of the artworks.
 * @author Tereza Pashinska
 * version 1.0
 * Since 27.10.2017
 *
 */
public class Dimensions {

	/**
	 * Width of the artwork
	 */
	private double width;
	/**
	 * Height of the artwork
	 */
	private double height;
	/**
	 * Depth of the artwork
	 */
	private double depth;
	
	/**
	 * Constructs an object of type dimensions for sculptures.
	 * @param width
	 * 			Width of the sculpture
	 * @param height\
	 * 			Height of the sculpture
	 * @param depth
	 * 			Depth of the sculpture
	 */
	public Dimensions(double width,double height,double depth){
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	/**
	 * * Constructs an object of type dimensions for paintings.
	 * @param width
	 * 			Width of the painting
	 * @param height
	 * 			Height of the painting
	 */
	public Dimensions(double width, double height){
		this(width,height,0);
	}
	
	/**
	 * Method getting the width of an artwork.
	 * @return The width of an artwork
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Resets the width of an artwork.
	 * @param width - The width of an artwork
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * Method getting the height of an artwork.
	 * @return The height of an artwork
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * Resets the height of an artwork.
	 * @param height - The height of an artwork
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Method getting the depth of an artwork.
	 * @return The depth of an artwork
	 */
	public double getDepth() {
		return depth;
	}
	/**
	 * Resets the depth of an artwork.
	 * @param depth - The depth of an artwork
	 */
	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	
}
