import java.util.HashMap;
import java.util.Map;

public class Compute {
    public static void main(String[] args){
        //演示compute 方法
        Map<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        //compute方法的作用是获取键对应的值，并执行一个函数，返回结果，然后将结果重新放入键对应的值中
        map.compute("1",(k,v)->v+1);
        System.out.println(map);
        //computeIfPresent方法作用是判断键对应的值是否存在，如果存在则执行一个函数，返回结果，然后将结果重新放入键对应的值中
        map.computeIfPresent("1",(k,v)->v+1);
        System.out.println(map);
        //computeIfAbsent方法作用是判断键对应的值是否存在，如果不存在则执行一个函数，返回结果，然后将结果重新放入键对应的值中
        map.computeIfAbsent("4",k->1);
        System.out.println(map);
        map.computeIfAbsent("5",k->null);
        System.out.println(map);
        map.computeIfAbsent("6",k->{
            if(k.equals("6")){
                return 6;
            }
            return null;
        });
    }
}
