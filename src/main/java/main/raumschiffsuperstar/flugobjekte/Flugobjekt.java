package main.raumschiffsuperstar.flugobjekte;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

abstract class Flugobjekt {
    //* Parameter
    protected Point aPosObjekt;
    protected Dimension aSizeObj;

    //* Constructor
    public Flugobjekt() {}
    
    //* Abstract Methods 
    public abstract void draw(Graphics g);
    public abstract void move(Point aPosEnemy);

    //* Getter
    public Point getPosObjekt() {return aPosObjekt;}
    public Dimension getSizeObj() {return aSizeObj;}
}