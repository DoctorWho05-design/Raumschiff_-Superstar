package main.raumschiffsuperstar.Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import main.raumschiffsuperstar.GUI;
import main.raumschiffsuperstar.GameField;
import main.raumschiffsuperstar.Util.Debbug;
import main.raumschiffsuperstar.flugobjekte.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {

    //* Parameter
    private TimerController aTimerController;
    private KeyController aKeyController;

    private boolean aIsGameRunning = false;
    private int aTime;
    private int aRank;
    private int aSpeedUFOs;

    private ArrayList<UFO> aKryptonitList;
    private ArrayList<UFO> aSuperstarList;

    private Raumschiff aRaumschiff;
    private GameField aGameField;
    private Image aStartFieldImage;
    private GUI aGameGui;
    
    //* Constructor
    public Controller(GUI aGameGui){
        this.aGameGui = aGameGui;
        aTimerController = new TimerController(this);
        aKeyController = new KeyController(this);
    }

    public void update() {

        aGameField.repaint();
    }
    


    public Boolean checkIfWall(Point aPosObjekt) {
        if (aPosObjekt.x < 0 ||
            aPosObjekt.x > aGameField.getWidth() - aRaumschiff.getSizeObj() ||
            aPosObjekt.y < 0 ||
            aPosObjekt.y > aGameField.getHeight() - aRaumschiff.getSizeObj()
        ) return true;
        return false;
    }

    //* Draw GameField (Checks Current State)
    public void drawGame(Graphics g) {
        if (!aIsGameRunning) return;
        aGameField.setBackground(Color.cyan);
        for (UFO superstar : aSuperstarList) {
            superstar.draw(g, aGameField);
        }
        for (UFO aKryptonit : aKryptonitList) {
            aKryptonit.draw(g, aGameField);
        }
        aRaumschiff.draw(g, aGameField);
    }

    public void drawStartField(Graphics g){
        if (aIsGameRunning) return;
        aGameField.setBackground(Color.black);
        ImageIcon aStartFieldIcon = new ImageIcon("./public/PressStart.gif");
        aStartFieldImage = aStartFieldIcon.getImage();
        g.drawImage(aStartFieldImage, 250, 100, aGameField);
    }

    


    //* Button Handler
    public void startGame() {
        aSpeedUFOs = 100;
        aIsGameRunning = true;

        aKryptonitList = new ArrayList<>(10);
        aSuperstarList = new ArrayList<>(10);
        aRaumschiff = new Raumschiff();

        aTimerController.setMoveDelay(aSpeedUFOs);
        aTimerController.startTimer();

        aGameGui.getGameField().repaint();
        aGameField.requestFocusInWindow();

        aGameField.addKeyListener(aKeyController.getKeyListener());

        for (int i = 0; i < 10; i++) {
            aSuperstarList.add( new Superstar(aGameField));
            aKryptonitList.add( new Kryptonit(aGameField));
        }
    }

    public void stopGame() {
        aTime = 0;
        aRank = 0;
        aIsGameRunning = false;

        aTimerController.stopTimer();

        aGameGui.updateLabel(aRaumschiff.getPoints(), aTime, aRaumschiff.getLifes(), aRank);
        aGameGui.getGameField().repaint();
    }

    public void startSettings() {
        System.out.println("Settings started!");
        // TODO code Settings
        
    }

    public void startHelp() {
        System.out.println("Help Menu strted!");
        // TODO code Help Frame
    }

    //! Check Collision wird ab dem Nächsten Rang ausgelöst
    public void checkCollision(){
        for (int i = 0; i < aSuperstarList.size(); i++) {
            if (aSuperstarList.get(i).hit(aRaumschiff)) {
                removeUFO(true, i);
                aGameGui.repaint();
                return;
            }
        }

        for (int i = 0; i < aKryptonitList.size(); i++) {
            if (aKryptonitList.get(i).hit(aRaumschiff)) {
                removeUFO(false, i);
                aGameGui.repaint();
                return;
            }
        }
    }

    private void removeUFO(boolean aIsSuperstar, int aIndex) {
        
        if (aIsSuperstar) {
            aRaumschiff.addPoints();
            aSuperstarList.remove(aIndex);
            aSuperstarList.add(aIndex, new Superstar(aGameField));
        } else {
            aRaumschiff.removeLife();
            aKryptonitList.remove(aIndex);
            aKryptonitList.add(aIndex, new Kryptonit(aGameField));
        }
    }

    

    //* Getter
    public boolean getIsGameRunning() {return aIsGameRunning;}
    public Raumschiff getRaumschiff() {return aRaumschiff;}
    public GameField getGameField() {return aGameField;}
    public int getTime() {return aTime;}

    //* Setter
    public void setGameField(GameField aGameField) {this.aGameField = aGameField;}
    public void setRank(int aRank) {this.aRank = aRank;}
    public void setTime(int aTime) {this.aTime = aTime;}
}
