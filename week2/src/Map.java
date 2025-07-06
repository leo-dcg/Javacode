import java.util.HashMap;

// 用一个案例演示MAP的值可以为空
public class Map {
    public static void main(String[] args) {
        // 创建一个HashMap实例
        java.util.Map<String, String> myMap = new HashMap<>();

        // 向Map中添加键值对，其中值可以为null
        myMap.put("key1", null); // 这里值为null

        // 检查是否成功添加了值为null的键值对
        System.out.println("Value for key1: " + myMap.get("key1")); // 输出: Value for key1: null

        // 继续添加其他键值对
        myMap.put("key2", "value2");

        // 打印整个Map
        System.out.println("The entire map: " + myMap); // 输出: The entire map: {key1=null, key2=value2}
    }
}





