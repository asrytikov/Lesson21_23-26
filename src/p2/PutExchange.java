package p2;

import java.util.concurrent.Exchanger;

public class PutExchange implements Runnable{

    Exchanger<String> exchanger;
    String message;

    public PutExchange(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "Hello all";
    }

    @Override
    public void run() {
        try{
            message = exchanger.exchange(message);
            System.out.println("PutThread: " + message);
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }
}
