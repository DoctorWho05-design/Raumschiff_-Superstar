package main.raumschiffsuperstar;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class GUI extends JPanel {

    //* Parameter
    private RaumschiffSuperstar aMain;
    private Controller aGameEngine;

    //* Constructor
    public GUI(RaumschiffSuperstar aMain) {
        initComponents();
        initPanel(aMain);
    }

    //* Method Create Panel (Only used once)
    private void initPanel(RaumschiffSuperstar aMain){
        this.aMain = aMain;
        aGameEngine = new Controller(this);
        aGameField.setGameEngine(aGameEngine);
        this.setSize(aMain.getGameDim());
        this.setBackground(Color.gray);
        aGameEngine.setGameField(aGameField);
    }

    //* Methods Label Updates
    public void updateLabel(int aPoints, int aTime, int aLife, int aRank) {
        if (aGameEngine.getIsGameRunning()) {
            aPointLabel.setText("Points: " + aPoints);
            aTimeLabel.setText("Time: " + aTime);
            aLiveLabel.setText("Lives: " + aLife);
            aRankLabel.setText("Rank: " + aRank);
        } else {
            aPointLabel.setText("Points: ");
            aTimeLabel.setText("Time: ");
            aLiveLabel.setText("Lives: ");
            aRankLabel.setText("Rank: ");
        }
    }

    //* ButtonListener
    private void StartButtonActionPerformed(ActionEvent evt) {
        if (aGameEngine.getIsGameRunning()) {
            aStartButton.setText("START");
            aGameEngine.stopGame();
        } else {
            aStartButton.setText("STOP");
            aGameEngine.startGame();
        }
    }

    private void SettingsButtonActionPerformed(ActionEvent evt) {
        aGameEngine.startSettings();
    }

    private void HelpButtonActionPerformed(ActionEvent evt) {
        aGameEngine.startHelp();
    }

    //* Getter
    public GameField getGameField() {return aGameField;}


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
                StartButtonActionPerformed(evt);
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
                SettingsButtonActionPerformed(evt);
            }
        });

        aHelpButton.setText("Help");
        aHelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpButtonActionPerformed(evt);
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
