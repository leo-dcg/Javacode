import java.util.concurrent.*;

public class ExecutorService1 {
    public static void main(String[] args) {
        //创建线程池对象与使用
        //1.使用线程池的实现类ThreadPoolExecutor声明七个参数来创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //2.使用线程池对象执行任务，看会不会复用线程
        pool.execute(new runnable());//提交第一个任务，启动处理任务
        pool.execute(new runnable());//提交第二个任务，启动处理任务
        pool.execute(new runnable());//提交第三个任务，启动处理任务
        pool.execute(new runnable());
        pool.execute(new runnable());
        pool.execute(new runnable());
        pool.execute(new runnable());//到了队列已满，会创建新的临时线程处理任务。
        pool.execute(new runnable());//到了队列已满，会创建新的临时线程处理任务。
        pool.execute(new runnable());//到了任务拒绝策略，会抛出RejectedExecutionException异常。
        //3.关闭线程池对象,一般不关闭，因为线程池对象会一直运行，直到程序结束。
         pool.shutdown();
//        pool.shutdownNow();//不管线程是否运行结束，都会关闭线程池对象。
    }
}
class runnable implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"输出："+i);
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}