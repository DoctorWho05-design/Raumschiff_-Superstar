package main.raumschiffsuperstar;

import java.awt.Color;
import javax.swing.JPanel;

public class GUI extends JPanel {

    private RaumschiffSuperstar aMain;
    private Controller aGameEngine;

    public GUI(RaumschiffSuperstar aMain) {
        this.aMain = aMain;

        aGameEngine = new Controller(this);

        initComponents();
        initPanel();
    }

    private void initPanel(){
        this.setSize(aMain.getGameDim());
        this.setBackground(Color.gray);
        aGameField.setBackground(Color.cyan);
    }


    //! Generated Code (Do not Change)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aGameField = new javax.swing.JPanel();
        aStartButton = new javax.swing.JButton();

        javax.swing.GroupLayout aGameFieldLayout = new javax.swing.GroupLayout(aGameField);
        aGameField.setLayout(aGameFieldLayout);
        aGameFieldLayout.setHorizontalGroup(
            aGameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1053, Short.MAX_VALUE)
        );
        aGameFieldLayout.setVerticalGroup(
            aGameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        aStartButton.setText("START");
        aStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aStartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aGameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(aStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(aStartButton)
                .addContainerGap(661, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aGameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aStartButtonActionPerformed
        aGameEngine.StartGame();
    }//GEN-LAST:event_aStartButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aGameField;
    private javax.swing.JButton aStartButton;
    // End of variables declaration//GEN-END:variables
}
