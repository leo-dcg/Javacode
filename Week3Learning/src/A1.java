// 抽象类
public abstract class A1 {
    private String name;
    private int age;

    public A1() {
        System.out.println("A1的无参构造器");
    }

    public A1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 抽象方法：必须用abstract修饰，没有方法体，只有方法声明。
    public abstract void show();

    public void show1() {
        System.out.println("show1方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
