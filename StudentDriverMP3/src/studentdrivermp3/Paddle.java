/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author CDOGG_000
 */
public class Paddle extends Rectangle{
    private int BASE_Y=650;
    private int paHeight;
    private int paWidth;
    public int PADDLE_WIDTH=70;
    public int PADDLE_HEIGHT=10;
 
    
    public Paddle(int paWidth, int paHeight){
        this.paWidth=paWidth;
        this.paHeight=paHeight;
        this.setHeight(PADDLE_HEIGHT);
        this.setWidth(PADDLE_WIDTH);
        this.setFill(Color.PURPLE);
        this.setStroke(Color.PURPLE);
        
        move(paWidth/2);
    }
    public void move(double xLoc){
               
                 this.setX(xLoc - PADDLE_WIDTH/2);
                 this.setY(BASE_Y);
                 
            
    }

    /**
     * @return the paHeight
     */
    public int getPaHeight() {
        return paHeight;
    }

    /**
     * @param paHeight the paHeight to set
     */
    public void setPaHeight(int paHeight) {
        this.paHeight = paHeight;
    }

    /**
     * @return the paWidth
     */
    public int getPaWidth() {
        return paWidth;
    }

    /**
     * @param paWidth the paWidth to set
     */
    public void setPaWidth(int paWidth) {
        this.paWidth = paWidth;
    }
    
}
