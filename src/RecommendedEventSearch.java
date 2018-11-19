
import java.util.*;

/**
 *
 * @author Jeren?
 */
public class RecommendedEventSearch implements Search {

    private final EventSystem m_EventSystem;
    private final Users m_User;
    private ArrayList<String> interests;
    private ArrayList<Events> recommended;
    private ArrayList<Events> events;
    private ArrayList eventTags;

    /**
     *
     * @param es
     * @param user
     */
    public RecommendedEventSearch(EventSystem es, Users user) {
        m_EventSystem = es;
        m_User = user;
        recommended = new ArrayList();
    }

//    @Override
    public ArrayList<Events> search() {
        interests = m_User.getInterest();
        events = m_EventSystem.getEvents();

        
        for (int j = 0; j < interests.size(); j++) {
            for (Events event : events) {
                eventTags = event.getTags();

                for (int x = 0; x < eventTags.size(); x++) {
                    if (eventTags.get(x) == interests.get(j)) {
                        recommended.add(event);
                        break;
                    }
                }
            }
        }
        return recommended;
    }
}
