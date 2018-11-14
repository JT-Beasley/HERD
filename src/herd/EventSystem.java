package herd;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author Emily
 */
public class EventSystem implements Serializable{
    
    private ArrayList<Events> m_Events;
    private ArrayList<Users> m_Users;
    private static EventSystem m_Instance = null;
    
    private EventSystem()
    {
        m_Events = new ArrayList();
        m_Users =  new ArrayList();  
    }
    
    public static EventSystem getInstance()
    {
        if (m_Instance == null)
        {
            m_Instance = new EventSystem();
        }
        
        return m_Instance;
    }
    
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
        m_Users.remove(user);
    }
    
    private static class FrontToBack implements EventIterator{
        private final EventSystem data;
        private int index;
       
        
        public FrontToBack(EventSystem data) {
            this.data = data;
            index = data.m_Events.size()-1;
        }
        
        @Override
        public boolean hasNext() {
            return index >= 0;
        }
        
        @Override
        public Events next() throws NoSuchElementException {
            if (index >= 0 ) {  
                return data.m_Events.get(index--);
            }
            else 
                throw new NoSuchElementException();
        }
    }
    
    
    public EventIterator frontToBack() {
        return new FrontToBack(this);
    }
}