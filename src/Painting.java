package artawareClassDesign;

import java.awt.Dimension;
import java.time.Year;

public class Painting extends Artwork{

	public Painting(String title, String description, double reservePrice, int maxBids, Dimension dimension,Year yearCreated){
		super(title, description,reservePrice, maxBids, dimension, yearCreated);
		
	}
}
