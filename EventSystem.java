package herd;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author Emily
 */
public class EventSystem implements Serializable{
    
    private ArrayList<Events> m_Events = new ArrayList();
    private ArrayList<Users> m_Users =  new ArrayList();
    
    public EventSystem(){};
    
    public ArrayList getEvents(){
        return m_Events;
    }
    
    public ArrayList getUsers(){
        return m_Users;
    }
    
    public void addEvent(Events event){
        m_Events.add(event);
    }
    
    public void addUser(Users user){
        m_Users.add(user);
    }
    
    public void removeEvent(Events event){  
        m_Events.remove(event);
    }
    
    public void removeUser(Users user){  
        m_Events.remove(user);
    }
}