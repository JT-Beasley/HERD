/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jeren
 */
public class ProfileEventView extends javax.swing.JPanel {
    Model aModel;
    /**
     * 
     * @param aModel 
     */
    public ProfileEventView(Model aModel) {
        initComponents();
        this.aModel = aModel;
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        
    }
    @SuppressWarnings("unchecked")
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        String astring = "aaaasdasdasdalsdjalsdkjaslkdjlaaaa";
//        jTextArea1.insert(astring,0);
        jTextArea1.setText(astring);
        setBackground(Color.white);
        
        ArrayList<Events> allEvents = aModel.getAllEvents();

        int position1 = 140;
        int position2 = 150;
        int offset = 0;
        for (Events event : allEvents)
        {
            String eventName = event.getTitle();
            String eventDescription = event.getDescription();
            g.drawString(eventName, 40, position1+offset*20);
            g.drawString(eventDescription, 45, position2+offset*20);
            offset++;
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
