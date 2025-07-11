import java.util.Scanner;

public class Yunxingyichang {
    public static void main(String[] args) {
        while (true) {
            try {
                int age = userinput();
                System.out.println("输入的数字是："+age);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("程序异常请重新输入");
            }
        }
    }
    public static int userinput()
    {
        System.out.println("请输入一个数字：");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        return age;
    }
}
