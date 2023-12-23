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
        if (!aDebugMode) return;
        aCheckMap.put(aMethodName, false);
    }

    public void isMethodFinished(String aMethodName) {
        if (!aDebugMode) return;
        aCheckMap.put(aMethodName, true);
    }

    private void printTrenner() {
        System.out.println("###########################");
    }
    public void printMap(){
        if (!aDebugMode) return;
        printTrenner();
        System.out.println(aCheckMap);
        printTrenner();
        System.out.println();
    }

    public void keyPressed(String aKey) {
        if (!aDebugMode) return;
        System.out.println(aKey + " Pressed");
    }
}
