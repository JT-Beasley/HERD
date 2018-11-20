import java.util.ArrayList;

/**
 *
 * @author Jeren
 */
public class EventSearchByID implements Search{
    
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
    public ArrayList<Events> search(){
        allEvents = m_EventSystem.getEvents();
        ArrayList<Events> returnEvent = new ArrayList();
        
        for(Events event: allEvents){
            if(event.getHashID() == m_eventID)
            {
                someEvent = event;
                break;
            }
         }
        
        returnEvent.add(someEvent);

        return returnEvent;
    }

}
