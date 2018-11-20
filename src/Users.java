
/**
 *
 * @author jtbea
 */
import java.util.ArrayList;
import java.io.Serializable;

public class Users implements Serializable {

    private String name;
    private String password;
    private ArrayList<String> interests;
    private ArrayList<Events> savedEvents;

    public Users() {
    }

    /**
     *
     * @param inputName
     * @param inputPassword
     * @param inputInterests
     */
    public Users(String inputName, String inputPassword, ArrayList<String> inputInterests) {
        name = inputName;
        password = inputPassword;
        interests = inputInterests;
        savedEvents = new ArrayList();
    }

    /**
     * sets the name of the user
     *
     * @param username
     */
    public void setName(String username) {
        name = username;
    }

    /**
     * sets an interest for the user's account
     *
     * @param userInterest
     */
    public void addInterests(String userInterest) {
//        System.out.println("I am trying to add" + userInterest);
        if (interests.contains(userInterest)) {
        } else {
            interests.add(userInterest);
        }
        
//        System.out.println(interests.get(0));
    }

    public void removeInterests(String userInterest) {
        interests.remove(userInterest);
        if (interests.isEmpty()) {
            interests = new ArrayList();
        }
    }

    /**
     * retrieves the user's name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a list of interests
     *
     * @return
     */
    public ArrayList<String> getInterest() {
        return interests;
    }

    /**
     * sets the user's password
     *
     * @param pass
     */
    public void setPassword(String pass) {
        password = pass;
    }

    /**
     * returns the password of the user's account
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * save an event to the user's account
     *
     * @param event
     */
    public void addSavedEvent(Events event) {
        savedEvents.add(event);
    }

    public void removeSavedEvent(Events event) {
        savedEvents.remove(event);
    }

    /**
     * returns an event from the savedEvents array list
     *
     * @return
     */
    public ArrayList<Events> getSavedEvents() {
        return savedEvents;
    }
}
