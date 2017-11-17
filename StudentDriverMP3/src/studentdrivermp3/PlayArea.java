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
    private ScorePane score=new ScorePane();
    
    
    


    public PlayArea(int paHeight, int paWidth, Level level,ScorePane score) {
        direction=225+ran.nextInt(90);
        this.score=score;
        this.paHeight = paHeight;
        this.paWidth = paWidth;
        this.setPrefSize(paWidth, paHeight);
        this.level=level;
        createBricks(level);
        pad = new Paddle(paWidth, paHeight);
        ball= new Ball(paWidth/2,paHeight/2, direction);
        ball.setVisible(false);
        //bricks = new Brick[level.getNumBrickRows()][level.getBricksPerRow()];
        this.getChildren().add(pad);
        this.getChildren().add(ball);
        //newBall();

    }
    public void brickCollision(){
      for(int i=0; i< this.bricks.length;i++){
          for(int j=0;j<this.bricks[i].length;j++){
              if(bricks[i][j]==null || !this.bricks[i][j].isVisible()){
                  continue;
              }
              if(ball.getTopEdge()> bricks[i][j].getY()&&ball.getTopEdge()<this.bricks[i][j].getY()+Brick.BRICK_HEIGHT
                     ||ball.getBottomEdge()>this.bricks[i][j].getY()&&ball.getBottomEdge()<this.bricks[i][j].getY()+Brick.BRICK_HEIGHT){
                  if(ball.getRightEdge()>this.bricks[i][j].getX()&&ball.getLeftEdge()<this.bricks[i][j].getX()+Brick.BRICK_WIDTH){
                      bricks[i][j].setVisible(false);
                      ball.setDirection(360-ball.getDirection());
                      score.incrementScore(this.bricks[i][j].getPointValue());
                     
                  }
                  
              }
          }
      }
        
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
         // setOnMouseClicked(newBall);
      }else{
          brickCollision();
 
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
                   // bricks[i][j].setStroke();
                    this.getChildren().add(bricks[i][j]);

                }
            }

        }
    }
    public void handleCollisions(){
        if(ball.getBottomEdge()>=pad.getY()&&ball.getRightEdge()>pad.getX()&&ball.getLeftEdge()<pad.getX()+pad.getWidth()){
                ball.setCenterY(pad.getY()-(ball.getRadius()+1));
                ball.setDirection(360-ball.getDirection());
        }

    }
    public void moveBall(){
        ball.move();
    }
    public void newBall(){
    if(!ball.isVisible()){
        direction=225+ran.nextInt(90);
        this.ball.setCenterY(this.pad.getY()-ball.getRadius());
        this.ball.setDirection(direction);
        this.ball.setCenterX(this.pad.getX()+this.pad.getWidth()/2);
        this.setBallVisibility(true);
    }
       
      
        
    }
    public void setBallVisibility(Boolean visibility){
        ball.setVisible(visibility);
    }

    public void movePaddle(double xLoc) {

        pad.move(xLoc);
    }
}
