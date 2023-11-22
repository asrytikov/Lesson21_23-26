package p2;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable{

    Exchanger<String> exchanger;
    String message;

    public GetThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "Java is cool!";
    }

    @Override
    public void run() {
        try{
            message = exchanger.exchange(message);
            System.out.println("GetThread: " + message);
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }
}
