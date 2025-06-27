import java.util.*;

public class list {
    public static void main(String[] args) {
         //List和Set是存储单列数据的集合，Map是存储键值对这样的双列数据的集合
        //list集合的特点：有序，可重复,有索引
        List<String> list1=new ArrayList<>();
        List list=new ArrayList();
        //list的所有方法
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.isEmpty());
        System.out.println(list.remove(0));
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("-----------------");
        //Arreylist特有的方法
        list.add(0,"java");
        System.out.println(list);
        list.add(1,"world");
        System.out.println(list);
        list.add(2,"hello");
        list.set(1,"java");
        System.out.println(list);
        System.out.println(list.indexOf("world"));
        //lastIndexOf方法的作用是返回list集合中指定元素最后一次出现的索引
        System.out.println(list.lastIndexOf("world"));
        //subList方法的作用是截取list集合中的子集合
        System.out.println(list.subList(1,3));
        //containsALL方法的作用是判断list集合中是否包含list2集合中的所有元素
        System.out.println(list.containsAll(list));
        System.out.println("-----------------");
        //转换成字符串
        System.out.println(list.toString());
        System.out.println("-----------------");
        //转换成数组
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println("-----------------");
        //清空集合
        list.clear();
        //list集合的遍历方式
        //第一种遍历方式for循环
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //第二种遍历方式for-each循环 //增强迭代for(集合元素类型 集合变量名:集合名)
        for(Object obj:list){
            System.out.println(obj);
        }
        //第三种遍历方式迭代器,不要把迭代器的定义放在循环内。
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            //先获取数据，再移动指针。
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");
        //遍历时删除注意的问题
        //for循环迭代删除使用i--
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(list.get(i).equals("world")){
                list.remove(i);
                i--;
            }
        }
        //增强for不能迭代时删除
        //迭代器可以迭代时删除
        Iterator iterator1 = list.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
            if(iterator1.next().equals("world")){
                iterator1.remove();
            }
        }
        //linkedList特有方法适合从头部尾部操作数据。适合做队列，适合做栈。
        LinkedList linkedList =new LinkedList();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("java");
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);

    }
}
