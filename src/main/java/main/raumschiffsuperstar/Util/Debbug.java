package main.raumschiffsuperstar.Util;

import java.util.HashMap;

public class Debbug {
    private boolean aDebugMode;
    private HashMap<String , Boolean> aCheckMap = new HashMap<>();

    public Debbug(boolean aDebugMode){
        this.aDebugMode = aDebugMode;
    }

    public void setaDebugMode(boolean aDebugMode) {
        this.aDebugMode = aDebugMode;
    }
    
    public void isMethodStarted(String aMethodName) {
        aCheckMap.put(aMethodName, false);
    }

    public void isMethodFinished(String aMethodName) {
        aCheckMap.put(aMethodName, true);
    }

    private void printTrenner() {
        System.out.println("###########################");
    }
    public void printMap(){
        printTrenner();
        System.out.println(aCheckMap);
        printTrenner();
        System.out.println();
    }
}
