import java.util.Objects;

public class Student {
    static int count = 0;
    String name;
    int age;

    //equals如果要满足被比较对象和原对象都为null时，返回true要怎么重写equals方法
    //重写equals方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = null;
        Student s4 = null;
        s1.name = "Tom";
        s1.age = 18;
        s2.name = "Tom";
        s2.age = 18;

        //打印输出
        System.out.println(s1==s2);//输出: false所以要重写equlas 方法
        System.out.println(s1.equals(s2));//输出: false, 因为object类的equals方法也用的是==比较的是地址

        //如果有两个NULL记得使用try-catch去除异常，否则会报空指针异常
        try {
            System.out.println(s3.equals(s4));
        }
        catch (Exception e) {
            System.out.println("程序异常结束");
        }
    }
}
