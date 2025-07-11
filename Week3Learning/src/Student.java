public class Student {
    //private关键字：private修饰的成员变量，只能在本类中访问，
    // 但是可以通过getter和setter方法进行访问
    private String date;
    String name;
    int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //封装就是用类设计对象处理某一个事物的数据时，
    // 应该把要处理的数据，以及处理这些数据的方法，设计到一个对象中去。
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //创建有参构造器如果还想使用有参构造器那么得再写一遍无参构造器
    //通过构造器可以快速创建对象
    public Student() {}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
   //this主要用来解决：变量名称冲突问题的。
    public String checkName(String name) {
        if (this.name==name) {
            return "姓名相同";
        } else {
            return "姓名不同";
        }
        //this.name
        //return name;
    }
    //有static修饰的方法属于类，不能用this
    //无static修饰的方法属于对象，可以用this
    //静态方法可以用来设计工具类，实例方法需要创建对象来调用，会浪费内存。
    //工具类不需要创建对象， 建议将工具类的构造器私有化。
    //静态方法中可以直接访问静态成员，不可以直接访问实例成员。
    //实例方法中既可以直接访问静态成员，也可以直接访问实例成员。
    //实例方法中可以出现this关键字，静态方法中不可以出现this关键字的。
    private static void checkAge(int age) {
        if (age>=18) {
            System.out.println("已成年");
        } else {
            System.out.println("未成年");
        }
    }
}
