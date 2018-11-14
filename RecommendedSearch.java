/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;
import java.util.*;

/**
 *
 * @author Emily
 */
public class RecommendedSearch implements EventSearch{
    
    RecommendedSearch(){};
    
   @Override
   public ArrayList<Events> search(ArrayList<Events> events, Users user)
   {
        ArrayList<Events> recommended = new ArrayList();
//        ArrayList<Events> eventsCopy = events;
       
        ArrayList<String> interests = user.getInterest();

        for (int j = 0; j < interests.size(); j++)
        {
           for (int k = 0; k < events.size(); k++)
           {
               ArrayList eventTags = events.get(k).getTags();

               for (int x = 0; x < eventTags.size(); x++)
               {
                   if (eventTags.get(x) == interests.get(j))
                   {
                       if (!recommended.contains(events.get(k)))
                       {
                           recommended.add(events.get(k));
                       }
                       break;
                       
                       
                   }
               }
           }
        }

        return recommended;
   }
   
 
    
}
