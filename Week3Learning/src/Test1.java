public class Test1 {
    //成员变量分为实例变量和静态变量
    //静态变量有static修饰，它从该类的准备阶段就存在了，直到系统销毁这个类，静态变量的作用域与这个类的生存范围相同；
    static int age;
    public static void main(String[] args)
    {
        //调用有参数构造器创建对象
        Student s1 = new Student("张三", 18);
        //调用无参数构造器创建对象
        Student s2 = new Student();
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        //成员变量分为实例变量和静态变量
        //实例变量没有static修饰，它从该类的实例被创建时就存在，直到系统销毁这个实例，实例变量的作用域与对应实例的生存范围相同；
        //静态变量可以通过类名.变量名访问，静态变量没有this关键字。
        Test1.age = 20;
        System.out.println(Test1.age);
        //局部变量
        for (int i = 0; i < 10; i++) {
            int age1 = 10;
            System.out.println(age1);
        }
//        System.out.println(age1);
       //调用checkName方法
        System.out.println(s1.checkName("张三"));
    }
        //形参是定义在方法中的变量，作用域是方法内。
    public void test(int age2){
        System.out.println(age2);
    }
}
