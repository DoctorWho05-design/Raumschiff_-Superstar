package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;

import main.raumschiffsuperstar.GameField;

public class Superstar extends UFO{

    public Superstar() {
        super("./public/Superstar.png");
        this.aPosObjekt = null;
        System.out.println(aPosObjekt);
    }

    @Override
    public void draw(Graphics g, GameField aGameField) {
        
        if (this.aPosObjekt == null) {this.aPosObjekt = new Point(random.nextInt(aGameField.getWidth()), random.nextInt(aGameField.getHeight()));
        System.out.println(aPosObjekt);}
        g.drawImage(aStartFieldImage, aPosObjekt.x, aPosObjekt.y, SIZE.width, SIZE.height, aGameField);
    }

    @Override
    public void move(Point aPosEnemy) {
        // TODO Auto-generated method stub
    }
    
}
