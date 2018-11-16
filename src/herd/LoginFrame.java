/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.awt.Container;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
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
        setSize(500, 500);
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        c.add(login,BorderLayout.NORTH);
        c.add(aView,BorderLayout.SOUTH);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
