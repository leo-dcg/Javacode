import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;

public class ThredTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //红包雨游戏：100个员工
        //一共发出200个红包其中小红包金额在[1-30]元之间占比百分之80，大红包金额在[31-100]元之间占比百分之20
        //统计：员工抢到红包的总金额
        //分析：100个员工就是100个线程，来竞争200个红包，用callable接口返回每次抢到的红包金额，再定义一个list集合保存每个员工抢到的红包金额
        List<Integer> list = getRedPackets();

        //2.定义线程类创建100个线程
        List<FutureTask<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Callable<Integer> c = new RedPacketThread(list, "员工" + i);
            FutureTask<Integer> ft = new FutureTask<>(c);
            tasks.add(ft);
            new Thread(ft).start();
        }
        
        // 收集结果
        int total = 0;
        for (int i = 0; i < tasks.size(); i++) {
            FutureTask<Integer> task = tasks.get(i);
            int amount = task.get();
            System.out.println("员工" + i + "抢到：" + amount + "元");
            total += amount;
        }
        
        System.out.println("总共发出红包金额：" + total + "元");
    }
    
    //1.准备200个红包，放到list集合中返回
    public static List<Integer> getRedPackets(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            if (i < 160) {
                list.add((int)(Math.random() * 30 + 1));
            } else {
                list.add((int)(Math.random() * 70 + 31)); // 修正为31-100元
            }
        }
        return list;
    }
}

class RedPacketThread implements Callable<Integer> {
    private List<Integer> list;
    private String name;
    
    public RedPacketThread(List<Integer> list, String name) {
        this.list = list;
        this.name = name;
    }
    
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        // 每个线程循环抢红包，直到红包被抢完
        while (true) {
            Integer money = null;
            // 只在需要访问共享资源时才同步
            synchronized (list) {
                // 如果红包抢完了，退出循环
                if (list.size() <= 0) {
                    break;
                }
                // 抢到一个红包
                money = list.remove(0);
            }
            
            // 在同步块外处理抢到的红包
            sum += money;
            System.out.println(name + "抢到：" + money + "元");
            
            // 模拟抢红包的时间间隔
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new Exception();
            }
        }

        return sum;
    }
}