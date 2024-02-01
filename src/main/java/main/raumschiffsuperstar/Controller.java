package main.raumschiffsuperstar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import main.raumschiffsuperstar.Util.Debbug;
import main.raumschiffsuperstar.flugobjekte.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {

    //* Parameter
    private GUI aGameGui;
    private Timer aGameTimer;
    private Timer aMoveTimer;
    private boolean aIsGameRunning = false;
    private final Debbug aDebbuger = new Debbug(false);
    private int aTime = 0;
    private int aRank;
    private ArrayList<UFO> aKryptonitList;
    private ArrayList<UFO> aSuperstarList;
    private Raumschiff aRaumschiff;
    private GameField aGameField;
    private Image aStartFieldImage;
    private KeyAdapter aKeyGameControll;
    private int aSpeedUFOs;

    //* Constructor
    public Controller(GUI aGameGui){
        this.aGameGui = aGameGui;
        initTimer();
        initKeyListener();
    }

    //* Timer 1 Sec
    private void initTimer(){
        aGameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerGameTick();
            }
        });
        aGameTimer.stop();

        aMoveTimer = new Timer(aSpeedUFOs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerMoveTick();
            }
        });
        aMoveTimer.stop();
    }

    private void timerGameTick() {    
        if ((aTime % 5) == 0){ 
            aRank++;
            if (!(aMoveTimer.getDelay() == 20)) aMoveTimer.setDelay(aMoveTimer.getDelay()-20);
        }
        aTime++;
        checkCollision();
        for (UFO aSuperstar : aSuperstarList) {
            aSuperstar.move(null);
        }
        for (UFO aKryptonit : aKryptonitList) {
            aKryptonit.move(null);
        }
        aGameGui.updateLabel(aRaumschiff.getPoints(), aTime, aRaumschiff.getLifes(), aRank);
        aGameGui.getGameField().repaint();
    }

    private void timerMoveTick() {
        for (UFO aSuperstar : aSuperstarList) {
            aSuperstar.move(null);
        }
        for (UFO aKryptonit : aKryptonitList) {
            aKryptonit.move(null);
        }
        checkCollision();
        //! Die Life werden ins negative gezogen
        if (aRaumschiff.getLifes() <= 0) stopGame();
        aGameField.repaint();

        if (aRank == 10) aMoveTimer.setDelay(10);
    }

    //* KeyListener
    private void initKeyListener() {
        aKeyGameControll = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        };
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Point aCharPos = new Point(aRaumschiff.getPosObjekt());
        int aSpeed = aRaumschiff.getSpeed();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                aDebbuger.keyPressed("Up");
                aCharPos.y -= aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                aDebbuger.keyPressed("Down");
                aCharPos.y += aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                aDebbuger.keyPressed("Left");
                aCharPos.x -= aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                aDebbuger.keyPressed("Right");
                aCharPos.x += aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;
        }
        aRaumschiff.setPos(aCharPos);
        checkCollision();
    }

    private Boolean checkIfWall(Point aPosObjekt) {
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
        aMoveTimer.setDelay(aSpeedUFOs);
        this.aKryptonitList = new ArrayList<>(10);
        this.aSuperstarList = new ArrayList<>(10);
        this.aRaumschiff = new Raumschiff();
        aGameTimer.start();
        aMoveTimer.start();
        this.aIsGameRunning = true;
        aGameGui.getGameField().repaint();
        aGameField.requestFocusInWindow();
        aGameField.addKeyListener(aKeyGameControll);

        for (int i = 0; i < 10; i++) {
            aSuperstarList.add( new Superstar(aGameField));
        }

        for (int i = 0; i < 10; i++) {
            aKryptonitList.add( new Kryptonit(aGameField));
        }
    }

    public void stopGame() {
        this.aTime = 0;
        this.aRank = 0;
        this.aIsGameRunning = false;
        aGameTimer.stop();
        aMoveTimer.stop();
        aGameGui.updateLabel(aRaumschiff.getPoints(), aTime, aRaumschiff.getLifes(), aRank);
        aGameGui.getGameField().repaint();
    }

    public void startSettings() {
        System.out.println("Settings started!");
        
        
    }

    public void startHelp() {
        System.out.println("Help Menu strted!");
        
    }

    //! Check Collision wird ab dem Nächsten Rang ausgelöst
    private void checkCollision(){
        System.out.println("Check Collsion");
        //! Hier fehler
        for (int i = 0; i < aSuperstarList.size(); i++) {
            System.out.println("Check Superstar " + i);
            
            if (aSuperstarList.get(i).getPosObjekt().y > aGameField.getHeight()) {
                removeUFO(true, i);
                return;
            }

            if (aSuperstarList.get(i).hit(aRaumschiff)) {
                System.out.println("Remove Supersar");
                removeUFO(true, i);
                aGameGui.repaint();
                aRaumschiff.addPoints();
                return;
            }
        }

        for (int i = 0; i < aKryptonitList.size(); i++) {
            if (aKryptonitList.get(i).getPosObjekt().y > aGameField.getHeight()) {
                removeUFO(false, i);
                return;
            }

            System.out.println("Check Kryptonit " + i);
            if (aKryptonitList.get(i).hit(aRaumschiff)) {
                System.out.println("Remove Kryptonit");
                removeUFO(false, i);
                aGameGui.repaint();
                aRaumschiff.removeLife();
                return;
            }
        }
        
        
    }

    private void removeUFO(boolean aIsSuperstar, int aIndex) {
        if (aIsSuperstar) {
            aSuperstarList.remove(aIndex);
            aSuperstarList.add(aIndex, new Superstar(aGameField));
        } else {
            aKryptonitList.remove(aIndex);
            aKryptonitList.add(aIndex, new Kryptonit(aGameField));
        }
    }

    

    //* Getter
    public boolean getIsGameRunning() {return aIsGameRunning;}

    //* Setter
    public void setGameField(GameField aGameField) {this.aGameField = aGameField;}
}