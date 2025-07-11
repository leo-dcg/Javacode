//接口和抽象类相同点：
//      1、多是抽象形式，都可以有抽象方法，都不能创建对象。
//      2、都是派生子类形式：抽象类是被子类继承使用，接口是被实现类实现。
//      3、一个类继承抽象类，或者实现接口，都必须重写完他们的抽象方法，否则自己要成为抽象类或者报错！
//      4、都能支持的多态，都能够实现解耦合。
//
//抽象类和接口的不同点：
//      1、抽象类中可以定义类的全部普通成员，接口只能定义常量，抽象方法（JDK8新增的三种方式）
//      2、抽象类只能被类单继承，接口可以被类多实现。
//      3、一个类继承抽象类就不能再继承其他类，一个类实现了接口（还可以继承其他类或者实现其他接口）。
//      4、抽象类体现模板思想：更利于做父类，实现代码的复用性。  最佳实践
//      5、接口更适合做功能的解耦合：解耦合性更强更灵活。   最佳实践
public class Test5 {
    public static void main(String[] args) {
        // 目标：去理解Java设计接口的好处、用处。
        // 接口弥补了类单继承的不足，可以让类拥有更多角色，类的功能更强大。
        People1 p = new Student1();
        Driver d = new Student1(); // 多态
        BoyFriend bf = new Student1();

        // 接口可以实现面向接口编程，更利于解耦合。
        Driver a = new Student1();
        Driver a2 = new Teacher1();

        BoyFriend b1 = new Student1();
        BoyFriend b2 = new Teacher1();
    }
}

interface Driver{}
interface BoyFriend{}
class People1{}
class Student1 extends People1 implements Driver, BoyFriend{}

class Teacher1 implements Driver, BoyFriend{}