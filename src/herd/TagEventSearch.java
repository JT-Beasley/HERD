/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.util.ArrayList;

/**
 *
 * @author Emily
 */
public class TagEventSearch implements EventSearch{
    
    private EventSystem m_EventSystem;
    private String m_Tag;

    public TagEventSearch(EventSystem es, String tag) {
        m_EventSystem = es;
        m_Tag = tag;
    }

    @Override
    public ArrayList<Events> search() {
        ArrayList<Events> matches = new ArrayList();
        ArrayList<Events> events = m_EventSystem.getEvents();
        ArrayList<String> tags;

            for (Events event : events)
            {
                tags =  event.getTags();
                for (int i = 0; i < tags.size(); i++)
                {
                    if (tags.get(i).equals(m_Tag))
                    {
                        matches.add(event);
                        break;
                    }
                }
                    
            }

        return matches;
    }
    
}
