import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = sc.nextLine();
        System.out.println("name = " + name);
    }
}
// 1、java的类只能是单继承的，不支持多继承，支持多层继承
// 2、一个类要么直接继承Object，要么默认继承Object，要么间接继承Object
class Cat extends Animal1{
    // 方法重写: 方法名称，形参列表必须一样，这个方法就是方法重写。
    // 重写的规范：声明不变，重新实现。
    @Override // 方法重写的校验注解（标志）：要求方法名称和形参列表必须与被重写方法一致，否则报错！ 更安全，可读性好，更优雅！
    public void cry(){
        System.out.println("🐱喵喵喵的叫~~~");
    }
}
class  Animal1{
    public void cry(){
        System.out.println("动物会叫~~~");
    }
}


