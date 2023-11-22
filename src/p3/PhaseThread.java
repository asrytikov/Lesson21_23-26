package p3;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable{

    Phaser phaser;
    String name;

    public PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println(name + " run phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try{
            Thread.sleep(200);
        }catch (InterruptedException exception){}

        System.out.println(name + " run phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try{
            Thread.sleep(200);
        }catch (InterruptedException exception){}

        System.out.println(name + " run phase " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}
