/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Emily
 */
public class ProfileView extends javax.swing.JPanel {

    Model aModel;

/**
 * 
 * @param aModel 
 */
    public ProfileView(Model aModel) {
        initComponents();
        this.aModel = aModel;
    }

    @SuppressWarnings("unchecked")

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.red);

        String title1 = "H.E.R.D";
        g.drawString(title1, 40, 70);

        String title2 = "Huntsville Event Recommedation Database";
        g.drawString(title2, 40, 90);

        String title3 = "Your recommends events are";
        g.drawString(title3, 40, 110);

        ArrayList<Events> recommended = aModel.getRecommended();

        int position = 140;
        int offset = 0;
        for (Events event : recommended) {
            String eventName = event.getTitle();
            g.drawString(eventName, 40, position + offset * 15);
            offset++;
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
