import java.io.FileWriter;
import java.io.Writer;
public class Filewriter {
    public static void main(String[] args)  {
        //搞清楚文件字符输出流的作用
        //1.创建文件字符输出流对象
        try(//该对象创建成功后，会自动调用close方法，关闭流
//               Writer fw = new FileWriter("Week4\\src\\d.txt");//覆盖
               Writer fw = new FileWriter("Week4\\src\\d.txt",true);//追加
        ){
            //写一个字符出去
            fw.write('a');
            fw.write(97);
            fw.write('徐');
            //2.写一个字符串出去
            fw.write("DZQ");
            fw.write("\r\n");
            //3.写一个字符数组出去
            char[] chars = "DZQQQQQQ".toCharArray();
            fw.write("\r\n");
            fw.write(chars);
            //4.写一个字符数组的指定部分出去
            fw.write(chars,4,1);
            //5.写一个字符串的指定部分出去
            fw.write("DCGGGGG",4,1);
            //只有关闭或者刷新流才可以保存传输的数据。
            //因为有内存缓冲区，所以数据不会立刻写入文件。
            fw.flush();//刷新
            //刷新后，流可以继续使用
            fw.close();//关闭，包含刷新关闭后流不能再使用
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
