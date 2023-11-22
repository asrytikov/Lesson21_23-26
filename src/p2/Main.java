package p2;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new PutExchange(exchanger)).start();
        new Thread(new GetThread(exchanger)).start();
    }
}
