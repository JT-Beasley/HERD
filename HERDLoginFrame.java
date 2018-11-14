/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author jtbea
 */
public class HERDLoginFrame extends JFrame{
    
    HERDLogin login = new HERDLogin();
    
    public HERDLoginFrame()
    {
        super("Log In");
        setSize(400, 400);
        
        Container c = getContentPane();
        
        c.add(login);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
