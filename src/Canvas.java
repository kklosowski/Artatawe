import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author shuyu6
 */
public class Canvas {
    private ArrayList<Object> shapesList;
    public BufferedImage drawingImage;

	public BufferedImage getDrawingImage() {
        return drawingImage;
    }

    public void setDrawingImage(BufferedImage drawingImage) {
        this.drawingImage = drawingImage;
    }

    public void undoLastShape(){
        shapesList.remove(shapesList.size()-1);
    }

    public void cleanCanvas(){
        shapesList.clear();
    }

    public BufferedImage convertDrawingToImage(){
        return null;
    }

}
