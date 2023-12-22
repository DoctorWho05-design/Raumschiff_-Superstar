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
    private KeyAdapter aKeyGameControll;

    public Controller(GUI aGameGui){
        this.aGameGui = aGameGui;
        initTimer();
        initKeyListener();
    }

    private void initTimer(){
        aGameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerTick();
            }
        });

        aGameTimer.stop();
    }

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
                System.out.println("Up");
                aCharPos.y -= aSpeed;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                System.out.println("Down");
                aCharPos.y += aSpeed;
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                System.out.println("Left");
                aCharPos.x -= aSpeed;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                System.out.println("Right");
                aCharPos.x += aSpeed;
                break;
        }

        checkCollision(aCharPos);
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
        aGameGui.updateTimer(aTime);
        aGameGui.getGameField().repaint();

    }

    public void drawGame(Graphics g) {
        if (!aIsGameRunning) return;
        aGameField.setBackground(Color.blue);
        aRaumschiff.draw(g, aGameField);
        for (UFO superstar : aSuperstarList) {
            superstar.draw(g, aGameField);
        }
    }

    public void drawStartField(Graphics g){
        if (aIsGameRunning) return;
        aGameField.setBackground(Color.black);
        aGameFieldSize = aGameField.getGameFieldSize();
        ImageIcon aStartFieldIcon = new ImageIcon("./public/PressStart.gif");
        aStartFieldImage = aStartFieldIcon.getImage();
        g.drawImage(aStartFieldImage, 250, 100, aGameField);
    }

    private void checkCollision(Point aPosObject){

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

    public KeyAdapter getGameKeyControlls() {return aKeyGameControll;}
}
