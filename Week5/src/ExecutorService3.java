import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService3 {
    public static void main(String[] args) {
        //通过线程池工具类Executors,调用其方法创建线程池对象
        //创建一个固定大小的线程池，大小为5
        ExecutorService es = Executors.newFixedThreadPool(5);
        //用工具类创建线程池对象，不注意可能会出现风险，比如线程池创建的线程数超过5
    }
}
