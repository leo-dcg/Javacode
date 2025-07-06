import java.util.*;

public class Room {
    public static void main(String[] args) {
        Start();
    }

    public static void Start() {
        // 初始牌组
        List<Card> list = new ArrayList<>();
        // 准备花色
        String[] colors = {"♥", "♠", "♣", "♦"};
        // 准备牌
        String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A","2"};
        int num = 0;
        for (String number : numbers) {
            num++;
            for (String color : colors) {
                list.add(new Card(number, color, num));
            }
        }
        // 用 Collection 工具类一句语句加入小王和大王
        Collections.addAll(list, new Card("小王", "", ++num), new Card("大王", "", ++num));
        System.out.println(list);
        // 洗牌
        Collections.shuffle(list);
        System.out.println(list);
        //用hashmap创建玩家对象其中键为玩家，值为ArrayList
        HashMap<String,ArrayList<Card>> players = new HashMap<>();
        players.put("玩家1",new ArrayList<>());
        players.put("玩家2",new ArrayList<>());
        players.put("玩家3",new ArrayList<>());
        //开始分牌
        for (int i = 0; i < list.size()-3; i++) {
            players.get(i%3==0?"玩家1":i%3==1?"玩家2":"玩家3").add(list.get(i));
        }
        System.out.println(players);
        //理牌通过num值进行排序
        for (ArrayList<Card> value : players.values()) {
            Collections.sort(value, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    return o1.getBallance()-o2.getBallance();
                }
            });
        }
        System.out.println(players);
    }
}