import java.util.*;
import java.util.stream.Collectors;


public class HashsetWork {


    public static void main(String[] args) {
    HashSet<String> nation = new HashSet<>();
    //创建一个包含 5 个国家名称的 HashSet，并打印输出
    nation.addAll(Arrays.asList("China", "Japan", "Korea", "USA", "England"));
    System.out.println(nation);
    //判断日本是否在集合中
    System.out.println(nation.contains("Japan"));
    //向集合中添加新国家 "Brazil"，验证是否添加成功
        nation.add("Brazil");
        System.out.println(nation);
    //创建一个包含 3 个国家的集合，批量添加到原集合中
    ArrayList<String> list=new ArrayList();
    list.add("Thailand");
    list.add("India");
    list.add("Germany");
    System.out.println(nation.containsAll(list));
    nation.addAll(list);
    System.out.println(nation);
    //尝试删除 "Germany" 元素，无论是否存在都返回操作结果
    System.out.println(nation.remove("Germany"));
    System.out.println(nation);
    //使用迭代器遍历集合并打印所有元素
    Iterator<String> iterator = nation.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
    //获取集合并返回元素数量。
    int n=nation.size();
    System.out.println(n);
    //清空集合并验证是否为空
    HashSet<String> nation1=new HashSet();
    nation1.addAll(nation);
    nation1.clear();
    System.out.println(nation1.isEmpty());
    //将 HashSet 转换为数组，并打印数组内容
    Object[] array = nation.toArray();
    for(Object i:array){
        System.out.println(i);
    }
    nation1.addAll(Arrays.asList("Japan","China","Korea"));
    //创建两个不同内容的集合，检查它们是否相等
    System.out.println(nation.equals(nation1));
   //求两个国家集合的交集
    HashSet<String> result=new HashSet();
    result.addAll(nation1);
    result.retainAll(nation);
    System.out.println(result);
    //求两个国家集合的并集
    result.addAll(nation);
    System.out.println(result);
    //求两个国家集合的差集：求集合A有而集合B没有的国家
    result.clear();
    result.add("Canada");
    result.removeAll(nation);
    System.out.println(result);
    //使用 Java 8 Stream API 找出nation中所有以 "C" 开头的国家直接输出
    nation.stream().filter(country -> country.startsWith("C")).forEach(System.out::println);
    //创建自定义对象(Student)的 HashSet，验证重写 hashCode/equals 后的去重效果
    HashSet<Student> students = new HashSet<>();
    students.add(new Student("张三", 18));
    students.add(new Student("张三", 18));
    //使用重写后的student的equals方法将同样的内容的对象加入到HashSet中发现只有一个对象，说明重写后的equals方法已经生效了。
    System.out.println(students.size());
}

}
