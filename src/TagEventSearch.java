import java.util.ArrayList;

/**
 *
 * @author Emily
 */
public class TagEventSearch implements Search {

    private EventSystem m_EventSystem;
    private String m_Tag;
    private ArrayList<Events> matches;
    private ArrayList<Events> events;
    private ArrayList<String> tags;

    public TagEventSearch(EventSystem es, String tag) {
        m_EventSystem = es;
        m_Tag = tag;
    }

//    @Override
    public ArrayList<Events> search() {
        matches = new ArrayList();
        events = m_EventSystem.getEvents();

        for (Events event : events) {
            tags = event.getTags();
            for (int i = 0; i < tags.size(); i++) {
                if (tags.get(i).equals(m_Tag)) {
                    matches.add(event);
                    break;
                }
            }

        }

        return matches;
    }

}
