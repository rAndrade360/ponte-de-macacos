package com.renan.version2;


public class Monkey implements Runnable {
    private int id;
    private Bridge bridge;
    private RiverMargin riverMargin;
    private int timeSleep;


    public Monkey(int id, RiverMargin riverMargin, Bridge bridge, int timeSleep) {
        this.id = id;
        this.riverMargin = riverMargin;
        this.bridge = bridge;
        this.timeSleep = timeSleep;
    }

    @Override
    public void run() {
        while (true) {
            doAnotherThing(timeSleep);
            crossBridge(this);
            crossingReady(timeSleep);
            endCrossing();
        }
    }

    public void crossBridge(Monkey monkey) {
        bridge.crossBridge(monkey);
    }

    public void crossingReady(int timeSleep) {
        try {
            System.out.println("Macaco #"+ id +" atravessando ponte de " + this.riverMargin + " para "+ showInverseMargin(this.riverMargin));
            Bridge.numberOfMonkeysCrossing++;
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void endCrossing() {
        bridge.endCrossingBridge();
        this.setRiverMargin(this.showInverseMargin(this.riverMargin));
    }

    public void doAnotherThing(int timeSleep) {
        try {
            System.out.println("Macaco #"+ id + " fazendo macaquice na "+ riverMargin);
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public RiverMargin showInverseMargin(RiverMargin riverMargin){
        switch (riverMargin){
            case MARGIN1:
                return RiverMargin.MARGIN2;

            case MARGIN2:
                return RiverMargin.MARGIN1;

            default:
                return RiverMargin.MARGIN1;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RiverMargin getRiverMargin() {
        return riverMargin;
    }

    public void setRiverMargin(RiverMargin riverMargin) {
        this.riverMargin = riverMargin;
    }
}
