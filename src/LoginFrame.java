import java.awt.Container;
import javax.swing.JFrame;
import java.awt.*;
/**
 *
 * @author jtbea
 */
public class LoginFrame extends JFrame{
   
    Model aModel = new Model();
    LoginController login = new LoginController(aModel, this);
    
    public LoginFrame()
    {
        super("Log In");
        setSize(400, 200);
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        c.add(login,BorderLayout.NORTH);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
