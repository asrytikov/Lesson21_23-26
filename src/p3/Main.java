package p3;

import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseTherad 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " is end");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " is end");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " is end");

        phaser.arriveAndDeregister();
    }
}
