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
    
    
    public GameBoard(Level[] level, GameProfiles prof, String profileFilename){
        levels=level;
        level= new Level[currentLevel];
        this.profileFilename=profileFilename;
        profiles=prof;
        BrickRow bk=new BrickRow();
        Level lvl= new Level(currentLevel,level.length );
        playArea=new PlayArea(600,700,lvl);
        this.profileFilename=profileFilename;
        this.setCenter(playArea);
        this.setOnMouseMoved(paddleHandler);
        
        
    }
    public class PaddleHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {
           double position = event.getX();
           
           if(event.getX()>600||event.getX()<600){
           System.out.println(event.getX());
           playArea.movePaddle(event.getX());
           }
          }
        
    }
    
}
