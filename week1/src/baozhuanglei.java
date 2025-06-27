import java.util.ArrayList;

public class baozhuanglei {
    //因为不支持基本数据类型，所以只能用包装类（用来将基本数据打包成类）
    public static void main(String[] args) {
        //int 不支持报错
        //ArrayList<Int> list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        int rs=list.get(0);
        //手工包装对象
        Integer b = Integer.valueOf(20);
        Integer a = Integer.valueOf(10);
        //自动包装对象(int和char比较特殊，另外为类型首字母大写)
        Integer c = 10;
        Character ch = 'a';
        Double d = 10.0;
        boolean flag = a > b;
        //自动拆箱
        System.out.println(a);
        //包装类方法
        //1.把基本数据类型转换成字符串
        int i = a.intValue();
        String s = a.toString();
        System.out.println(s+1);
        Integer i1 = a;
        String s1 = i1.toString();
        System.out.println(s1+1);
        //主要用这个
        String s2 = i1+"";
        //2.把字符串转换成基本数据类型!!!
        String s3 = "10";
        String s4 = "10.0";
        int i2 = Integer.parseInt(s3);
        double d1 = Double.parseDouble(s4);
        double d2 = Double.valueOf(s4);
        //valueof 和 parseInt的区别是：parseInt()方法返回一个int类型的值，而valueOf()方法返回一个Integer对象。
        System.out.println("==========");
        System.out.println(d1+1);
        System.out.println(d2+2);
        int i3 = Integer.valueOf(s3);
        System.out.println(i2+1);
        System.out.println(i3+2);
    }
}
