package main.raumschiffsuperstar.flugobjekte;

abstract class UFO extends Flugobjekt{
    private boolean aInGame;
    protected int aSpeed;

    public Boolean checkHitShip() {
        // TODO code Check if Object hit Ship
        
        return false;
    }

    public Boolean getInGame() {return aInGame;}

    public void setInGame(boolean aInGame) {this.aInGame = aInGame;}
}