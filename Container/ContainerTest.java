public class ContainerTest {
    public static void main(String[] args) {
        // 创建容量为5的容器（便于观察阻塞效果）
        Container container = new Container(5);

        // 创建2个生产者线程
        for (int i = 0; i < 2; i++) {
            final int producerId = i;
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        String product = "Product-" + producerId + "-" + j;
                        container.put(product);
                        System.out.println("Producer " + producerId + " produced: " + product
                                + " (count: " + container.getCount() + ")");
                        Thread.sleep(100); // 模拟生产时间
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Producer-" + i).start();
        }

        // 创建10个消费者线程
        for (int i = 0; i < 10; i++) {
            final int consumerId = i;
            new Thread(() -> {
                try {
                    for (int j = 0; j < 2; j++) {
                        Thread.sleep(200); // 模拟消费间隔
                        Object product = container.get();
                        System.out.println("Consumer " + consumerId + " consumed: " + product
                                + " (count: " + container.getCount() + ")");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Consumer-" + i).start();
        }
    }
}
