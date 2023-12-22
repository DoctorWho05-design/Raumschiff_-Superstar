package main.raumschiffsuperstar;

import javax.swing.JFrame;
import java.awt.Dimension;

public class RaumschiffSuperstar extends JFrame{

    private final String aTitle = "Raumschiff Superstar";
    private final Dimension aGameDim = new Dimension(1200, 700);
    private final GUI aGameGui = new GUI(this);

    public RaumschiffSuperstar() {
        initFrame();
    }

    private void initFrame() {
        this.setTitle(aTitle);
        this.setSize(aGameDim);
        this.setResizable(false);
        this.add(aGameGui);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Dimension getGameDim() {
        return aGameDim;
    }

    public static void main(String[] args) {
        new RaumschiffSuperstar();
    }
}