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
public class ProfileFrame extends JFrame{
    
    ProfileView aView ;
    ProfileEventView allEvents;
    ProfileSearchView aView2;
    ProfileSavedEventView savedEvents;
    ProfileController controller;
 
    public ProfileFrame(Model aModel, LoginFrame logFrame)
    {
        super("HERD");
        
        aView = new ProfileView(aModel);
        allEvents = new ProfileEventView(aModel);
        savedEvents = new ProfileSavedEventView(aModel);
        aView2 = new ProfileSearchView(aModel);
        
        controller = new ProfileController(aView, this, logFrame);

        
        setSize(800,700);
        
        Container account = getContentPane();
        
        account.setLayout(new BorderLayout());
        account.add(controller, BorderLayout.PAGE_START);
        account.add(aView,BorderLayout.WEST);
//        account.add(allEvents,BorderLayout.EAST);
        account.add(aView2, BorderLayout.EAST);
        account.add(savedEvents,BorderLayout.SOUTH);

        
      
        
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    
    
}
