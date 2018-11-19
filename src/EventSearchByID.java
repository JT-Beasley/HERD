import java.util.ArrayList;

/**
 *
 * @author Jeren
 */
public class EventSearchByID extends EventSearch{
    
    private Events someEvent;
    private EventSystem m_EventSystem;
    private int m_eventID;
    private ArrayList<Events> allEvents;
    
    public EventSearchByID(EventSystem es, int someInt){
        m_EventSystem = es;
        m_eventID = someInt;
        someEvent = null;
    }
    
    @Override
    public Events search(){
        allEvents = m_EventSystem.getEvents();
        
        for(Events event: allEvents){
            if(event.getHashID() == m_eventID) someEvent = event;
            break;
        }
        return someEvent;
    }

}
