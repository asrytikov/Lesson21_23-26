package p4;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Res res = new Res();
        ReentrantLock locker = new ReentrantLock();
        for(int i=1; i<6; i++){
            Thread thread =  new Thread(new ResThread(res, locker));
            thread.setName("Thread "+i);
            thread.start();
        }
    }
}
