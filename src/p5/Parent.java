package p5;

public class Parent implements Runnable{
    Wallet wallet;

    public Parent(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void run() {
        for(int i=1; i<=5;i++){
            wallet.put();
        }
    }
}
