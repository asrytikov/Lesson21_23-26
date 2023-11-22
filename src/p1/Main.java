package p1;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Res res = new Res();
        new Thread(new MyThread(res, semaphore, "MyThread 1")).start();
        new Thread(new MyThread(res, semaphore, "MyThread 2")).start();
        new Thread(new MyThread(res, semaphore, "MyThread 3")).start();
    }
}