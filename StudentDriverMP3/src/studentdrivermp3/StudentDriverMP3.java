/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.BrickBreakerIO;
import brickbreakerstudent.GameProfiles;
import brickbreakerstudent.PlayerProfile;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author charles randall
 */
public class StudentDriverMP3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root=new GridPane();
        String configFilename = "brickbreaker.txt";
        String profileFilename = "brickbreakerprofiles.txt";
             
        ProfilePane pPane = new ProfilePane(profileFilename, configFilename);
            GameProfiles gameProf=new GameProfiles();

            
            pPane.setPrefSize(400, 200);
        
      root.getChildren().add(pPane);

        
 
        Scene scene = new Scene(root,720, 360);      
 
        primaryStage.setTitle("Brick Breaker");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
