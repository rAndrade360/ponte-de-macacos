package com.renan.version1;

import java.util.concurrent.Semaphore;

public class Bridge {
    private Semaphore semaphore;
    public static RiverMargin riverOrigin = RiverMargin.MARGIN1;
    public static int numberOfMonkeysCrossing = 0;

    public Bridge(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public synchronized void crossBridge(Monkey monkey){
        if(numberOfMonkeysCrossing == 0){
            riverOrigin = monkey.getRiverMargin();
        }
        System.out.println("Número de Macacos na ponte: " + numberOfMonkeysCrossing);
        while (monkey.getRiverMargin() != riverOrigin){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void endCrossingBridge(){
                notifyAll();
                numberOfMonkeysCrossing--;
                if(numberOfMonkeysCrossing == 0){
                    System.out.println("\tPonte vazia");
                }
    }
}
