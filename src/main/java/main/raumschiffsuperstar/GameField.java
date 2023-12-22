package main.raumschiffsuperstar;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameField extends JPanel {

    //* Parameter
    private Controller aGameEngine;
    private Dimension aGameFieldSize;
    

    //* Constructor
    public GameField() {
        initComponents();
        this.setFocusable(true);
    }

    //* Method Create Panel (Only used once)
    public void initPanel(){
        aGameFieldSize = new Dimension(this.getWidth(), this.getHeight());
        this.addKeyListener(aGameEngine.getGameKeyControlls());
        //System.out.println(aGameFieldSize);
    }

    //* Panel Draw Methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGameFrame(g);
        aGameEngine.drawStartField(g);
        aGameEngine.drawGame(g);
    }

    private void drawGameFrame(Graphics g) {
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
    }

    //* Setter
    public void setGameEngine(Controller aGameEngine) {this.aGameEngine = aGameEngine;}

    //* Getter
    public Dimension getGameFieldSize() {return aGameFieldSize;}

    //! Generated Code (Do not Change)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
