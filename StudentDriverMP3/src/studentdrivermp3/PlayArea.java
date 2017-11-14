/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.Level;
import javafx.scene.layout.Pane;

/**
 *
 * @author CDOGG_000
 */
public class PlayArea extends Pane {
   private Brick[][] bricks; 
   private int BASE_Y;
   private int paHeight=20;
   private int paWidth=35;
   

   
   public PlayArea(int paHeight, int paWidth, Level level){
   this.paHeight=paHeight;
   this.paWidth=paWidth;
  // bricks=new Brick[level.getLevelNum()][level.];
   //Brick brick=new Brick();
   level=new Level();
   //createBricks(level);
   Paddle pad= new Paddle(paWidth,paHeight); 
   this.getChildren().add(pad);
  //this.getChildren().add(bricks);
   
   
   }
   private void createBricks(Level level){
   for(int i=0;i<bricks.length;i++){
       for(int j=0;j<bricks.length;i++){
       bricks=new Brick[i][j];
       }
   }
   }
   public void movePaddle(double xLoc){
       Paddle pad =new Paddle(paWidth,paHeight);
      pad.move(xLoc); 
   }
   }
