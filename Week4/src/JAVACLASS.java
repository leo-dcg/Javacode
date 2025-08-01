/*
 * 1.面向过程和面向对象的关系
 * “面向过程关注‘步骤和算法’，面向对象关注‘职责和协作’。
 * 前者把问题拆成一串动作，后者把问题拆成一群对象，每个对象内部仍然用面向过程实现具体动作。”
 * 2.类和对象的存储
 * 1)类
 * 类的存储：编译Student.java=>Student.class(类的字节码文件)
 * =>将Student.class文件加载到虚拟机jvm方法区
 * 2）对象
 * Object  对象
   1. 存储位置。创建之后放在堆内存中
   2. 存储的结构。对象头（mark word，类型指针，记录数组长度），实例数据，对齐填充
   2. 创建的过程。在 堆内存 开辟空间 → 调用构造方法初始化 → 返回引用地址给栈内存
   3. 调用的过程。 通过 栈内存 的引用变量 找到堆中的对象 → 执行对象的方法 study()。
   4. 销毁的过程。  main方法在栈中清空，栈内存清空对象引用地址
 */
//3.方法里使用 成员变量，要注意静态方法不能访问实例变量
public class JAVACLASS {
    int count = 10; // 实例变量
    //静态变量在静态代码块之前初始化（按代码顺序）。
    //静态方法不能访问实例变量，因为静态方法在类创建时创建，实例变量是在对象创建时创建的
    public static void staticMethod() {
        // System.out.println(count); //  编译错误：无法从静态上下文引用非静态变量
        JAVACLASS e = new JAVACLASS();
        System.out.println(e.count); //  正确：通过对象访问
    }

    public void instanceMethod() {
        System.out.println(count); //  正确：实例方法可以直接访问实例变量
    }

}
//构造器和构造方法属于同一个？
//调用顺序：先调用父类的构造器
