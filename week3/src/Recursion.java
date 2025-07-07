//递归
public class Recursion {
    //递归三要素：递归函数，递归结束条件，递归方向走向终点
    public static void main(String[] args) {
        System.out.println(n1(5));
        System.out.println(toin(1));
    }

    public static int n1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * n1(n - 1);
        }
    }

    public static int toin(int day){
        if(day == 10){
            return 1;
        }
        else{
            return 2*toin(day+1)+2;
        }
    }
}

