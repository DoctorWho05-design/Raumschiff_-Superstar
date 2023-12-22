package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;

public class Raumschiff extends Flugobjekt{

    private int aLifes = 3;
    private int aPoints = 0;

    public Raumschiff() {

    }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
    }

    @Override
    public void move(Point aPosEnemy) {
        // TODO Auto-generated method stub
    }
    

    public int getPoints() {return aPoints;}

    public int getLifes() {return aLifes;}
}
