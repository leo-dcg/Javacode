import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ArrayListWork {
    public static void main(String[] args) {
        //创建一个包含 5 个不同水果名称的 ArrayList，并打印输出
        ArrayList<String> list = new ArrayList();
        list.addAll(asList("苹果", "西瓜", "凤梨", "橘子", "榴莲"));
        System.out.println(list);
        //查找苹果的索引
        int index = list.indexOf("苹果");
        System.out.println(index);
        //第二个位置插入芒果
        list.add(1,"芒果");
        System.out.println(list);
        //在水果列表的 橘子 前边插入 “芒果” ,橘子 后边插入芒果
        list.add(list.indexOf("橘子")-1,"芒果");
        list.add(list.indexOf("橘子")+1,"芒果");
        System.out.println(list);
        //创建一个新水果集合将其加到列表末尾
        List<String> list1 = new ArrayList();
        list1.addAll(asList( "梨", "香蕉", "山竹","香蕉"));
        list.addAll(list1);
        System.out.println(list);
        //删除列表中所有的香蕉
        list.removeAll(asList("香蕉"));
        System.out.println(list);
        //for each循环遍历列表并打印列表中所有水果的大写形式
        ArrayList<String> list2 = new ArrayList();
        list2.addAll(asList("apple", "banana", "orange", "peach"));
        for(String fruit : list2){
            System.out.println(fruit.toUpperCase());
        }
        //获取列表中第 2-4 个位置的子列表，并将子列表内容反转
        ArrayList<String> list3 = new ArrayList<> (list1.subList(1,3));
        System.out.println(list3);
        list3 = new ArrayList<>(list3.reversed());
        System.out.println(list3);
        //将 ArrayList 转换为数组，并打印数组内容
        Object[] j=list2.toArray();
        for(Object i:j){
            System.out.println(i);
        }
        //检查列表中是否同时包含橘子和樱桃
        boolean key = list.containsAll(asList("橘子", "樱桃"));
        System.out.println(key);
        //创建原列表的深拷贝，修改拷贝后确保原列表不受影响
        List<String> list4 = new ArrayList<>(list);
        System.out.println(list4);
        System.out.println(list==list4);
        System.out.println(list.equals(list4));
        list4.removeAll(list);
        System.out.println(list4);
        System.out.println(list);
        //按字母顺序升序排列水果列表
        Collections.sort(list2);
        System.out.println(list2);
        //在包含重复元素的数字列表中，移除重复值
        List<String> list5 = new ArrayList<>(asList("1","1","2","2","1"));
        //利用LinkedHashSet的无重复有序性。
        ArrayList<String> list6 = new ArrayList<>(new LinkedHashSet<>(list5));
        System.out.println(list6);
        //删除列表中所有以 "B" 开头的水果
//        list2.removeIf(fruit -> fruit.startsWith("b"));
//        System.out.println(list2);
        //用流的方法处理
        list2 = new ArrayList<>(list2.stream().filter(fruit -> !fruit.startsWith("b")).collect(Collectors.toList()));
        System.out.println(list2);
        //调整列表容量为当前元素数量。
        ((ArrayList<String>) list2).trimToSize(); // 调整容量为当前元素数量
        //使用 Java 8 Stream API 找出所有长度超过 5 个字母的水果
        list2=new ArrayList<>(list2.stream().filter(fruit -> fruit.length() > 5).collect(Collectors.toList()));
        System.out.println(list2);
    }
}
