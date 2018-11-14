/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.util.*;

import java.io.IOException;

/**
 *
 * @author jtbea
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
//        NewJPanel aDriver = new NewJPanel();
        
        
        
//       MakeSerializableFile msf = new MakeSerializableFile();
//        Model aModel = new Model();
//        aModel.setReader(new FileDataReader());
        DataReader data = new FileDataReader();
        data.load();
        EventSystem es = data.getEventSystem();
//       EventSystem es = msf.getEventSystem();
//       RecommendedSearch rs = new RecommendedSearch();
        RecommendedEventSearch recSearch = new RecommendedEventSearch(es);
        Users activeUser = new Users();
        ArrayList<Events> re = new ArrayList();

        System.out.println("For your testing puposes, your sample username will be Zhang and your password will be pass, but you will not have any recommended events.");
        System.out.println("To see a user with recommended events, the username will be Emily and the password will be pass.");

        Session session = new Session(es.getUsers());
        session.Login();
            
        activeUser = session.getCurrentUser();
        
        if (activeUser.getName() != null) {
            System.out.println("Welcome, " + activeUser.getName());
            if (activeUser.getSavedEvents().isEmpty() != true ) {
                System.out.println("You've already got saved events, here they are: ");
                for (int i = 0; i < activeUser.getSavedEvents().size(); i++) {
                    System.out.println(activeUser.getSavedEvents().get(i).getTitle());
                }
            }
        }
        

        re = recSearch.search(session.getCurrentUser());

        if (re.isEmpty() == false) {
            System.out.println("Your recommended events are...");
            // Add arraylist of events to user profile
            activeUser.setSavedEvent(re);

            for (int i = 0; i < re.size(); i++) {
                try {
                    System.out.println(re.get(i).getTitle());
                } catch (NullPointerException e) {
                    System.out.println("No recommendations found.");
                }
            }
            
        }

        session.getCurrentUser().setSavedEvent(re);
        
        session.Logout(data,es);

        
        
//       queue.printQueue();
//       
//       System.out.println((queue.findUser("Joe")).getName());
//       System.out.println((queue.findUser("Joe")).getPassword());
//       
//       session.Session(queue);
//       
//       mi.MatchInterests(jeren, recievedEventList);
    }

}
