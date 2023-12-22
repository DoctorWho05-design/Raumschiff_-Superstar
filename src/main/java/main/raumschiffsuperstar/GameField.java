package main.raumschiffsuperstar;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameField extends JPanel {

    private Controller aGameEngine;

    public GameField() {
        initComponents();
        initPanel();
    }

    private void initPanel(){
        this.setBackground(Color.cyan);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGameFrame(g);
        aGameEngine.drawStartField(g);
    }

    public void setGameEngine(Controller aGameEngine) {
        this.aGameEngine = aGameEngine;
    }

    private void drawGameFrame(Graphics g) {
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
    }

    //! Generated Code (Do not Change)
    @SuppressWarnings("unchecked")
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
