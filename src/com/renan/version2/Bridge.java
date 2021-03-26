package com.renan.version2;

import java.util.concurrent.Semaphore;

public class Bridge {
    private Semaphore semaphore;
    public static RiverMargin riverOrigin = RiverMargin.MARGIN1;
    public static int numberOfMonkeysCrossing = 0;
    public static boolean isGorillaCrossing = false;

    public Bridge(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public synchronized void crossBridge(Monkey monkey){
        if(numberOfMonkeysCrossing == 0){
            System.out.println("\t\tPonte vazia");
            riverOrigin = monkey.getRiverMargin();

        }

        System.out.println("\tNúmero de Macacos na ponte: " + numberOfMonkeysCrossing);
        while (monkey.getRiverMargin() != riverOrigin || isGorillaCrossing || (monkey.getClass().getSimpleName().equals("Gorilla") && numberOfMonkeysCrossing > 0)){
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
    }
}
