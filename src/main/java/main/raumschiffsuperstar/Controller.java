package main.raumschiffsuperstar;

import java.awt.Color;
import java.awt.Dimension;
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
                timerTick();
            }
        });

        aGameTimer.stop();
    }

    private void timerTick() {        
        if ((aTime % 30) == 0) aRank++;
        aTime++;
        checkCollision();
        aGameGui.updateLabel(aRaumschiff.getPoints(), aTime, aRaumschiff.getLifes(), aRank);
        aGameGui.getGameField().repaint();
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
        Point aCharPos = aRaumschiff.getPosObjekt();
        int aSpeed = aRaumschiff.getSpeed();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                aDebbuger.keyPressed("Up");
                aCharPos.y -= aSpeed;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                aDebbuger.keyPressed("Down");
                aCharPos.y += aSpeed;
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                aDebbuger.keyPressed("Left");
                aCharPos.x -= aSpeed;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                aDebbuger.keyPressed("Right");
                aCharPos.x += aSpeed;
                break;
        }

        checkCollision();
    }

    //* Draw GameField (Checks Current State)
    public void drawGame(Graphics g) {
        if (!aIsGameRunning) return;
        aGameField.setBackground(Color.cyan);
        for (UFO superstar : aSuperstarList) {
            superstar.draw(g, aGameField);
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
        this.aKryptonitList = new ArrayList<>(10);
        this.aSuperstarList = new ArrayList<>(10);
        this.aRaumschiff = new Raumschiff();
        aGameTimer.start();
        this.aIsGameRunning = true;
        aGameGui.getGameField().repaint();
        aGameField.requestFocusInWindow();
        aGameField.addKeyListener(aKeyGameControll);

        for (int i = 0; i < 10; i++) {
            aSuperstarList.add( new Superstar());
        }
    }

    public void stopGame() {
        this.aTime = 0;
        this.aRank = 0;
        this.aIsGameRunning = false;
        aGameTimer.stop();
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

    private void checkCollision(){
        for (UFO aSuperstar : aSuperstarList) {
            Point aCords = new Point(aSuperstar.getPosObjekt());
            if (hit(aCords)) {
                aRaumschiff.addPoints();
                aSuperstar = new Superstar();
                aGameGui.repaint();
                System.out.println(aSuperstar);
            }
        }
    }

    private boolean hit(Point aCords) {
        if (aCords == null) return false;
      
        Point aTempCords = new Point(aCords);
        Point aTempRaumCords = new Point(aRaumschiff.getPosObjekt());
      
        if (aTempCords.x < aTempRaumCords.x + Flugobjekt.SIZE.width &&
            aTempCords.x + Flugobjekt.SIZE.width > aTempRaumCords.x) {
      
          if (aTempCords.y < aTempRaumCords.y + Flugobjekt.SIZE.height &&
              aTempCords.y + Flugobjekt.SIZE.height > aTempRaumCords.y) {
            return true;
          }
        }
      
        return false;
      }

    //* Getter
    public boolean getIsGameRunning() {return aIsGameRunning;}

    //* Setter
    public void setGameField(GameField aGameField) {this.aGameField = aGameField;}
}
