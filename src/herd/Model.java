/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author jerensuzuki
 */
public class Model {
    
    private DataReader aReader;
    private EventSystem es;  
    private Session session;
    private Users currentUser;
    private boolean attempt;
    
    Model()
    {
      es = es.getInstance();
      session = new Session(es.getUsers());
      attempt = false;
    }
        
    public void setReader(DataReader aReader){
        this.es = EventSystem.getInstance(); 
        this.aReader = aReader;
    }
    
//    search
//    logout
//    add to pesonal saved events
//    login check
    
    public void readData() throws IOException, ClassNotFoundException{
        DataReader data = new FileDataReader();
        
        try{
            data.load();
        }
        catch (FileNotFoundException f){
            System.out.println("There was an issue reading the file");
        }
        es = data.getEventSystem();
    }
    
    public boolean approved(String userName, String passwd){
        attempt = true;
       return  session.approved(userName, passwd);
    }
   

    public ArrayList<Events> getRecommended()
    {
        EventSearch rs = new RecommendedEventSearch(es, session.getCurrentUser());
        ArrayList<Events> recommended = rs.search();
        return recommended;
    }
    
    public ArrayList<Events> getAllEvents()
    {
        return es.getEvents();
    }
    
    public ArrayList<Events> getSavedEvents()
    {
        return session.getCurrentUser().getSavedEvents();
    }
   
    boolean getAttempt()
    {
        return attempt;
    }
    
    void resetAttempt()
    {
        attempt = false;
    }
    
    public ArrayList<Events> getFilteredEvents(String tag)
    {
        EventSearch ts = new TagEventSearch(es, tag);
        ArrayList<Events> filtered = ts.search();
        return filtered;
    }
    
    
}
