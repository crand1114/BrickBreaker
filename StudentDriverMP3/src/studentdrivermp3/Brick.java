/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author CDOGG_000
 */
public class Brick extends Rectangle {
    private int pointValue=1;
    public static int BRICK_WIDTH=30;
    public static int BRICK_HEIGHT=20;
     
 
    
    public Brick(int xLoc, int yLoc){
        this.setHeight(BRICK_HEIGHT);
        this.setWidth(BRICK_WIDTH);
        this.setX(xLoc);
        this.setY(yLoc);
        this.setStroke(Color.GREEN);
        this.setFill(Color.GREEN);
       // this.setVisible(true);
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }
            
            
}
