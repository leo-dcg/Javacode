import java.util.Scanner;

public class Zidingyiyichang {
    /**
     * 自定义的运行时异常
     * 1、继承RuntimeException做爸爸。
     * 2、重写RuntimeException的构造器。
     * 3、哪里需要用这个异常返回，哪里就throw
     */
    public static void main(String[] args) {
    //自定义构造器
        while (true) {
            try {
                age(userinput());
                System.out.println("投票成功");
            } catch (AgeIlegal e) {
                e.printStackTrace();
                System.out.println("投票失败，请重新输入一个大于等于18的数字");
            }
        }
    }
    //因为age（int age）限定了参数类型，所以无法输入除数字以外的数据
    public static void age(int age) throws AgeIlegal {
        if (age < 18) {
            // 年龄非法；抛出去一个异常。
            throw new AgeIlegal("你没有投票资格");
        }
        System.out.println("投票成功");
    }
    public static int userinput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int age = sc.nextInt();
        return age;
    }
}

