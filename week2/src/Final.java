import java.util.ArrayList;
import java.util.List;

public class Final {
    public static void main(String[] args) {
        // final 关键字用法
        System.out.println("final 测试");
        final int a = 10;
        System.out.println(a);
        //用关键字修饰list，集合可以修改.
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list);
        //为什么final修饰的list集合可以修改，因为final修饰的list集合，只是引用不可以修改，但是list集合里面的元素是可以修改的
        //引用不能修改的意思是，list集合的引用不可以指向新的对象，但是list集合里面的元素是可以修改的
        //final的所有用法
        final int b = 10;
        final int c;
        c = 20;
        //final修饰的数组，数组可以修改。
        final int[] d = new int[10];
        d[0] = 10;
        d[1]= 20;
        d[1]= 30;
        //final修饰的类不可以被继承，但是可以重载
        final class Test{
            public void test(){
                System.out.println("test");
            }
            public void test(int a){
                System.out.println("test" + a);
            }

        }

    }
}
