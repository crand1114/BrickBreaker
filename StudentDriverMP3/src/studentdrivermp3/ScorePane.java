/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author CDOGG_000
 */
public class ScorePane extends HBox{
   private int score;
   private Label lblScore;
   
   public ScorePane(){
       
       lblScore=new Label("Score: "+ score);
  this.getChildren().add(lblScore);
  
   }

    /**
     * @return the score
     */
    public int getScore() {
        
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
   public void incrementScore(int pts){
     score+=pts;  
     lblScore.setText("Score:"+score);
   }
}
