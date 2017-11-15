/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.BrickRow;
import brickbreakerstudent.Level;
import javafx.scene.layout.Pane;

/**
 *
 * @author CDOGG_000
 */
public class PlayArea extends Pane {
   private Brick[][] bricks; 
   private int BASE_Y=20;
   private int paHeight;
   private int paWidth;
   private Paddle pad; 
   private Brick brick;
  
   
   

   
   public PlayArea(int paHeight, int paWidth, Level level){
   
   this.paHeight=paHeight;
   this.paWidth=paWidth;
   this.setPrefSize(paWidth, paHeight);
   level= new Level();
   bricks=new Brick[level.getNumBrickRows()][level.getNumBrickRows()];
   createBricks(level);
   pad = new Paddle(paWidth,paHeight);   
   this.getChildren().add(pad);
   
   
   
   }
   private void createBricks(Level level){
       
       for(int i=0;i<level.getNumBrickRows();i++){
       BrickRow bkrow= level.getBrickRow(i);
          for(int j=0; j<level.getLevelNum();j++){
              if(bkrow.getBrickMaskValue(j)==true){
                  bricks[i][j]=new Brick(j*brick.BRICK_WIDTH,j*brick.BRICK_HEIGHT);
                  bricks[i][j].setFill(bkrow.getColor());
                  this.getChildren().add(bricks[i][j]);
                  
              }
          }

       }
   }
   
   public void movePaddle(double xLoc){
       
      pad.move(xLoc); 
   }
   }
