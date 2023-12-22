package main.raumschiffsuperstar.flugobjekte;

public abstract class UFO extends Flugobjekt{

    //* Parameter
    private boolean aInGame;
    protected int aSpeed;

    //* Method Used in timerTick() to check if the Object Hit the Spaceship
    public Boolean checkHitShip() {
        // TODO code Check if Object hit Ship
        return false;
    }

    //* Getter
    public Boolean getInGame() {return aInGame;}

    //* Setter
    public void setInGame(boolean aInGame) {this.aInGame = aInGame;}
}