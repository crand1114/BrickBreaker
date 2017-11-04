/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickgui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author CDOGG_000
 */
public class BrickGui extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
       Button b=new Button();
       Label tlabel=new Label("Create New Profile: ");
       Label plabel=new Label("Select Existing Profile: ");
        TextField text= new TextField();
        ObservableList<String> profiles= FXCollections.observableArrayList();
        profiles.add(0, "Profile 1");
        profiles.add(1, "Profile 2");
        profiles.add(2, "Profile 3");
        ListView<String> list=new ListView<>(profiles);
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
                    Alert alert= new Alert(AlertType.ERROR);
                    alert.setTitle("Could not Create new Profile");
                    alert.setContentText("Please input a valid username");
                    alert.showAndWait();
                }else{
                     Alert alert= new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("New Profile");
                    alert.setContentText("Are you sure you want to create the new profile: "+input+"?");
                    alert.showAndWait();
                }
                 for(int i=0;i<profiles.size();i++){     
                    if(profiles.get(i)==null){
                        profiles.add(i,input);
                    }
                    
                }
                System.out.println(input);
            }
        });
        
        GridPane root = new GridPane();

        root.setHgap(1);
        root.add(btn,7,0);
       // root.getChildren().add(b);
        root.add(tlabel,5,0);
        root.add(text,6,0);
        root.add(plabel,0,0);
       root.add(list,0,200);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Brick Breaker Profile Selection");
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
