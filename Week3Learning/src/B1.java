// 一个类继承抽象类，必须重写完继承的全部抽象方法，否则这个类也必须定义成抽象类
public class B1 extends A1{
    @Override
    public void show() {
        System.out.println("B1类重写show方法");
    }
}
