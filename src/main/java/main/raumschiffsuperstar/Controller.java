package main.raumschiffsuperstar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import main.raumschiffsuperstar.Util.Debbug;

public class Controller {

    private GUI aGameGui;
    private Timer aGameTimer;
    private boolean aIsGameRunning = false;
    private final Debbug aDebbuger = new Debbug(true);

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
        // TODO code Timer Tick
    }

    public void StartGame() {
        // TODO code Game Start
    }
}
