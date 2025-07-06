public class Param {
    public static void main(String[] args) {

        Param p = new Param();
        p.sum(18, 1, 2, 3, 4, 5);
        p.sum(18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
    //定义可变参数类
    //int... args可以接多个参数，其相当于一个int数组
    //函数参数列表中只能有一个可变参数，如果要加多个其他参数，则只能放在可变参数前面。
    public void sum(int age,int... args) {
    }
}
