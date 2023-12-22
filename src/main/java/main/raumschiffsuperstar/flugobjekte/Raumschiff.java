package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;

public class Raumschiff extends Flugobjekt{

    //* Parameter
    private int aLifes = 3;
    private int aPoints = 0;

    //* Constructor
    public Raumschiff() {

    }

    //* Method Used for Draw Spaceship on Panel
    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
    }

    //! Wird nicht benötigt
    @Override
    public void move(Point aPosEnemy) {}
    
    //* Getter
    public int getPoints() {return aPoints;}
    public int getLifes() {return aLifes;}
}
