// 外部类
public class Outer {
    public static String schoolName = "黑马程序员";
    public static void test(){
        System.out.println("test()");
    }
    private int age;
    public void run(){
    }
    // 成员内部类：无static修饰，属于外部类的对象持有的。
    public class Inner {
        private String name;
        // 构造器
        public Inner() {
            System.out.println("Inner() name = " + name);
        }
        // 有参数构造器
        public Inner(String name) {
            this.name = name;
            System.out.println("Inner(String name)");
        }

        public void show() {
            System.out.println("show");
            // 成员内部类中可以直接访问外部类的静态成员
            System.out.println(schoolName);
            test();
            // 也可以直接访问外部类的实例成员
            System.out.println(age);
            run();
            System.out.println(this); // 自己的对象
            System.out.println(Outer.this); // 寄生的外部类对象
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
