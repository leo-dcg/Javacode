import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class week1suammary {
    public class Main {
        //还有一个数据类型
        //深入java虚拟机
        //字符长度(虚拟机上存储长度）布尔类型数据库虚拟机上存储长度
        //包装类和原来的数据比例（扩四倍）
        //对象分几个部分
        public static void main(String[] args) {
            Integer i = Integer.valueOf(1);
            BigDecimal b = BigDecimal.valueOf(0);
            BigDecimal c = BigDecimal.valueOf(0.0);
            System.out.println(b == c);
            System.out.println(b.equals(c));
            System.out.println(b.compareTo(c));
            //比较对象128以上注意
            //用compare
            //用BigDecimal学习方法（加减乘除取余计算方式）
            //list Set map
            List e =new ArrayList();
            //List扩展因子
            //不是线程安全的注意，可以存null。
            e.contains( null);
            //hashmap红黑树变链表的阈值
            //遍历hashmap遍历时变更 k不允许null 方法的意义
//            new HashMap().put(null,null);
//            new HashMap().computeIfAbsent(null);
//            new HashMap().get(null);
//            new HashMap().compute(null);
//            new HashMap().computeIfPresent(null);
            //枚举map
            //equals hashCode
            //set hashset，hashmap,arraylist,底层了解方法
            new HashSet().add(null);
        }
    }
}
