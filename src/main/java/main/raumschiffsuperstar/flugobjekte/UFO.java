package main.raumschiffsuperstar.flugobjekte;

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
        generatedCords();
    }
    
    //* Method Used in timerTick() to check if the Object Hit the Spaceship
    public boolean hit(Raumschiff aRaumschiff) {      
        Point aTempCords = new Point(aPosObjekt);
        Point aTempRaumCords = new Point(aRaumschiff.getPosObjekt());
      
        if (aTempCords.x < aTempRaumCords.x + Flugobjekt.SIZE.width &&
            aTempCords.x + Flugobjekt.SIZE.width > aTempRaumCords.x) {
      
          if (aTempCords.y < aTempRaumCords.y + Flugobjekt.SIZE.height &&
              aTempCords.y + Flugobjekt.SIZE.height > aTempRaumCords.y) {
            return true;
          }
        }
      
        return false;
    }

    //*  Generate Coordinates
    public void generatedCords() {
        aPosObjekt = new Point(random.nextInt(aGameField.getWidth()), -40);
    }

    //* Getter
    public Boolean getInGame() {return aInGame;}

    //* Setter
    public void setInGame(boolean aInGame) {this.aInGame = aInGame;}

    public abstract void updateRank();
}