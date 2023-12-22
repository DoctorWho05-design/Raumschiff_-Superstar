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
        aGameField.setGameEngine(aGameEngine);
        this.setSize(aMain.getGameDim());
        this.setBackground(Color.gray);
    }

    public GameField getGameField() {return aGameField;}

    //! Generated Code (Do not Change)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aStartButton = new javax.swing.JButton();
        aGameField = new main.raumschiffsuperstar.GameField();
        jLabel1 = new javax.swing.JLabel();

        aStartButton.setText("START");
        aStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aStartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aGameFieldLayout = new javax.swing.GroupLayout(aGameField);
        aGameField.setLayout(aGameFieldLayout);
        aGameFieldLayout.setHorizontalGroup(
            aGameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        aGameFieldLayout.setVerticalGroup(
            aGameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(aGameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aGameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aStartButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 605, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aStartButtonActionPerformed
        aGameEngine.StartGame();
    }//GEN-LAST:event_aStartButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.raumschiffsuperstar.GameField aGameField;
    private javax.swing.JButton aStartButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
