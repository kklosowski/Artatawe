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
    private ArrayList<Object> shapesList;
    public BufferedImage drawingImage;
    public String imageLocation;

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

    }

}
