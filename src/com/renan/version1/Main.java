package com.renan.version1;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
	    Bridge bridge = new Bridge(new Semaphore(5));

	    int maxTime = 10000;
	    int baseTime = 1000;

	    for (int i=1; i<=10; i++){
	        RiverMargin riverMargin = RiverMargin.MARGIN1;

	        if(i % 2 == 0){
	            riverMargin = RiverMargin.MARGIN2;
            }
	        int sleep = (int) (Math.random() * maxTime) + baseTime;
	        Thread monkey = new Thread(new Monkey(i, riverMargin, bridge, sleep));
	        monkey.start();
        }
    }
}
