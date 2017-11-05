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
public class GameProfiles {

    private PlayerProfile selectedProfile;
    private PlayerProfile highGameProfile;
    private ArrayList<PlayerProfile>profiles;
    private String profileFilename;
    
    public GameProfiles(){
        profiles=new ArrayList<PlayerProfile>();
        selectedProfile=new PlayerProfile();
        highGameProfile=new PlayerProfile();
    }
    public PlayerProfile getSelectedProfile(){
        return selectedProfile;
    }

    /**
     *
     */
    public PlayerProfile getHighGameProfile(){
       return highGameProfile;
}
    public void setHighGameProflie(PlayerProfile prof){
    highGameProfile=prof;    
    }
    public int getNumProfiles(){
        return profiles.size();
    }
    public PlayerProfile getProflie(int index){
        return profiles.get(index);
    }
    public void setProfile(int index,PlayerProfile item){
        profiles.add(index, item);
    }
    public void addProfile(PlayerProfile item){
        profiles.add(item);
    }
    public PlayerProfile deleteProfile(int index){
        return profiles.remove(index);
    }
    public String toString(){
        String playform="";
        for(int i=0;i<profiles.size();i++){
            playform+=profiles.get(i)+System.lineSeparator();
    }
        return playform;
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
}
