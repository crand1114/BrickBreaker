/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.BrickBreakerIO;
import brickbreakerstudent.BrickRow;
import brickbreakerstudent.GameProfiles;
import brickbreakerstudent.Level;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


/**
 *
 * @author CDOGG_000
 */
public class GameBoard extends BorderPane{
    private PlayArea playArea;
    private GameProfiles profiles=new GameProfiles();
    private int currentLevel;
    private Level[] levels;
    private String profileFilename;
    private PaddleHandler paddleHandler;
    private Timer timer= new Timer();
    private long previous;
    private Ball ball;
    private int paHeight=700;
    private int paWidth=600;
    private Random ran = new Random();
    private Paddle pad;
    private NewBall newBall=new NewBall();
    private StartBall startBall=new StartBall();
    private ScorePane score;
    
    
    public GameBoard(Level[] level, GameProfiles prof, String pname){
        //int direction= ran.nextInt();
        score=new ScorePane();
        levels=level;
        this.profileFilename=pname;
        profiles=prof; 
        this.setTop(score);
        playArea=new PlayArea(paHeight,paWidth,levels[currentLevel],score); 
        paddleHandler=new PaddleHandler();
        this.setTop(score);
        this.setCenter(playArea);
        this.setOnMouseMoved(paddleHandler);
        this.setOnMousePressed(newBall);
        
    }


    public class PaddleHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {
           double position = event.getX();
            playArea.movePaddle(event.getX());
           
          }
    }
     public class StartBall implements EventHandler<MouseEvent>{
            @Override
            public void handle (MouseEvent e){

                timer.start();
                
            }
        }
    
    
        public class NewBall implements EventHandler<MouseEvent>{
            @Override
            public void handle (MouseEvent e){
                timer.stop();
                    playArea.newBall();
                
                timer.start();
                
            }
        }
        
    
    private class Timer extends AnimationTimer{

        @Override
        public void handle(long now) {
            ball=playArea.getBall();
            pad=playArea.getPad();
            if(now-previous >=20000000){
                playArea.moveBall();
                playArea.checkCollisions();
            }
            if(ball.getCenterY()-ball.getRadius()<=0){
                ball.setCenterY(ball.getRadius()+1);
                ball.setDirection(360-ball.getDirection());

                
            }
               if(ball.getTopEdge()>paHeight+10){
                ball.setCenterY(paHeight-(ball.getRadius()+1));
                ball.setDirection(360-ball.getDirection());
                ball.setVisible(false);

                setOnMousePressed(newBall);
               
                
            }
            
            if(ball.getCenterY()+ball.getRadius()>=pad.getY()){


            }
            
             if(ball.getCenterX()+ball.getRadius()<=0){
                playArea.brickCollision();
                ball.setCenterX(ball.getRadius()+1);
                if(ball.getDirection()<180){
                ball.setDirection(90+(90-ball.getDirection()));
               
                 
            }
                else{
                    ball.setDirection(270+(270-ball.getDirection()));

                     
                    
                }
            } 
             if(ball.getCenterX()-ball.getRadius()>=paWidth){
                ball.setCenterX(paWidth-(ball.getRadius()+1));
                if(ball.getDirection()<180){
                ball.setDirection(90+(90-ball.getDirection()));
                
                 
            }
                else{playArea.brickCollision();
                    ball.setDirection(270+(270-ball.getDirection()));
                    
                     
                }
            }
            
                   }
    
}
    

       
    
}
