import java.util.ArrayList;

public class Removeallretainall {
    public static void main(String[] args){
        //演示Arreylist中的removeall和retainall方法的区别
        //removeall方法作用是删除所有原list1中包含输入list2中元素
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list2.add(1);
        list2.add(2);
        System.out.println(list1);
        list1.removeAll(list2);
        System.out.println(list1);
        System.out.println("-----------------");
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list4.add(1);
        list4.add(2);
        System.out.println(list3);
        //retainall方法作用是保留所有原list3中包含输入list4中元素
        list3.retainAll(list4);
        System.out.println(list3);
        System.out.println("-----------------");
    }
}
