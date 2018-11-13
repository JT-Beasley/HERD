/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

/**
 *
 * @author jtbea
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UserSearch{
    private ArrayList <Users> users = new ArrayList();
    private EventSystem es = new EventSystem();
    private int index = 0;
    private int index_tracker = 0;

    public UserSearch(){
    }
    
    public UserSearch(ArrayList <Users> users){
        //this.es = es;
        this.users = users;
    }

    
    /**
     * adds a user to the queue
     * @param name
     */
    
//    public void createUser(String name, String passwd, ArrayList<String> interests)
//    {
//        Users user =  new Users();
//        user.Users(name, passwd, interests);
//        users.add(user);
//        index++;
//    }
    
    /**
     * returns the users queue's index
     * @return 
     */
    public int getIndex()
    {
        return this.index;
    }
    
    
    
    /**
     * checks for the next element in the array list
     * @return 
     */
    
     public boolean hasNext()
    {
        return index_tracker < index;
    }
    
    /**
     * finds the user in the users array list
     * @param name
     * @return
     * @throws NoSuchElementException 
     */
     
    public Users findUser(String name) throws NoSuchElementException
    {
        try {
            for(Users user : users )
            {
                if (name.equals(user.getName()))
                {
                    return user;   
                }
                else  
                {}
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println("User, " + name + ", Not Found");
            return null;
        }
        
        return null;
    }
    
    /**
     * prints the array of users
     */
    public void printQueue()
    {
        for(Users user: users)
        {
            System.out.println(user.getName());
        }
    }
    
    
    /**
     * saves all users as a serialized file
     * @throws IOException 
     */
//    public void saveUsersQueue() throws IOException
//    {
//        try
//        {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Users.ser"));
//            oos.writeObject(users);
//            oos.close();
//            
//            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("UsersIndex.ser"));
//            oos2.writeObject(index);
//            oos2.close();
//            
//            
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
    
    /**
     * loads the users information from the serialized files
     * @throws IOException
     * @throws ClassNotFoundException 
     */
//    public void loadUsersQueue() throws IOException, ClassNotFoundException
//    {
//        try
//        {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.ser"));
//            
//            users = (ArrayList<Users>) ois.readObject();
//            ois.close();
//            
//            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("UsersIndex.ser"));
//            index = (int) ois2.readObject();
//            ois2.close();
//            
//            
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
}