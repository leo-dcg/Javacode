import java.math.BigDecimal;

public class BigDecimalvoid {
    public static void main(String[] args){
        BigDecimal adouble =new BigDecimal(1.22);
        System.out.println("construct with a double value: " + adouble);
        BigDecimal astring = new BigDecimal("1.22");
        System.out.println("construct with a String value: " + astring);
        //解释为什么输出adouble会输出 1.2199999999999999733546474089962430298328399658203125
        //Java 中的 double 是基于 IEEE 754 标准的二进制浮点数，无法精确表示某些十进制小数。
        //例如：1.22 在二进制中是一个无限循环小数，无法用有限位的二进制精确表示。
        //所以当你传入 1.22 给 BigDecimal.valueOf(1.22) 或 new BigDecimal(1.22) 时，实际上你传的是一个已经被 double 精度“污染”过的近似值。
        //所以推荐使用字符
        //加法
        BigDecimal a = new BigDecimal("1.22");
        BigDecimal b = new BigDecimal("1.22");
        BigDecimal c = a.add(b);//注意需要用一个变量接收结果，因为BigInteger与BigDecimal都是不可变的(immutable)的
        System.out.println("add: " + c);
        //除法
        BigDecimal d = new BigDecimal("1");
        BigDecimal e = new BigDecimal("3");
        BigDecimal f = d.divide(e, 2, BigDecimal.ROUND_HALF_UP);//2表示保留两位小数，BigDecimal.ROUND_HALF_UP表示四舍五入
        System.out.println("divide: " + f);
        //减法
        BigDecimal g = new BigDecimal("1.22");
        BigDecimal h = new BigDecimal("1.22");
        BigDecimal i = a.subtract(b);
        System.out.println("subtract: " + i);
        //乘法
        BigDecimal j = new BigDecimal("1.22");
        BigDecimal k = new BigDecimal("1.22");
        BigDecimal l = a.multiply(b);
        System.out.println("multiply: " + l);
        //取余
        BigDecimal m = new BigDecimal("10");
        BigDecimal n = new BigDecimal("3");
        BigDecimal o = m.remainder(n);
        System.out.println("remainder: " + o);
    }
}
