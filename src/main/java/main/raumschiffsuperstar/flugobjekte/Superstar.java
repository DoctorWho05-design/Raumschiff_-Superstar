package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;

import main.raumschiffsuperstar.GameField;

public class Superstar extends UFO{

    public Superstar(GameField aGameField) {
        super("./public/Superstar.png", aGameField);
        aSpeed = random.nextInt(10);
    }

    @Override
    public void draw(Graphics g, GameField aGameField) {
        g.drawImage(aStartFieldImage, this.aPosObjekt.x, aPosObjekt.y, SIZE.width, SIZE.height, aGameField);
    }

    @Override
    public void move(Point aPosEnemy) {
        aPosObjekt.y += aSpeed;
        System.out.println(aPosObjekt);
    }
    
    @Override
    public void updateRank(){
        aSpeed *= 2;
    }
}
