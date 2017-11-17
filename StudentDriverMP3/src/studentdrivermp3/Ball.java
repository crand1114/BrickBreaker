/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author CDOGG_000
 */
public class Ball extends Circle {
    private int speed=5;
    private double direction=0;
    private final static double TWO_PI = 2 * Math.PI;
    
    
    
    public Ball(int paWidth, int paHeight, double dir){
        this.setRadius(7);
        this.setCenterX(paWidth/2);
        this.setCenterY(paHeight/2);
        this.direction=dir;
        this.setFill(Color.RED);
        this.setStroke(Color.RED);
        
    }
    public void move(){
        this.setCenterX(this.getCenterX() + getSpeed() * Math.cos(getDirection() * TWO_PI/360));
        this.setCenterY(this.getCenterY() + getSpeed() * Math.sin(getDirection() * TWO_PI/360));  
    }
    public int getTopEdge(){
        return (int)this.getCenterY()-(int)this.getRadius();
    }
public int getBottomEdge(){
    return (int)this.getCenterY()+(int)this.getRadius();
}
public int getLeftEdge(){
        return (int)this.getCenterX()-(int)this.getRadius();
    }
public int getRightEdge(){
    return (int)this.getCenterX()+(int)this.getRadius();
}
    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }
    
}
