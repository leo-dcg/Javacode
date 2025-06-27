import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class set {
    public static void main(String[] args) {
        //set的集合特点是无序，不重复，无索引
        Set<String> set=new HashSet();
        set.add("hello");
        set.add("world");
        set.add("hello");
        //set的所有方法
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("hello"));
        System.out.println(set.remove("hello"));
        System.out.println(set.size());
         System.out.println(set);
         System.out.println("-----------------");
         //hashset的方法
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains(1));
        System.out.println(set.remove(1));
        System.out.println(set.size());
        System.out.println(set);
        System.out.println("-----------------");
        System.out.println(set.hashCode());
        //返回第一个元素的hashcode值
        System.out.println(set.iterator().next().hashCode());
        //两个集合的交集
        System.out.println(set.retainAll(set));
        //集合的差集
        System.out.println(set.removeAll(set));
        //clone方法的作用是返回一个集合的浅拷贝
        Set<String> clonedSet = (Set<String>) ((HashSet<String>) set).clone();
        //set的三种遍历方式
        for (String s : set) {
            System.out.println(s);
        }
        for (int i = 0; i < set.size(); i++) {
            System.out.println(set.toArray()[i]);
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
