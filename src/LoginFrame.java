import java.awt.Container;
import javax.swing.JFrame;
import java.awt.*;
/**
 *
 * @author jtbea
 */
public class LoginFrame extends JFrame{
   
    Model aModel = new Model();
    LoginView aView = new LoginView(aModel);
    LoginController login = new LoginController(aModel, aView, this);
    
    public LoginFrame()
    {
        super("Log In");
        setSize(400, 300);
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        c.add(login,BorderLayout.NORTH);
        c.add(aView,BorderLayout.SOUTH);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
