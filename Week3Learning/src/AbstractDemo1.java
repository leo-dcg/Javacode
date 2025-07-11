public class AbstractDemo1 {
    public static void main(String[] args) {
        // 目标：认识抽象类，抽象方法，搞清楚他们的特点。
        // 抽象类的核心特点：有得有失（得到了抽象方法的能力，失去了创建对象的能力）
        // 抽象类不能创建对象（重点）。
        // A1 a = new A1();  // 报错了
        // 抽象类的使命就是被子类继承
        B1 b = new B1();
        b.setName("张三");
        b.setAge(18);
        System.out.println(b.getName() + "---" + b.getAge());
        b.show();
        b.show1();
    }
}



