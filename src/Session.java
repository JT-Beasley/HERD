
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
    private boolean validUserName;
    private boolean validPassword;
    private Users activeUser;

    /**
     * checks login info for users
     */
    public Session() {
        us = new UserSearch();
        currentUser = new String();
        validUserName = false;
        validPassword = false;
        activeUser = null;
    }

    /**
     *
     * @param inputUsers
     */
    public Session(ArrayList<Users> inputUsers) {
        users = inputUsers;
        us = new UserSearch(users);
        currentUser = new String();
        validUserName = false;
        validPassword = false;
        activeUser = null;
    }

    /**
     *
     * @param userName
     * @throws NullPointerException
     */
    public void checkUserName(String userName) throws NullPointerException {
        try {
            if (((us.findUser(userName)).getName()).equals(userName)) {
                currentUser = userName;
                validUserName = true;
            } else {
                System.out.println("Incorrect Username");
                validUserName = false;
            }
        } catch (NullPointerException e) {
            System.out.println("User Does Not Exist");
        }
    }

    /**
     *
     * @param passwd
     * @throws NullPointerException
     */
    public void checkPassword(String passwd) throws NullPointerException {
        try {
            if (((us.findUser(currentUser)).getPassword()).equals(passwd)) {
                validPassword = true;
                activeUser = (us.findUser(currentUser));
            } else {
                System.out.println("Incorrect Password");
                validPassword = false;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public Users getCurrentUser() {
        return activeUser;
    }

    /**
     *
     * @param userName
     * @param passwd
     * @return
     */
    public boolean approved(String userName, String passwd) {
        checkUserName(userName);

        if (validUserName == true) {
            checkPassword(passwd);
        }

        if (validPassword != true) {
            return false;
        } else {
            return true;
        }
    }
}
