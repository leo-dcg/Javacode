import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collectionstools {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //1.使用Colletions的方法批量加入元素，后面为可变参数
        Collections.addAll(list, "1", "2", "3", "4", "5");
        System.out.println(list);
        //2.使用Collections的方法打乱集合元素
        Collections.shuffle(list);
        System.out.println(list);
        //3.使用Collections的方法使用比较器排序规定降序，用简化方法写比较器对集合元素进行排序
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        System.out.println(list);

    }
}
