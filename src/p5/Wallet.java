package p5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Wallet {

    private int countMoney = 0;
    ReentrantLock locker;
    Condition condition;

    public Wallet() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void get(){
        locker.lock();
        try{
            while (countMoney<1){
                condition.await();
            }
            countMoney--;
            System.out.println("Child get 1 money");
            System.out.println("Money in wallet: " +countMoney);
            condition.signalAll();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        finally {
            locker.unlock();
        }
    }

    public void put(){
        locker.lock();
        try{
            while (countMoney>=3){
                condition.await();
            }
            countMoney++;
            System.out.println("Parent put 1 money");
            System.out.println("Money in wallet: " +countMoney);
            condition.signalAll();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        finally {
            locker.unlock();
        }
    }
}
