package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import main.raumschiffsuperstar.GameField;

public class Superstar extends UFO{

    public Superstar() {
        super("./public/Superstar.png");
    }
    @Override
    public void draw(Graphics g, GameField aGameField) {
        Random random = new Random();
        if (this.aPosObjekt == null) this.aPosObjekt = new Point(random.nextInt(aGameField.getWidth()), random.nextInt(aGameField.getHeight()));
        g.drawImage(aStartFieldImage, aPosObjekt.x, aPosObjekt.y, aGameField);
    }

    @Override
    public void move(Point aPosEnemy) {
        // TODO Auto-generated method stub
    }
    
}
