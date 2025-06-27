import java.util.*;

public class map {
    public static void main(String[] args){
        Map map = new HashMap();
        Map map1 = new HashMap();
        //map常用方法
        map.put("1","hello");
        map.put("2","world");
        map.put("3","java");
        map1.putAll(map);
        System.out.println(map1);
        //删除指定键的键值对,并返回值
        Object value=map.remove("1");
        //获取指定键的value
        Object value1=map.get("2");
        //判断指定键是否存在
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue("hello"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //获取所有键的集合
        Set<String> set = map.keySet();
        System.out.println(set);
        //获取所有值放到集合中
        Collection<String> set1 = map.values();
        System.out.println(set1);
        System.out.println("=====");
        //conputeIfAbsent方法的作用是当键不存在时，创建键值对。
        map.computeIfAbsent('4',k->"IfAbsent");
        //computeIfPresent方法作用是当键存在时，更新键值对。
        map.computeIfPresent('2',(k,v)->"IfPresent");
        //compute方法作用是当键不存在时，创建键值对，当键存在时，更新键值对,把第二给参数位置的计算结果设为值。
        map.compute('2',(k,v)->"compute");
        System.out.println(map);
        //foreach 遍历
        //        map.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String k, Integer v) {
//                System.out.println(k + "=" + v);
//            }
//        });
        map.forEach(
                (k,v)->System.out.println(k+"=="+v)
        );
        //获取所有键值对
        Set<Map.Entry<String,String>> set2 = map.entrySet();
        for(Map.Entry<String,String> entry:set2){
            String key = entry.getKey();
            String v = entry.getValue();
            System.out.println(key + "=" + v);
        }
        //map的迭代器遍历
        Set<Map.Entry<String,String>> set3 = map.entrySet();
        Iterator<Map.Entry<String,String>> iterator = set3.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }

    }
}
