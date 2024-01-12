package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;
import main.raumschiffsuperstar.GameField;

public class Raumschiff extends Flugobjekt{

    //* Parameter
    private int aLifes = 3;
    private int aPoints = 0;

    //* Constructor
    public Raumschiff() {
        super("./public/Raumschiff.png");
        
    }

    //* Method Used for Draw Spaceship on Panel
    @Override
    public void draw(Graphics g, GameField aGameField) {
        if (this.aPosObjekt == null) this.aPosObjekt = new Point(20, (aGameField.getHeight()/2) - (this.aSizeObj/2));
        g.drawImage(aStartFieldImage, aPosObjekt.x, aPosObjekt.y, SIZE.width + 20, SIZE.height + 20, aGameField);
    }

    //! Wird nicht benötigt
    @Override
    public void move(Point aPos) {}
    
    //* Getter
    public int getPoints() {return aPoints;}
    public int getLifes() {return aLifes;}

    public void addPoints() {aPoints += 10;}
}
