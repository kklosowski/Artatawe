/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author shuyu6
 */
public class Canvas {
    private ArrayList<Shape> shapesList ;
    private String[] ShapeType;
    public Shape currentShape;
    public Color currentColor;
    private boolean filledShape;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public ArrayList<Shape> getShapesList() {
        return shapesList;
    }

    public void setShapesList(ArrayList<Shape> shapesList) {
        this.shapesList = shapesList;
    }

    public String[] getShapeType() {
        return ShapeType;
    }

    public void setShapeType(String[] ShapeType) {
        this.ShapeType = ShapeType;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public boolean isFilledShape() {
        return filledShape;
    }

    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }
    public void undoLastShape(){
        shapesList.remove(shapesList.size()-1);
    }
    public void cleanCanvas(){
        shapesList.clear();
    }
    private void refreshCanvas(){
        
    }
}
