package p5;

public class Child implements Runnable{
    Wallet wallet;

    public Child(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void run() {
        for(int i=1; i<=5;i++){
            wallet.get();
        }
    }
}
