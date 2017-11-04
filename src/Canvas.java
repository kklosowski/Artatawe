/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvatarSubsystem;

import java.awt.Color;
import java.awt.image.BufferedImage;
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
    public BufferedImage drawingImage;
    public String imageLocation;


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

    public BufferedImage getDrawingImage() {
        return drawingImage;
    }

    public void setDrawingImage(BufferedImage drawingImage) {
        this.drawingImage = drawingImage;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }    
    
    public void undoLastShape(){
        shapesList.remove(shapesList.size()-1);
    }
    public void cleanCanvas(){
        shapesList.clear();
    }
    private void refreshCanvas(){
        
    }
    public BufferedImage convertDrawingToImage(){
        return null;
    }
    public void usersDrawing(String chosenShape){
        //if line is chosen 
        if(chosenShape.equals(this.ShapeType[0])){
            shapesList.add(new ShapeLine(1, 1, 1, 1, currentColor));
        }else{
            // if the circle is chosen 
            shapesList.add(new ShapeCircle(2,2,2,2,currentColor));
        }
    }          

}
