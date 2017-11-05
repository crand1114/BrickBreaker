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
        
        String configFilename = "brickbreaker.txt";
        String profileFilename = "brickbreakerprofiles.txt";
             
        
            GameProfiles gameProf=new GameProfiles();
            PlayerProfile player = new PlayerProfile();
            BrickBreakerIO.readProfiles(gameProf, profileFilename);
        
        
        
       Button btn = new Button();
       Button b=new Button();
       Label tlabel=new Label("Create New Profile: ");
       Label plabel=new Label("Select Existing Profile: ");
        TextField text= new TextField();
        ObservableList<PlayerProfile> profiles= FXCollections.observableArrayList();
        for(int i=0; i<gameProf.getNumProfiles();i++){
        profiles.add(gameProf.getProflie(i));
        }
        ListView<PlayerProfile> list=new ListView<>(profiles);
        list.setOnMouseClicked(new EventHandler<MouseEvent>(){
        
        @Override
        public void handle(MouseEvent event) {
    
           System.out.println(list.getSelectionModel().getSelectedItem()); //prints the selected profile in the command prompt
        }
        });
 
        btn.setText("Create Profile");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String input= text.getText();
                
                if(input.isEmpty()|| profiles.contains(input)){
                    Alert alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Could not Create new Profile");
                    alert.setContentText("Please enter a valid username");
                    alert.showAndWait();
                }else{
                     Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("New Profile");
                    alert.setContentText("Are you sure you want to create the new profile: "+input+"?");
                    alert.showAndWait();
                }
                 /*for(int i=0;i<profiles.size();i++){     
                    if(profiles.get(i)==null){
                        profiles.add(i,input);
                    }
                    
                }*/
                System.out.println(input);
            }
        });
        



        

        ProfilePane root = new ProfilePane(profileFilename, configFilename);
        Scene scene = new Scene(root, 400, 200);      
        root.setHgap(1);
        root.add(btn,7,0);
        root.add(tlabel,5,0);
        root.add(text,6,0);
        root.add(plabel,0,0);
        root.add(list,0,200);  
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
