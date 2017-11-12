/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

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
    private int currentLevel=0;
    private Level[] levels;
    private String profilesFilename;
    private EventHandler<MouseEvent> paddleHandler;
    
    
    public GameBoard(Level[] level, GameProfiles prof, String profFilename){
        levels=level;
        profiles=prof;
        profilesFilename=profFilename;
        Level lvl= new Level();
        playArea=new PlayArea(700,600,lvl);
        this.getChildren().add(playArea);
        this.setOnMouseMoved(paddleHandler);
        
    }
    
}
