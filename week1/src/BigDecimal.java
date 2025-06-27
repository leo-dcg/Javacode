public class BigDecimal {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(128);
        Integer j = Integer.valueOf(128);
        System.out.println(i == j);
        System.out.println(i.equals(j));
        System.out.println(i.compareTo(j));
        System.out.println("======================");
        //解释为什么会不等
        //对于基本数据类型，==（双等号）比较的是值，而对于包装类型，==（双等号）比较的则是2个对象的内存地址。
        //当赋的基本数据类型值不在[-128, 127]之间，会去Java堆内存中new一个对象出来，显然它们是两个不同的对象，所以结果false；
        //而值在[-128, 127]之间，会直接从IntegerCache中获取，也就是从缓存中取值，不用再创建新的对象，即同一个对象，所以结果true。
        java.math.BigDecimal b = java.math.BigDecimal.valueOf(0);
        java.math.BigDecimal c = java.math.BigDecimal.valueOf(0.0);
        System.out.println(b == c);
        System.out.println(b.equals(c));
        //equals() 方法要求两个 BigDecimal 的 数值 和 scale（精度） 都要相等。
        //BigDecimal.valueOf(0) 使用的是 long 构造器，生成的 BigDecimal 的 scale 是 0。
        //BigDecimal.valueOf(0.0) 使用的是 double 构造器，生成的 BigDecimal 的 scale 是 1
        System.out.println(b.compareTo(c));
        //解释为什么会出现b==c输出false,b.equals(c)输出false而compareTo(c)输出0三个结果
        //介绍compareTo 方法(只关心数值不关系精度)
        //compareTo 方法比较两个 BigDecimal 对象的值，并返回一个整数。
        //快速路径优化：如果两个数的精度相同且未膨胀，直接比较它们的紧凑型数值。
        //符号比较：先比较两个数的符号，正数永远大于负数。
        //零值处理：如果其中一个数为零，直接返回对应的结果。
        //绝对值比较：如果符号相同，则比较它们的绝对值大小，并根据符号决定返回值的正负。
        //这种方法确保了对 BigDecimal 的高效比较，同时支持非常大的数值（通过 BigInteger 支持）。
    }
}
