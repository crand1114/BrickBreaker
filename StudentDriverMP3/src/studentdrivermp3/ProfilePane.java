/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdrivermp3;

import brickbreakerstudent.GameProfiles;
import javafx.scene.Node;
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
    
    public ProfilePane(String profileFileName, String configFileName){
        profileFilename=profileFileName;
        configFilename=configFileName;
        
    }

    /**
     * @return the profiles
     */
    public GameProfiles getProfiles() {
        return profiles;
    }

    /**
     * @param profiles the profiles to set
     */
    public void setProfiles(GameProfiles profiles) {
        this.profiles = profiles;
    }

    /**
     * @return the profileFilename
     */
    public String getProfileFilename() {
        return profileFilename;
    }

    /**
     * @param profileFilename the profileFilename to set
     */
    public void setProfileFilename(String profileFilename) {
        this.profileFilename = profileFilename;
    }

    /**
     * @return the configFilename
     */
    public String getConfigFilename() {
        return configFilename;
    }

    /**
     * @param configFilename the configFilename to set
     */
    public void setConfigFilename(String configFilename) {
        this.configFilename = configFilename;
    }

    /**
     * @return the controls
     */
    public Node getControls() {
        return controls;
    }

    /**
     * @param controls the controls to set
     */
    public void setControls(Node controls) {
        this.controls = controls;
    }
    
}
