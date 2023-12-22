package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Flugobjekt {
    protected Point aPosObjekt;

    public Flugobjekt(){

    }
    
    public abstract void draw(Graphics g);

    public abstract void move(Point aPosEnemy);

    public Point getPosObjekt() {return aPosObjekt;}
}
