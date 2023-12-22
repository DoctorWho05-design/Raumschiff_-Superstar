package main.raumschiffsuperstar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import main.raumschiffsuperstar.Util.Debbug;
import main.raumschiffsuperstar.flugobjekte.*;

public class Controller {

    private GUI aGameGui;
    private Timer aGameTimer;
    private boolean aIsGameRunning = false;
    private final Debbug aDebbuger = new Debbug(true);
    private int aTime = 0;
    private int aRank;
    private Dimension aGameFieldSize;
    private ArrayList<UFO> aKryptonitList;
    private ArrayList<UFO> aSuperstarList;
    private Raumschiff aRaumschiff;
    private GameField aGameField;
    private Image aStartFieldImage;


    public Controller(GUI aGameGui){
        this.aGameGui = aGameGui;
        initTimer();
    }

    private void initTimer(){
        aGameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerTick();
            }
        });
    }

    private void timerTick() {        
        if ((aTime % 30) == 0) aRank++;
        aTime++;

        aGameGui.updateTimer(aTime);
        aGameGui.updateLives(aRaumschiff.getLifes());
        aGameGui.updatePoints(aRaumschiff.getPoints());
        aGameGui.updateRank(aRank);

        aGameGui.getGameField().repaint();
    }

    public void startGame() {
        this.aKryptonitList = new ArrayList<>();
        this.aSuperstarList = new ArrayList<>();
        this.aRaumschiff = new Raumschiff();
        aGameTimer.start();
        this.aIsGameRunning = true;
        aGameGui.getGameField().repaint();
    }

    public void stopGame() {
        this.aTime = 0;
        this.aRank = 0;
        this.aIsGameRunning = false;
        aGameTimer.stop();
        aGameGui.updateTimer(aTime);
        aGameGui.getGameField().repaint();

    }

    public void drawGame(Graphics g) {
        if (!aIsGameRunning) return;
        aGameField.setBackground(Color.cyan);
    }

    public void drawStartField(Graphics g){
        if (aIsGameRunning) return;
        aGameField.setBackground(Color.black);
        aGameFieldSize = aGameField.getGameFieldSize();
        ImageIcon aStartFieldIcon = new ImageIcon("./public/PressStart.gif");
        aStartFieldImage = aStartFieldIcon.getImage();
        g.drawImage(aStartFieldImage, 40, 22, aGameField);
    }

    public void startSettings() {
        System.out.println("Settings started!");
        // TODO code Settings
        
    }

    public void startHelp() {
        System.out.println("Help Menu strted!");
        // TODO code Help Frame
    }

    public boolean getIsGameRunning() {return aIsGameRunning;}

    public void setGameField(GameField aGameField) {this.aGameField = aGameField;}
}
