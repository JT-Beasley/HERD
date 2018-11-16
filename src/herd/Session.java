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
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class Session {

    private ArrayList<Users> users;
    private UserSearch us;
    private String currentUser;
    private int index;
    private Scanner scanner;
    private boolean validUserName;
    private boolean validPassword;
    private Users activeUser;

    /**
     * checks login info for users
     */
    public Session() {

        us = new UserSearch();
        currentUser = new String();
        index = 0;
        scanner = new Scanner(System.in);
        validUserName = false;
        validPassword = false;
        activeUser = null;
    }

    public Session(ArrayList<Users> users) {
        // Contructor includes the check to see if a user is approved
        this.users = users;
        us = new UserSearch(users);
        currentUser = new String();
        index = 0;
        scanner = new Scanner(System.in);
        validUserName = false;
        validPassword = false;
        activeUser = null;
    }

    public void Login() {
        // trigger login process
        //this.approved();
    }

    /**
     * logs out of session
     */
    public void Logout(DataReader data, EventSystem es) throws IOException
    {
        data.save(es);
        System.out.println("I'm logging out now");
    }

    /**
     *
     * @param es
     * @throws NullPointerException
     */
    public void checkUserName(String userName) throws NullPointerException {
        //System.out.print("Enter your username: ");
        //String userName = scanner.nextLine();
        try {

            if (((this.us.findUser(userName)).getName()).equals(userName)) {

                this.currentUser = userName;
                this.validUserName = true;
            } else {
                System.out.println("Incorrect Username");
                this.validUserName = false;
            }
        } catch (NullPointerException e) {
            System.out.println("User Does Not Exist");
        }
    }

    /**
     *
     * @param es
     */
    public void checkPassword(String passwd) throws NullPointerException {
        try {
            //System.out.print("Enter your password: ");
            //String passwd = scanner.nextLine();

            if (((us.findUser(currentUser)).getPassword()).equals(passwd)) {
                this.validPassword = true;
                this.activeUser = (this.us.findUser(currentUser));
            } else {
                System.out.println("Incorrect Password");
                this.validPassword = false;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public Users getCurrentUser() {
        return this.activeUser;
    }

    public boolean approved(String userName, String passwd) {
        this.us = new UserSearch(this.users);
        this.checkUserName(userName);

        if (this.validUserName == true) {
            this.checkPassword(passwd);
        }

        if (this.validPassword == true) {

            return true;

        } else {
            return false;
        }
    }
}
