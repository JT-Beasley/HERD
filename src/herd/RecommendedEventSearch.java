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
public class RecommendedEventSearch implements EventSearch {

    private EventSystem m_EventSystem;
    private Users m_User;

    public RecommendedEventSearch(EventSystem es, Users user) {
        m_EventSystem = es;
        m_User = user;
    }

    @Override
    public ArrayList<Events> search() {
        ArrayList<String> interests = m_User.getInterest();
        ArrayList<Events> recommended = new ArrayList();
        ArrayList<Events> events = m_EventSystem.getEvents();

        for (int j = 0; j < interests.size(); j++) {
            for (Events event : events) {
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
