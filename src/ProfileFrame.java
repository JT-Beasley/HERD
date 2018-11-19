
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author jtbea
 */
public class ProfileFrame extends JFrame {

    ProfileView profile;
    ProfileSearchView profileSearch;
    ProfileSavedEventView profileSavedEvents;
    ProfileController controller;

    public ProfileFrame(Model aModel, LoginFrame logFrame) {
        super("HERD");

        profile = new ProfileView(aModel);
        profileSavedEvents = new ProfileSavedEventView(aModel);
        profileSearch = new ProfileSearchView(aModel);

        controller = new ProfileController(aModel, profile, profileSavedEvents, this, logFrame);

        setSize(800, 700);

        Container account = getContentPane();

        account.setLayout(new BorderLayout());
        account.add(controller, BorderLayout.NORTH);
        account.add(profile, BorderLayout.WEST);
        account.add(profileSearch, BorderLayout.EAST);
        account.add(profileSavedEvents, BorderLayout.SOUTH);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
