import java.util.Objects;

public class Student {
  String name;
  int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    // 重写equals方法使得比较时候比较的是内容
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
}
