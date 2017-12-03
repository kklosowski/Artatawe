/**
* Contains data and methods which apply to all artwork types.
* @author  Morgan David
* @version 1.0
* @since   27-10-17
*/

public abstract class Artwork {
	protected int artworkId;
	protected String title;
	protected String description;
	protected String artist; //the artist who created the art
	protected String primaryPicture;
	protected int yearCreated;

	//TODO delete if this is not longer using
	public Artwork(){

	}
	public Artwork(String title, String description, String artist, String primaryPicture, int yearCreated) {
		this.title = title;
		this.description = description;
		this.artist = artist;
		this.primaryPicture = primaryPicture;
		this.yearCreated = yearCreated;
	}

	public int getArtworkId(){
		return this.artworkId;
	}

	/**
	 * Gets the title of this artwork.
	 * @return the title of this artwork
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Sets the title of this artwork.
	 * @param title the title of this artwork
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Sets the description of this artwork.
	 * @return the description of this artwork.
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Sets the description of this artwork.
	 * @param description the description of this artwork.
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * Sets the artist of this artwork.
	 * @return the artist of this artwork.
	 */
	public String getArtist(){
		return artist;
	}

	/**
	 * Sets the artist of this artwork.
	 * @param artist the artist of this artwork.
	 */
	public void setArtist(String artist){
		this.artist = artist;
	}


	/**
	 * Gets the year this artwork was created.
	 * @return the year this artwork was created
	 */
	public int getYearCreated(){
		return this.yearCreated;
	}

	/**
	 * Sets the year this artwork was created.
	 * @param yearCreated the year this artwork was created
	 */
	public void setYearCreated(int yearCreated){
		this.yearCreated = yearCreated;
	}

	public String getPrimaryPicture(){
		return this.primaryPicture;
	}

}
