/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author shuyu6
 */
public class Circle extends Shape{

    public Circle() {
    }
    
    public Circle(int x1, int x2, int y1, int y2, Color filledColor) {
        super(x1, x2, y1, y2, filledColor);
    }   
    
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawOval(x1, y1, x2, y2);
    }
    
}
