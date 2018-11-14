/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.util.*;

/**
 *
 * @author Jeren?
 */
public class RecommendedEventSearch implements Search {

//    RecommendedSearch(){};
    private ArrayList<Events> m_Events;
    private EventSystem m_EventSystem;

    public RecommendedEventSearch(EventSystem es) {
        m_Events = es.getEvents();
        m_EventSystem = es;
    }

    @Override
    public ArrayList<Events> search(Users user) {
        ArrayList<String> interests = user.getInterest();
        ArrayList<Events> recommended = new ArrayList();

        EventIterator eventIter = m_EventSystem.frontToBack();

        //while (it.hasNext())
        //  System.out.println(it.next());    
        //}
        for (int j = 0; j < interests.size(); j++) {
            while (eventIter.hasNext()) {
                Events event = eventIter.next();
                ArrayList eventTags = event.getTags();

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
