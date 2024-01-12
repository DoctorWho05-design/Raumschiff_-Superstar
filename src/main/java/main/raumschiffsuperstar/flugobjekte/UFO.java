package main.raumschiffsuperstar.flugobjekte;

import java.awt.Graphics;
import java.awt.Point;

import main.raumschiffsuperstar.GameField;


public abstract class UFO extends Flugobjekt{

    //* Parameter
    private boolean aInGame;
    private GameField aGameField;

    //* Contructor
    public UFO(String aCharProfileImageSource, GameField aGameField) {
        super(aCharProfileImageSource);
        this.aGameField = aGameField;
        aSpeed = random.nextInt(5) + 1;
        generatedCords();
    }
    
    //* Method Used in timerTick() to check if the Object Hit the Spaceship
    public boolean hit(Raumschiff aRaumschiff) {  
        Point aTempCords = new Point(aPosObjekt);
        Point aTempRaumCords = new Point(aRaumschiff.getPosObjekt());

        if (aTempCords.y > aGameField.getHeight()) return true;
      
        if (aTempCords.x < aTempRaumCords.x + Flugobjekt.SIZE.width &&
            aTempCords.x + Flugobjekt.SIZE.width > aTempRaumCords.x) {
      
          if (aTempCords.y < aTempRaumCords.y + Flugobjekt.SIZE.height &&
              aTempCords.y + Flugobjekt.SIZE.height > aTempRaumCords.y) {
            return true;
          }
        }
      
        return false;
    }

    //* Bewegen der Ufos
    @Override
    public void move(Point aPosEnemy) {
        aPosObjekt.y += aSpeed;
    }

    //* Zeichnen der Ufos
    @Override
    public void draw(Graphics g, GameField aGameField) {
        g.drawImage(aStartFieldImage, this.aPosObjekt.x, aPosObjekt.y, SIZE.width, SIZE.height, aGameField);
    }

    //*  Generate Coordinates
    public void generatedCords() {
        aPosObjekt = new Point(random.nextInt(aGameField.getWidth()- aSizeObj), -40);
    }

    //* Getter
    public Boolean getInGame() {return aInGame;}

    //* Setter
    public void setInGame(boolean aInGame) {this.aInGame = aInGame;}
}