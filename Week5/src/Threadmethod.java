public class Threadmethod {
    public static void main(String[] args) {
    Thread t1=new MyThread1("线程1");
//    t1.setName("线程1");
    Thread t2=new MyThread1("线程2");
    t2.setName("线程2");
    t1.start();
   System.out.println(t1.getName());
    t2.start();
    System.out.println(t2.getName());
    //哪个线程调用这个代码就拿到哪个线程
    Thread m=Thread.currentThread();
    m.setName("主线程");
    System.out.println(m.getName());
    //join方法线程插队:让调用这个方法的线程先执行
        for(int i=0;i<5;i++){

            System.out.println("主线程输出："+i);
            if(i==2){
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
class MyThread1 extends Thread{
    public MyThread1(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
