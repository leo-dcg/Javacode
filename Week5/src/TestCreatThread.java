import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCreatThread {
    public static void main(String[] args) {
        //目标：认识多线程，掌握创建线程的方式一：继承thread线程类
        //3.创建线程对象，调用start方法启动线程
        MyThread t = new MyThread();
        t.start();
        //如果调用run方法，则线程对象只是普通对象。
        //不要把main方法任务放到启动子线程之前。
        //方法2使用实现runnable接口
        //新建实现类对象再包装成线程对象进行启动
        MyRunnable r = new MyRunnable();
        Thread t1=new Thread(r);
        t1.start();
        //方法2使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程3输出："+i);
                }
            }
        }).start();
        //函数式简化
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("子线程4输出："+i);
//            }
//        }).start();
        //方法3使用Callable接口
        //新建实现类callable接口的对象
        Callable<Integer> c = new MyCallable(5);
        //把callable接口对象包装成一个真正的线程任务FutureTask对象
        FutureTask<Integer> ft = new FutureTask<>(c);
        new Thread(ft).start();
        try {
            //会等待子线程执行完毕
            System.out.println("子线程5结果："+ft.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出："+i);
        }

    }
}
//1.定义一个子类继承thread类，成为一个线程类
//缺点：无法继承其他父类方法
class MyThread extends Thread{
    //2.重写run方法，编写线程执行体
    @Override
    public void run() {
        System.out.println("线程启动了");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程1输出："+i);
        }
    }
}
//方法2：实现runnable接口
//优点：线程类可以继承其他类
//缺点：无法使用start方法启动线程需要多创建一个实现类对象
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("线程启动了");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程2输出："+i);
        }
    }
}
//方法3：使用Callable接口为了解决线程使其能返回结果问题
class MyCallable implements Callable<Integer>{
    private int n;
    public MyCallable(int n){
        this.n = n;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("线程启动了");
        Integer sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("子线程5输出："+i);
            sum += i;
        }
        return sum;
    }
}