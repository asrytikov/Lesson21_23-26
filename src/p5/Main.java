package p5;

public class Main {

    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        Parent parent = new Parent(wallet);
        Child child = new Child(wallet);
        new Thread(parent).start();
        new Thread(child).start();
    }
}
