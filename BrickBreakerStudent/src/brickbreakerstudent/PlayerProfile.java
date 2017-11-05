/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

import java.util.ArrayList;

/**
 *
 * @author charles randall
 */
public class PlayerProfile {
    private String name;
    private int numGamesPlayed;
    private int highScore;
    private ArrayList<String>savedGames;
    
   public PlayerProfile(){
        
    }
   public PlayerProfile(String name){
       this.name=name;
       savedGames=new ArrayList<>();
       
   }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numGamesPlayed
     */
    public int getNumGamesPlayed() {
        return numGamesPlayed;
    }

    /**
     * @param numGamesPlayed the numGamesPlayed to set
     */
    public void setNumGamesPlayed(int numGamesPlayed) {
        this.numGamesPlayed = numGamesPlayed;
    }

    /**
     * @return the highScore
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * @param highScore the highScore to set
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
    public int getNumSavedGames(){
        return savedGames.size();
    }
    public String getSavedGame(int index){
        return savedGames.get(index);
    }  
    public void addSavedGame(String item){
       savedGames.add(item);
   }
   public void setSavedGame(int index, String item){
        savedGames.add(index, item);
   }

   public String deleteSavedGame(int index){
       return savedGames.remove(index);
   }   
   @Override
   public String toString(){
      String format= "";
      format+= name+System.lineSeparator()+ numGamesPlayed+System.lineSeparator()+highScore+System.lineSeparator()+savedGames.size();
      
      for(int i=0;i<savedGames.size();i++){
     format+=System.lineSeparator()+savedGames.get(i);
     
     
     }
     return format;
     
     
      
     
}
}
