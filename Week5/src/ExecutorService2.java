import java.util.concurrent.*;

public class ExecutorService2 {
    public static void main(String[] args) {
        //创建线程池对象与使用
        //1.使用线程池的实现类ThreadPoolExecutor声明七个参数来创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //2.使用线程池处理callable任务
            Future<String> task1 = pool.submit(new Callable1(100));
            Future<String> task2 = pool.submit(new Callable1(200));
            Future<String> task3 = pool.submit(new Callable1(300));
            Future<String> task4 = pool.submit(new Callable1(400));
           try {
               System.out.println(task1.get());
               System.out.println(task2.get());
               System.out.println(task3.get());
               System.out.println(task4.get());
           }catch (Exception e) {
                e.printStackTrace();
           }
    }
}
class Callable1 implements Callable<String>{
    private int n;
    public Callable1(int n){
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName()+n+"的和是"+sum;
    }
}
