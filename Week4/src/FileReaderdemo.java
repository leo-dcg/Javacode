/*
 * 什么时候用字节流：文件复制
 * 什么时候用字符流：读取文本文件
 */
import java.io.FileReader;
public class FileReaderdemo {
    public static void main(String[] args) {
        //目标：使用文件字符输入流读取文件到程序中来
        //1穿件文件输入流对象
       try(
               FileReader fr = new FileReader("Week4\\src\\d.txt");
       ){
           //2.创建一个字符数组，用于装数据
           char[] chs = new char[3];
           //3.开始读取，每次读取一个字符数组的长度字节
           int len;
           while((len = fr.read(chs)) != -1){
               //4.把字符数组转换成字符串，并输出
               String str = new String(chs, 0, len);
               System.out.print(str);
           }
           //拓展：每次读取多个字节，性能得到提升。
           //是按照字符读取，不会出现乱码。
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
