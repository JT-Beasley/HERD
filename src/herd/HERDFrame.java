/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 *
 * @author jtbea
 */
public class HERDFrame extends JFrame{
    
    HERDController controller = new HERDController();
    HERDLogin start = new HERDLogin();
    JButton logout = new JButton("Log Out");
    
    
    
    public HERDFrame()
    {
        super("HERD");
        setSize(700,700);
        
        
        
        
        
        Container account = getContentPane();
        
        account.setLayout(new BorderLayout());
        account.add(controller, BorderLayout.NORTH);
        
        
        
        
        
        
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    
    
}
