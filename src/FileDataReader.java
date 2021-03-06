import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jerensuzuki
 */
public class FileDataReader implements DataReader {

    private EventSystem es;
    
    public FileDataReader(){
        es = EventSystem.getInstance();
    }

    @Override
    public void load() throws IOException, ClassNotFoundException {

        //This will deserialize the file if it exist, otherwise it will create a serialized file with hardcode Events & Users objects 
        try (FileInputStream fi = new FileInputStream("EventSystem.ser")) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fi);
            ObjectInputStream ois = new ObjectInputStream(bufferedInputStream);
            es = (EventSystem)ois.readObject();
//            
//            ArrayList<Events> ale = es.getEvents();
//            ArrayList<Users> alu = es.getUsers();
//            
//            for(Events event : ale){
//                System.out.println(event.getTitle());
//            }
//            for(Users user:alu){
//                System.out.println(user.getName());
//            }
            
            
            ois.close();

        } catch (FileNotFoundException f) {

            //Details for event 1
            String date = "10/24/2018";
            String location = "Honest Coffee Roasters";
            String startTime = "5:00PM";
            String endTime = "8:00PM";
            String title = "Barista Class";
            String description = "Class that teaches you about coffee";
            ArrayList<String> tags = new ArrayList();
            tags.add("Food");

            //Details for event 2
            String date2 = "10/26/2018";
            String location2 = "Willy T's Concert Hall";
            String startTime2 = "1:00AM";
            String endTime2 = "4:00PM";
            String title2 = "YelaWolf Live Concert";
            String description2 = "Rapper YelaWolf live in concert";
            ArrayList<String> tags2 = new ArrayList();
            tags2.add("Music");

            //Details for event 3
            String date3 = "10/26/2018";
            String location3 = "Clinton Row";
            String startTime3 = "4:30PM";
            String endTime3 = "8:00PM";
            String title3 = "Clinton Avenue Block Party";
            String description3 = "An evening of live music from Rob Aldridge & The Proponents, free cocktails and hors d'oeuvres, discounted shopping, prize giveaways, and much more!";
            ArrayList<String> tags3 = new ArrayList();
            tags3.add("Food");
            tags3.add("Music");
            tags3.add("Party");

            //Details for event 4
            String date4 = "10/27/2018";
            String location4 = "Links at Redstone Golf Course";
            String startTime4 = "9:00AM";
            String endTime4 = "1:00PM";
            String title4 = "14th Annual Chili Cook Off and Scramble";
            String description4 = "Bring 4 people and one pot of chili for this cook off and scramble event. Breakfast provided, Tee gifts, Beverage provided after the round, and a Hole in One contest";
            ArrayList<String> tags4 = new ArrayList();
            tags4.add("Food");
            tags4.add("Sports");

            // Adding Events Objects to eventList
            es.addEvent(new Events(date, location, startTime, endTime, tags, title, description));
            es.addEvent(new Events(date2, location2, startTime2, endTime2, tags2, title2, description2));
            es.addEvent(new Events(date3, location3, startTime3, endTime3, tags3, title3, description3));
            es.addEvent(new Events(date4, location4, startTime4, endTime4, tags4, title4, description4));

            //Detail for Benjamin
            ArrayList<String> interest = new ArrayList();
            interest.add("Sports");
            interest.add("Music");

            //Detail for Jeren
            ArrayList<String> interest2 = new ArrayList();
            interest2.add("Food");
            interest2.add("Party");

            //Detail for JT
            ArrayList<String> interest3 = new ArrayList();
            interest3.add("Music");
            interest3.add("Party");

            //Detail for Emily
            ArrayList<String> interest4 = new ArrayList();
            interest4.add("Sports");
            interest4.add("Food");

            //Detail for Zhang
            ArrayList<String> interest5 = new ArrayList();
            interest5.add("Computers");
            interest5.add("Cars");

            es.addUser(new Users("Benjamin", "pass", interest));
            es.addUser(new Users("Jeren", "pass", interest2));
            es.addUser(new Users("JT", "pass", interest3));
            es.addUser(new Users("Emily", "pass", interest4));
            es.addUser(new Users("Zhang", "pass", interest5));
        }
    }

    @Override
    public EventSystem getEventSystem() {
        return es;
    }

    @Override
    public void save(EventSystem eventsystem) throws IOException {   //Serializing instance of EventSystem
        try (FileOutputStream fo = new FileOutputStream("EventSystem.ser")) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fo);
            ObjectOutputStream oos = new ObjectOutputStream(bufferedOutputStream);
            //Writing EventSystem instance to serialized file
          
//            System.out.println("Saving to file:");
//            ArrayList<Events> ale = eventsystem.getEvents();
//            ArrayList<Users> alu = eventsystem.getUsers();
//            
//            for(Events event : ale){
//                System.out.println(event.getTitle());
//            }
//            for(Users user:alu){
//                System.out.println(user.getName());
//            }
            
            oos.writeObject(eventsystem);
            oos.close();
        } catch (IOException i) {
            System.out.println("There was an error writing the file");
        }
    }
}
