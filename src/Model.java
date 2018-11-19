
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerensuzuki
 */
public final class Model {

    private EventSystem es;
    private final Session session;
    private boolean attempt;
    private final DataReader data;

    Model() {
        // MUST BE IN THIS ORDER
        data = new FileDataReader();
        try {
            readData();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        session = new Session(es.getUsers());
        attempt = false;
    }

    /**
     * Opens the serialized file, creates one if it doesn't exist
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void readData() throws IOException, ClassNotFoundException {
        try {
            data.load();
        } catch (FileNotFoundException f) {
            System.out.println("There was an issue reading the file");
        }
        es = data.getEventSystem();
    }

    /**
     * Processes the login with the given username and password
     *
     * @param userName
     * @param passwd
     * @return
     */
    public boolean approved(String userName, String passwd) {
        attempt = true;
        return session.approved(userName, passwd);
    }

    /**
     * Returns the list of recommended events for a given user
     *
     * @return
     */
    public ArrayList<Events> getRecommended() {
        RecommendedEventSearch rs = new RecommendedEventSearch(es, session.getCurrentUser());
        ArrayList<Events> recommended = rs.search();
        return recommended;
    }

    /**
     * Returns all events in the EventSystem
     *
     * @return
     */
    public ArrayList<Events> getAllEvents() {
        return es.getEvents();
    }

    /**
     * Returns the list of saved events for a given user
     *
     * @return
     */
    public ArrayList<Events> getSavedEvents() {
        return session.getCurrentUser().getSavedEvents();
    }

    /**
     * Adds a single event to the current user only if it doesn't already exist
     * in their saved events
     *
     * @param eventID
     */
    public void setSavedEvent(int eventID) {
        // Search the list of events for one that matches the event ID
        EventSearchByID esid = new EventSearchByID(es, eventID);
        Events anEvent = esid.search();

        ArrayList<Events> currentSavedEvents = session.getCurrentUser().getSavedEvents();

        // Checks to make sure you don't already have the saved event in your list
        if (currentSavedEvents.contains(anEvent)) {
            // do nothing
        } else {
            session.getCurrentUser().addSavedEvent(anEvent);
        }
    }
    
    public void removeSavedEvent(int eventID){
        EventSearchByID esid = new EventSearchByID(es, eventID);
        Events anEvent = esid.search();
        ArrayList<Events> currentSavedEvents = session.getCurrentUser().getSavedEvents();
        
        if (currentSavedEvents.contains(anEvent)){
            session.getCurrentUser().removeSavedEvent(anEvent);
        }
    }

    /**
     * Keeps track of whether the login was attempted
     *
     * @return
     */
    boolean getAttempt() {
        return attempt;
    }

    /**
     * Resets a boolean flag to allow for retries
     */
    void resetAttempt() {
        attempt = false;
    }

    /**
     * Returns only a specific list of events based on tags
     *
     * @param tag
     * @return
     */
    public ArrayList<Events> getFilteredEvents(String tag) {
        TagEventSearch ts = new TagEventSearch(es, tag);
        ArrayList<Events> filtered = ts.search();
        return filtered;
    }

    /**
     * Creates a new event given a set of inputs
     *
     * @param title
     * @param date
     * @param location
     * @param startT
     * @param endT
     * @param tagList
     * @param descript
     */
    public void addEvent(String title, String date, String location,
            String startT, String endT, ArrayList<String> tagList,
            String descript) {
        Events event = new Events(date, location, startT, endT, tagList,
                title, descript);
        es.addEvent(event);
    }

    public void logout() throws IOException {
        try {
            data.save(es);
        } catch (IOException f) {
            System.out.println("There was an issue saving the file");
        }
        System.exit(0);
    }
    
    public void addInterests(String userInterest){
        session.getCurrentUser().addInterests(userInterest);
    }
    
    public void removeInterests(String userInterest){
        session.getCurrentUser().removeInterests(userInterest);
    }

}
