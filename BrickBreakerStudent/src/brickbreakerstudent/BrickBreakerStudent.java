/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;


import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CDOGG_000
 */
public class BrickBreakerStudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          
            GameProfiles gameProf=new GameProfiles();
            BrickBreakerIO.readProfiles(gameProf, "brickbreakerprofiles.txt");
             PlayerProfile player=new PlayerProfile("Charles");
            player.setNumGamesPlayed(2);
            player.setHighScore(2017);
            gameProf.addProfile(player);

            BrickBreakerIO.writeProfiles(gameProf, "NPfile.txt");//adds the new profile to the list of other profiles and creates new file 
           
           
            

}
       
    }  
        
        /*GameProfiles game = new GameProfiles();
        PlayerProfile player=new PlayerProfile("Charles");
        PlayerProfile player2 = new PlayerProfile("Player2");
        
        String item="save";
        String item2="newsave";
        int j=0;
        for(int i=0;i<player.getNumGamesPlayed();i++){
        player.setHighScore(2017);
        player.addSavedGame(item);
        player.addSavedGame(item);
        player2.setNumGamesPlayed(4);
        player2.setHighScore(2018);
        player2.addSavedGame(item);
        
          }
       //System.out.println(player.toString()+player2.toString());
       game.addProfile(player);
       game.addProfile(player2);
       System.out.println(game.toString()); */

        /*try {
            BrickBreakerIO.readConfigFile("brickbreaker.txt");
            /*Level levelnum= new Level();
            
            BrickRow row = new BrickRow();
            
            for (int i=0; i<11; i++) {
            levelnum.setBrickRows(i, row);
            levelnum.setLevelNum(i);
            
            
            for(int j=0; j<20;j++){
            
            row.setBrickMaskValue(j, true);
            row.setPointValue(10);
            row.setColor(Color.BEIGE);
            
            }
            System.out.println(levelnum.toString()+row.toString());*/
            

        
       
// TODO code application logic here
   
    
    

