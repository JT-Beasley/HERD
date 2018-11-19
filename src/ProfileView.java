import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Emily
 */
public class ProfileView extends javax.swing.JPanel {

    private final Model aModel;
    private final ArrayList<Events> recommended;

    /**
     * 
     * @param Model 
     */
    public ProfileView(Model Model) {
        initComponents();
        aModel = Model;
        recommended = aModel.getRecommended();
    }

    @SuppressWarnings("unchecked")

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        jTextArea1.setText("");
        jTextArea1.setText("Recommended Events: \n \n \n");

       for (Events event : recommended) {
            String eventName = event.getTitle() + "\n";
            jTextArea1.append(eventName);
            String eventDescription = "    " + event.getDescription() + "\n";
            jTextArea1.append(eventDescription);
            String eventHashID = "    " + Integer.toString(event.getHashID()) + "\n \n";
            jTextArea1.append(eventHashID);
        }

        // Sets view to beginning of text
        jTextArea1.setCaretPosition(0);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 120, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
