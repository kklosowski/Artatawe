/**
 * Created by Eter on 13/10/2017.
 */
public class Dimensions {

    private double width;
    private double height;
    private double depth;

    public Dimensions(double width, double height) {
        this(width,height,0);
    }

    public Dimensions(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
