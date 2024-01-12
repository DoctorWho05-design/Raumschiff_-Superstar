package main.raumschiffsuperstar.Controller;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.raumschiffsuperstar.GameField;
import main.raumschiffsuperstar.flugobjekte.Raumschiff;

public class KeyController {
    private KeyListener aKeyGameControll;
    private Controller aController;

    public KeyController(Controller aController) {
        this.aController = aController;
        initKeyListener();
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
        Raumschiff aRaumschiff = aController.getRaumschiff();
        int keyCode = e.getKeyCode();
        Point aCharPos = new Point(aRaumschiff.getPosObjekt());
        int aSpeed = aRaumschiff.getSpeed();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                aCharPos.y -= aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                aCharPos.y += aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                aCharPos.x -= aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                aCharPos.x += aSpeed;
                if (checkIfWall(aCharPos)) return;
                break;
        }
        aRaumschiff.setPos(aCharPos);
        aController.checkCollision();
    }

    private Boolean checkIfWall(Point aPosObjekt) {
        GameField aGameField = aController.getGameField();
        Raumschiff aRaumschiff = aController.getRaumschiff();
        if (aPosObjekt.x < 0 ||
            aPosObjekt.x > aGameField.getWidth() - aRaumschiff.getSizeObj() ||
            aPosObjekt.y < 0 ||
            aPosObjekt.y > aGameField.getHeight() - aRaumschiff.getSizeObj()
        ) return true;
        return false;
    }

    public KeyListener getKeyListener() {return aKeyGameControll;}
}
