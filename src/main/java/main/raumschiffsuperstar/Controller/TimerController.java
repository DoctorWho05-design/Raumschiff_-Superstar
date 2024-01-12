package main.raumschiffsuperstar.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import main.raumschiffsuperstar.flugobjekte.UFO;

class TimerController {

    //* Parameter
    private Timer aGameTimer;
    private Timer aMoveTimer;
    private Controller aController;
    private int aMoveDelay;

    //* Constructor
    public TimerController(Controller aController) {
        this.aController = aController;
        aMoveDelay = 1000;
        initGameTimer();
        initMoveTimer();
    }

    //* Timer für Bewegen der UFOs
    private void initMoveTimer() {
        aMoveTimer = new Timer(aMoveDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleMoveTimer();                
            }
        });
    }

    private void handleMoveTimer(){

    }

    //* Timer für Game zeit
    private void initGameTimer() {
        aMoveTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGameTimer();
            }
        });
    }

    private void handleGameTimer(){
        if ((aController.getTime() % 5) == 0){ 
            aMoveTimer.setDelay(aMoveTimer.getDelay() / 2);
            setMoveDelay(aMoveTimer.getDelay()/2);
        }

        aController.setTime(aController.getTime() + 1);

        aController.update();
    }

    //* Start / Stop Timer
    public void startTimer() {
        aGameTimer.start();
        aMoveTimer.start();
    }

    public void stopTimer() {
        aGameTimer.stop();
        aMoveTimer.stop();
    }

    //* Setter
    public void setMoveDelay(int aMoveDelay) {this.aMoveDelay = aMoveDelay;}



    //* Timer 1 Sec
    private void timerGameTick() {    
        
        checkCollision();
        for (UFO aSuperstar : aSuperstarList) {
            aSuperstar.move(aRaumschiff.getPosObjekt());
        }
        for (UFO aKryptonit : aKryptonitList) {
            aKryptonit.move(aRaumschiff.getPosObjekt());
        }
        aGameGui.updateLabel(aRaumschiff.getPoints(), aTime, aRaumschiff.getLifes(), aRank);
        aGameGui.getGameField().repaint();
    }

    private void timerMoveTick() {
        for (UFO aSuperstar : aSuperstarList) {
            aSuperstar.move(aRaumschiff.getPosObjekt());
        }
        for (UFO aKryptonit : aKryptonitList) {
            aKryptonit.move(aRaumschiff.getPosObjekt());
        }
        checkCollision();
        //! Die Life werden ins negative gezogen
        //if (aRaumschiff.getLifes() <= 0) stopGame();
        aGameField.repaint();
    }
}
