import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferWriter {
    public static void main(String[] args)  {
        //搞清楚缓冲字符输出流的使用
        //提升性能，多了换行功能
        //1.创建文件字符输出流对象
        try(//该对象创建成功后，会自动调用close方法，关闭流
//               Writer fw = new FileWriter("Week4\\src\\d.txt");//覆盖
            Writer fw = new FileWriter("Week4\\src\\d.txt",true);//追加
            BufferedWriter bw = new BufferedWriter(fw);
        ){
            //写一个字符出去
            bw.write('a');
            bw.write(97);
            bw.write('徐');
            //2.写一个字符串出去
            bw.write("DZQ");
            bw.newLine();
            //3.写一个字符数组出去
            char[] chars = "DZQQQQQQ".toCharArray();
            bw.newLine();
            bw.write(chars);
            //4.写一个字符数组的指定部分出去
            bw.write(chars,4,1);
            //5.写一个字符串的指定部分出去
            bw.write("DCGGGGG",4,1);
            //只有关闭或者刷新流才可以保存传输的数据。
            //因为有内存缓冲区，所以数据不会立刻写入文件。
            bw.flush();//刷新
            //刷新后，流可以继续使用
            fw.close();//关闭，包含刷新关闭后流不能再使用
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
