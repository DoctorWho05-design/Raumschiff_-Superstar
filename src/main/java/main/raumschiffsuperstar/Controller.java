package main.raumschiffsuperstar;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import main.raumschiffsuperstar.Util.Debbug;
import main.raumschiffsuperstar.flugobjekte.*;

public class Controller {

    private GUI aGameGui;
    private Timer aGameTimer;
    private boolean aIsGameRunning = false;
    private final Debbug aDebbuger = new Debbug(true);

    private ArrayList<Kryptonit> aKryptonitList;
    private ArrayList<Superstar> aSuperstarList;
    private Raumschiff aRaumschiff;

    public Controller(GUI aGameGui){
        this.aGameGui = aGameGui;
        this.aKryptonitList = new ArrayList<>();
        this.aSuperstarList = new ArrayList<>();
        this.aRaumschiff = new Raumschiff();
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
        // TODO code Timer Tick


    }

    public void StartGame() {
        System.out.println("Start Game!");
        // TODO code Game Start
    }

    public void drawGame(Graphics g) {

    }
}
