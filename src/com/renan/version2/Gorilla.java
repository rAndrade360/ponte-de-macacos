package com.renan.version2;

public class Gorilla extends Monkey{
    public Gorilla(int id, RiverMargin riverMargin, Bridge bridge, int timeSleep) {
        super(id, riverMargin, bridge, timeSleep);
    }

    @Override
    public void doAnotherThing(int timeSleep) {
        try {
            System.out.println("Gorilla #"+ this.getId() + " fazendo macaquice na "+ this.getRiverMargin());
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void crossingReady(int timeSleep) {
        try {
            Bridge.isGorillaCrossing = true;
            System.out.println("Gorila #"+ this.getId() +" atravessando ponte de " + this.getRiverMargin() + " para "+ showInverseMargin(this.getRiverMargin()));
            Bridge.numberOfMonkeysCrossing++;
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crossBridge(Monkey monkey) {
        super.crossBridge(monkey);
    }

    @Override
    public void endCrossing() {
        super.endCrossing();
        Bridge.isGorillaCrossing = false;
        System.out.println("O Gorilão " + this.getId() + " atravessou!");
    }
}
