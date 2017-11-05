/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;
import javafx.scene.paint.Color;

/**
 *
 * @author charles randall
 */
public class BrickBreakerIO {

    public static Level[] readConfigFile(String cFileName) {
        Level[] num = new Level[0];
        try {
            Scanner input = new Scanner(new File(cFileName));
            int numlvl = Integer.parseInt(input.next());
            num = new Level[numlvl];

            for (int i = 0; i < num.length; i++) {
                int levelnum = Integer.parseInt(input.next());
                int numBkRow = Integer.parseInt(input.next());
                num[i] = new Level(levelnum, numBkRow);
                for (int j = 0; j < numBkRow; j++) {
                    int bkRowNum = Integer.parseInt(input.next());
                    int red = Integer.parseInt(input.next());
                    int green = Integer.parseInt(input.next());
                    int blue = Integer.parseInt(input.next());
                    Color clr;
                    clr = Color.rgb(red, green, blue);
                    int ptVal = Integer.parseInt(input.next());
                    String bMask = input.next();
                    BrickRow bkset = new BrickRow(ptVal, clr, bMask);
                    num[i].setBrickRows(bkRowNum, bkset);

                }
                System.out.println(num[i].toString());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File could not be read");
            System.exit(-1);
        }
        return num;
    }

    public static void readProfiles(GameProfiles gmProf, String pFileName) {
        try {
            Scanner input = new Scanner(new File(pFileName));
            PlayerProfile profile = new PlayerProfile();
            while (input.hasNext()) {
                profile = new PlayerProfile(input.next());
                profile.setNumGamesPlayed(Integer.parseInt(input.next()));
                profile.setHighScore(Integer.parseInt(input.next()));
                int numSaved = Integer.parseInt(input.next());
                for (int i = 0; i < numSaved; i++) {
                    profile.addSavedGame(input.next());
                }
                gmProf.addProfile(profile);
            }

            System.out.println(gmProf.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("file not read");
            Logger.getLogger(BrickBreakerIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public static void writeProfiles(GameProfiles gmProf, String pFileName) {
        PrintWriter  input=null;
        PrintWriter output=null;
        try {
            input = new PrintWriter(pFileName);
            output = new PrintWriter(input);
            output.write(gmProf.toString());

            
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(BrickBreakerIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            try{
                if(output!=null){
                    output.close();
                }
                if(input!=null){
                    input.close();
                }
            } catch(Exception ex){
                
            }
        }

		}
    }
