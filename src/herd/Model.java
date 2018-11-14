/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author jerensuzuki
 */
public class Model {
    
    private DataReader aReader;
    private EventSystem es = EventSystem.getInstance();    
    Session session = new Session(es.getUsers());
        
    public void setReader(DataReader aReader){
        this.aReader = aReader;
    }
    
//    search
//    logout
//    add to pesonal saved events
//    login check
    
    public void readData() throws IOException, ClassNotFoundException{
        DataReader data = new FileDataReader();
        
        try{
            data.load();
        }
        catch (FileNotFoundException f){
            System.out.println("There was an issue reading the fle");
        }
        es = data.getEventSystem();
    }
    
    public boolean approved(String userName, String passwd){
       return session.approved(userName, passwd);

    }
    
}
