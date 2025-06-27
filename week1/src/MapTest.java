import java.util.*;

public class MapTest {
    public static void main(String[] args) {
      test1();
    }
    public static void test1(){
        List<String> list = new ArrayList<>();
        String []Location={"北京","上海","广州","深圳"};
        Random a=new Random();
        for(int i=0;i<80;i++){
            int index=a.nextInt(Location.length);
            list.add(Location[index]);
        }
        System.out.println(list);
        Map<String,Integer> map = new HashMap<>();
        for(String s:list){
            //判断当前城市是否已经存在如果存在则获取当前城市的数量并加1
            if(map.containsKey(s)){
                Integer count = map.get(s);
                map.put(s,count+1);
            }else{
                //如果不存在则将当前城市添加到map集合中，并设置数量为1
                map.put(s,1);
            }
        }
        //foreach 遍历
        map.forEach(
                (k,v)->System.out.println(k+"出现的次数为："+v)
        );

    }
}
