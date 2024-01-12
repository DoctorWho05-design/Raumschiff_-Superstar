package main.raumschiffsuperstar.flugobjekte;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;
import main.raumschiffsuperstar.GameField;

public abstract class Flugobjekt {
    //* Parameter
    protected Point aPosObjekt;
    protected final int aSizeObj = 80;
    protected Image aStartFieldImage;
    protected int aSpeed;
    protected Random random = new Random();
    public static final Dimension SIZE = new Dimension(50,50);

    //* Constructor
    public Flugobjekt(String aCharProfileImageSource) {
        ImageIcon aTempIcon = new ImageIcon(aCharProfileImageSource);
        Image aTempImage = aTempIcon.getImage();
        aStartFieldImage = aTempImage.getScaledInstance(aSizeObj, aSizeObj, Image.SCALE_SMOOTH);
    }
    
    //* Abstract Methods 
    public abstract void draw(Graphics g , GameField aGameField);
    public abstract void move(Point aPosEnemy);

    //* Getter
    public Point getPosObjekt() {return aPosObjekt;}
    public int getSizeObj() {return aSizeObj;}
    public int getSpeed() {return aSpeed;}
}