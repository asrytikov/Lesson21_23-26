package p1;

import java.util.concurrent.Semaphore;

public class MyThread implements Runnable{

    Res res;
    Semaphore semaphore;
    String name;

    public MyThread(Res res, Semaphore semaphore, String name) {
        this.res = res;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " wait permit");
            semaphore.acquire();
            res.x = 1;
            for(int i = 1; i<5; i++){
                System.out.println(this.name + ": " +res.x);
                res.x++;
                Thread.sleep(100);
            }
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        System.out.println(name + " free premit");
        semaphore.release();
    }
}
