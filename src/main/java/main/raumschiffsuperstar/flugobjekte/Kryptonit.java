package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;

import main.raumschiffsuperstar.GameField;

public class Kryptonit extends UFO{

    public Kryptonit(GameField aGameField) {
        super("./public/Kryptonit.png", aGameField);
    }
    
    @Override
    public void draw(Graphics g, GameField aGameField) {
        // TODO Auto-generated method stub
    }

    @Override
    public void move(Point aPosEnemy) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void updateRank(){
        
    }
}
