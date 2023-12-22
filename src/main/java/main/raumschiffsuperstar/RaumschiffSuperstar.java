package main.raumschiffsuperstar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Dimension;

public class RaumschiffSuperstar extends JFrame{

    //* Parameter
    private final String aTitle = "Raumschiff Superstar";
    private final Dimension aGameDim = new Dimension(1200, 700);
    private final GUI aGameGui = new GUI(this);
    private final ImageIcon aGameIcon = new ImageIcon("./public/GameIcon.png");

    //* Constructor
    public RaumschiffSuperstar() {
        initFrame();
    }

    //* Method Create Frame (Only used once)
    private void initFrame() {
        this.setTitle(aTitle);
        this.setIconImage(aGameIcon.getImage());
        this.setSize(aGameDim);
        this.setResizable(false);
        this.add(aGameGui);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //* Getter
    public Dimension getGameDim() {return aGameDim;}

    //! Main Method
    public static void main(String[] args) {
        new RaumschiffSuperstar();
    }
}