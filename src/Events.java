/**
 *
 * @author bpont
 */

import java.util.ArrayList;
import java.time.LocalTime;
import java.io.Serializable;


public class Events implements Serializable{
    
    private String date;
    private String location;
    private String startTime;
    private String endTime;
    private String title;
    private String description;
    private String eventID; // A unqiue ID createdf for each instance of an Events object. It will be the event.title concatanated with event.currTime
    private ArrayList<String> tags = new ArrayList();
    private String currTime;
    private int hashID;
//    String hourRangeTest;
//    String minuteRangeTest;
    
//  Default Constructor
    public Events(){
    }
    
    public Events(String date, String location, String startT,String endT,ArrayList<String> tagList, String title, String descript){
       
        setCurrentTime();
        this.date = date;
        this.location = location;
         
//       hourRangeTest = startT.substring(0, 2);
//       int timeTest = Integer.parseInt(hourRangeTest);
//       if(timeTest > 12)
//       {
//           System.out.println("Error not a correct time");
//           //replace with IllegalArgument exception or we can place this in another class so we can just have the user enter a correct value
//       }
       
        this.startTime = startT;
        this.endTime = endT;
        this.tags.addAll(tagList); 
        this.title = title;
        this.description = descript;
        this.eventID = title+currTime;
        this.hashID=this.hashCode();
    }
   
    public void setDate(String date){
        this.date = date;
    }
  
    public String getDate(){
        return date;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
  
    public String getLocation(){
        return location;
    }
 
    public void setStartTime(String time){
        this.startTime = time;
    }
  
    public String getStartTime(){
        return startTime;
    }
  
    public void setEndTime(String time){
        this.endTime = time;
    }
  
    public String getEndTime(){
        return endTime;
    }
  
    public void setTitle(String title){
        this.title = title;
    }
  
    public String getTitle(){
        return title;
    }
  
    public void setDescription(String descript){
        this.description = descript;
    }
  
    public String getDescription(){
        return description;
    }
  
    public void setTags(ArrayList<String> tag){
        this.tags = tag;
    }
  
    public ArrayList<String> getTags(){
        return tags;
    }
  
    public void setCurrentTime(){  
        this.currTime = java.time.LocalTime.now().toString();
    }
    
    public int getHashID(){
        return hashID;
    }
}
