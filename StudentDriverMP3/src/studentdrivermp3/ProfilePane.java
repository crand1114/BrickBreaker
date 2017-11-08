/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.BrickBreakerIO;
import brickbreakerstudent.GameProfiles;
import brickbreakerstudent.PlayerProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author charles randall
 */
public class ProfilePane extends GridPane {

    private GameProfiles profiles;
    private String profileFilename;
    private String configFilename;
    private Node controls;

    public ProfilePane(String profileFileName, String configFileName) {
        profileFilename = profileFileName;
        configFilename = configFileName;
        profiles=new GameProfiles();
        paneP();

    }


    private void paneP() {
       // GameProfiles gameProf = new GameProfiles();
        PlayerProfile player = new PlayerProfile();
        BrickBreakerIO.readProfiles(profiles, profileFilename);

        Button btn = new Button();
        Button b = new Button();
        Label tlabel = new Label("Create New Profile: ");
        Label plabel = new Label("Select Existing Profile: ");

        TextField text = new TextField();
        ObservableList<String> profileList = FXCollections.observableArrayList();
        for (int i = 0; i < profiles.getNumProfiles(); i++) {

                profileList.add(profiles.getProfile(i).getName() );
                
            

        }
        ListView<String> list = new ListView<>(profileList);
        list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                System.out.println(list.getSelectionModel().getSelectedItem()); //prints the selected profile in the command prompt
            }
        });

        btn.setText("Create Profile");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String input = text.getText();

                if (input.isEmpty() || profileList.contains(input)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Could not Create new Profile");
                    alert.setContentText("Please enter a valid username");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("New Profile");
                    alert.setContentText("Are you sure you want to create the new profile: " + input + "?");
                    alert.showAndWait();
                    PlayerProfile newPlay= new PlayerProfile(input);
                    profileList.add(newPlay.getName());
                    
                   profiles.addProfile(newPlay);
                    BrickBreakerIO.writeProfiles(profiles, profileFilename);
                }
                /*for(int i=0;i<profiles.size();i++){     
                    if(profiles.get(i)==null){
                        profiles.add(i,input);
                    }
                }*/
                System.out.println(input);
            }
        });

        this.setHgap(1);
        this.add(btn, 10, 0);
        this.add(tlabel, 3, 0);
        this.add(text, 6, 0);
        this.add(plabel, 0, 0);
        this.add(list, 0, 200);
    }
}
