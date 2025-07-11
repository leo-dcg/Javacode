//包的导入*指的是所有类
import cdc.packegetext;
import cdc.*;
public class Codechunck {
    //静态代码块属于类使用只执行一次在类加载的时候执行。
    //完成类的初始化例如：对静态变量的初始化
    //执行顺序：父类静态代码块 > 子类静态代码块 > main()方法 > 父类代码块 > 父类构造器 > 子类代码块 > 子类构造器
    public static String name;
    static{
        System.out.println("静态代码块");
        name = "张三";
    }
    //实例代码块无static修饰，属于对象，对象创建的时候执行
    {
        System.out.println("实例代码块");
    }
    public static void main(String[] args){
        //代码块是类的五大成分之一（成员变量、方法、构造器、代码块、内部类）
        //先输出静态代码块
     System.out.println("main方法");
     System.out.println(name);
     new Codechunck();
    }
}
