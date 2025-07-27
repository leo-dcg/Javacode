import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadScurity {
    public static void main(String[] args) {
        Account account=new Account(1000);
        //创建两个线程模拟同时向一个账户取钱
        new DrawMoney("丽丽",account).start();
        new DrawMoney("小明",account).start();

    }


}
@Data
@NoArgsConstructor
class Account{
    public Account(double money) {
        Money = money;
    }
    private double Money;
    private final Lock lk=new ReentrantLock();//创建一个锁对象用final保护锁
    //同时访问同一个账户的时候，会出现线程安全问题
//    lk.lock();
    public void drawMoney(double money){
        //拿到当前线程
       String name=Thread.currentThread().getName();
       //锁对象，用共享资源作为锁对象
        //对于实例对象，锁对象是this，对于静态对象，锁对象是类名.class
        try {
            synchronized (this) {
                if(Money>=money){
                    System.out.println(name+"取钱成功，取钱金额："+money);
                    Money-=money;
                    System.out.println("余额："+Money);
                }else{
                    System.out.println(name+"取钱失败，余额不足");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
//        } finally {
//            lk.unlock();锁释放操作放到finally里面，避免出现异常锁不释放
}
//        }
    }
    //所以要用synchronized修饰方法，意思是线程同步方法，他默认锁this对象，静态方法锁是类名.class
    //public synchronized void drawMoney(double money){}
}
class DrawMoney extends Thread{
    private Account account;
    public DrawMoney(String name,Account account){
        super(name);
        this.account=account;
    }
    @Override
    public void run(){
        account.drawMoney(1000);
    }

}