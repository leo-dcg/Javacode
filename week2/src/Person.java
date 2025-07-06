/**
 * 弄清楚浅拷贝和深拷贝和引用拷贝的区别
 *引用类型和基本数据类型区别
 * 包装类和String都是不可变的引用类型
 */
public class Person implements Cloneable {
    private String name;
    private int age;
    private String bio;
    //请创建一个包装类（引用类型）Integer
    private Integer id;
    private MutableInteger Mid; // 替换为可变包装类

    public MutableInteger getMid() {
        return Mid;
    }

    public void setMid(MutableInteger mid) {
        Mid = mid;
    }

    public static class MutableInteger {
        public int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public MutableInteger(int value) {
            this.value = value;
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person(String name, int age, String bio, Integer id, MutableInteger mid) {
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.id = id;
        this.Mid = mid;
    }

    // 浅拷贝：直接调用 super.clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 模拟深拷贝：复制所有字段，创建新字符串对象
    public Person deepCopy() {
        return new Person(new String(this.name), this.age, new String(this.bio), this.id, this.Mid);
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    //引用拷贝：两个不同的引用指向一个对象
    //浅拷贝和深拷贝都属于对象拷贝
    //浅拷贝：创建新对象，不过如果原对象内部的属性是引用类型，那么浅拷贝会直接复制内部对象的引用地址。
    //被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。即对象的浅拷贝会对“主”对象进行拷贝，但不会复制主对象里面的对象。”里面的对象“会在原来的对象和它的副本之间共享。
    //拷贝对象和原对象公用同一个内部对象
    //深拷贝：创建新对象，并且将原对象内部的属性也复制一份，
    //但是String类型是不可变对象，所以String类型字段只能为深拷贝
    //包装类都是不可变对象。所以即使P1修改了p2也不会修改。不可变对象的意思是在修改值后，会把地址指向新的对象，而不是修改原来的对象。
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("Tom", 20, "Loves programming",1, new MutableInteger(1));
        Person p2 = (Person) p1.clone();      // 浅拷贝
        Person p3 = p1.deepCopy();            // 模拟深拷贝
        Person p4 = p1;                        //引用拷贝
        System.out.println("原始对象: " + p1.getBio());
        System.out.println("原始对象地址: " + p1);
        System.out.println("浅拷贝对象: " + p2.getBio());
        System.out.println("浅拷贝对象地址: " + p2);
        System.out.println("深拷贝对象: " + p3.getBio());
        System.out.println("深拷贝对象地址: " + p3);
        System.out.println("引用拷贝对象: " + p4.getBio());
        System.out.println("引用拷贝对象地址: " + p4);
        // 修改原对象的 bio 字符串引用类型字段
        p1.setBio("Now loves hiking");
        //修改原对象的 age 基本数据类型字段
        p1.setId(100);
        //设置p1Mid的值为100
        p1.getMid().setValue(100);
        System.out.println("\n修改原始对象后的引用类型:");
        System.out.println("原始对象: " + p1.getBio());
        System.out.println("浅拷贝对象: " + p2.getBio());   // bio 会被影响（因为是同一个引用）
        System.out.println("深拷贝对象: " + p3.getBio());   // bio 不受影响（因为是独立副本）
        System.out.println("引用拷贝对象: " + p4.getBio()); // bio 受影响（因为是同一个引用）
        System.out.println("引用拷贝对象: " + p2.getId());
        //输出p2的Mid
        System.out.println("引用拷贝对象引用对象的值: " + p2.getMid().getValue());

    }
}
