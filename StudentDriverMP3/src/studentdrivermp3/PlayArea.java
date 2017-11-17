/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.BrickRow;
import brickbreakerstudent.Level;
import java.util.Random;
import javafx.animation.AnimationTimer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author CDOGG_000
 */
public class PlayArea extends Pane {

    private Brick[][] bricks;
    private int BASE_Y = 20;
    private int paHeight;
    private int paWidth;
    private Paddle pad;
    private Brick brick;
    private Ball ball ;
    private int direction;
    private Random ran= new Random();
    private Level level;


    public PlayArea(int paHeight, int paWidth, Level level) {
        direction= ran.nextInt();
        this.paHeight = paHeight;
        this.paWidth = paWidth;
        this.setPrefSize(paWidth, paHeight);
        this.level=level;
        createBricks(level);
        pad = new Paddle(paWidth, paHeight);
        ball= new Ball((int)pad.getX(),(int)pad.getY(), direction);
        
        this.getChildren().add(pad);
        this.getChildren().add(ball);
        newBall();

    }
    public Ball getBall(){
        return ball;
    }
    public Paddle getPad(){
        return pad;
    }
    
    public void checkCollisions(){
      if(ball.getBottomEdge()>=pad.getY()&&ball.getRightEdge()>pad.getX()&&ball.getLeftEdge()<pad.getX()+pad.getWidth()){
          
          
         
         handleCollisions();

    
}
     
     
                
    }
 
    private void createBricks(Level level) {
        bricks = new Brick[level.getNumBrickRows()][level.getBricksPerRow()];
        for (int i = 0; i < level.getNumBrickRows(); i++) {
            BrickRow bkrow = level.getBrickRow(i);
            for (int j = 0; j < level.getBricksPerRow(); j++) {
                if (bkrow.getBrickMaskValue(j) == true) {
                    bricks[i][j] = new Brick(j * Brick.BRICK_WIDTH, i * Brick.BRICK_HEIGHT);
                    bricks[i][j].setFill(bkrow.getColor());
                    bricks[i][j].setStroke(bkrow.getColor());
                    this.getChildren().add(bricks[i][j]);

                }
            }

        }
    }
    public void handleCollisions(){
                ball.setCenterY(pad.getY()-(ball.getRadius()+1));
                ball.setDirection(360-ball.getDirection());
    }
    public void moveBall(){
        ball.move();
    }
    public void newBall(){

       
        setBallVisibility(true);
        
    }
    public void setBallVisibility(Boolean visibility){
        ball.setVisible(visibility);
    }

    public void movePaddle(double xLoc) {

        pad.move(xLoc);
    }
}
