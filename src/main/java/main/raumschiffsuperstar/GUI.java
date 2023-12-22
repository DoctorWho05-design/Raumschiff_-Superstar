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

    public void updatePoints(int aPoints) {
        aPointLabel.setText("Points: " + aPoints);
    }

    //! Generated Code (Do not Change)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aStartButton = new javax.swing.JButton();
        aGameField = new main.raumschiffsuperstar.GameField();
        aPointLabel = new javax.swing.JLabel();
        aTimeLabel = new javax.swing.JLabel();
        aRankLabel = new javax.swing.JLabel();
        aLiveLabel = new javax.swing.JLabel();
        aSettingsButton = new javax.swing.JButton();
        aHelpButton = new javax.swing.JButton();

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

        aPointLabel.setText("Points: ");

        aTimeLabel.setText("Time: ");

        aRankLabel.setText("Rank: ");

        aLiveLabel.setText("Lives: ");

        aSettingsButton.setText("Settings");
        aSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aSettingsButtonActionPerformed(evt);
            }
        });

        aHelpButton.setText("Help");
        aHelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aHelpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(aGameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(aStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addComponent(aPointLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aRankLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aLiveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(aSettingsButton)
                    .addComponent(aHelpButton))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aGameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aStartButton)
                        .addGap(41, 41, 41)
                        .addComponent(aTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aRankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aPointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aLiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(aSettingsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aHelpButton)
                        .addGap(16, 16, 16))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aStartButtonActionPerformed
        aGameEngine.startGame();
    }//GEN-LAST:event_aStartButtonActionPerformed

    private void aSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        aGameEngine.startSettings();
    }

    private void aHelpButtonActionPerformed(java.awt.event.ActionEvent evt) {
        aGameEngine.startHelp();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.raumschiffsuperstar.GameField aGameField;
    private javax.swing.JButton aStartButton;
    private javax.swing.JButton aSettingsButton;
    private javax.swing.JButton aHelpButton;
    private javax.swing.JLabel aPointLabel;
    private javax.swing.JLabel aTimeLabel;
    private javax.swing.JLabel aRankLabel;
    private javax.swing.JLabel aLiveLabel;
    // End of variables declaration//GEN-END:variables
}
