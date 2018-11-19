import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Emily
 */
public class CreateFrame extends JFrame {

    Model aModel;
    CreateController cController;

    public CreateFrame(Model Model, ProfileFrame proFrame) {
        super("Create an Event");

        aModel = Model;
        cController = new CreateController(aModel, this, proFrame);

        setSize(400, 400);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(cController, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
