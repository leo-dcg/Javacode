public class TheTread {

//    Thread state 
//            
//    New 
//            
//    Ready 
//            
//    Running
//            
//    Block
//            
//    TimedWaint
//    
//            Waiting
//    
//        Termiated


    private static class T1 extends Thread {

        @Override
        public void run() {
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        //testSleep();
        //testYeild();
        testJoin();
    }

    static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A_" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void testYeild() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("-------A_" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("-------B_" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }

    static void testJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("-------A_" + i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A thread is OVER");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("BBBBBB:::" + i);

                if (i % 10 == 0) {
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
    }

}
