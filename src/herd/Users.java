/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

/**
 *
 * @author jtbea
 */

import java.util.ArrayList;
import java.io.Serializable;


public class Users implements Serializable{
    
    private String name;
    private String password;
    // Will uncomment in the future
    private ArrayList <String> interests = new ArrayList();
    
    private ArrayList <Events> savedEvents = new ArrayList();

    /**
     * 
     * @param name
     * @param passwd
     * @param interests 
     */

    
    public Users() {    
    }
    
    public Users(String name, String passwd, ArrayList<String> interests){
        this.name=name;
        this.password = passwd;
        this.interests = interests;
    }
    
    /**
     * sets the name of the user
     * @param username
     */
    
    public void setName(String username){
        this.name = username;
    }
    
    /**
     * sets an interest for the user's account
     * @param userinterests
     */
    
//    public void setInterests(ArrayList<String> userinterests)
//    {
//        for (int i = 0; i < userinterests.size(); i++) {
//            interests.add(userinterests.get(i));
//        }
//    }
    
    public void setInterests(ArrayList<String> userinterests){
        this.interests = userinterests;
    }
    
    /** 
     * retrieves the user's name
     */
    
    public String getName(){
        return name;
    }
    
    /** 
     * retrieves an interest from the user's interests list
     * @param i
     */
    // Benjamin: Updated the getInterest method to return a list of interest.
//    public ArrayList<String> getInterest()
//    {
//        return interests;
//    }
    
    public ArrayList<String> getInterest(){
        return interests;
    }
    
    /**
     * sets the user's password
     * @param pass 
     */
    public void setPassword(String pass){
        this.password = pass;
    }
    
    /**
     * returns the password of the user's account
     * @return 
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * save an event to the user's account
     * @param event 
     */
   public void setSavedEvent(ArrayList<Events> event){
       this.savedEvents = event;
   }
   
   /**
    * returns an event from the savedEvents array list
    * @param i
    * @return 
    */
   public Events getSavedEvent(int i){
       return savedEvents.get(i);
   }
}
