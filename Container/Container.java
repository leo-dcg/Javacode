import java.util.LinkedList;

/*
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 使用wait和notify/notifyAll完成
 */
public class Container {
    private final int capacity;
    private final LinkedList<Object> list = new LinkedList<>();

    public Container() {
        this.capacity = 10; // 默认容量为10
    }

    public Container(int capacity) {
        this.capacity = capacity;
    }

    //向容器中添加元素
    public synchronized void put(Object obj) throws InterruptedException {
        // 当容器满时，生产者线程等待
        while (list.size() == capacity) {
            this.wait();
        }
        list.add(obj);
        // 唤醒所有等待的线程（消费者）
        this.notifyAll();
    }

    //从容器中取出元素

    public synchronized Object get() throws InterruptedException {
        // 当容器为空时，消费者线程等待
        while (list.size() == 0) {
            this.wait();
        }
        Object obj = list.removeFirst();
        // 唤醒所有等待的线程（生产者）
        this.notifyAll();
        return obj;
    }

    //获取容器中当前元素的数量

    public synchronized int getCount() {
        return list.size();
    }
}
