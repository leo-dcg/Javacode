import java.io.*;

public class OtherStreamDemo1 {
    public static void main(String[] args) {
            //解决不同解码方式出现的乱码：使用字符输入转换流InputStreamReader
            //解决思路：先获取文件的原始字符流，再将其按指定编码方式进行解码。
            //1穿件文件输入流对象
            try(
                    //先提取文件原始字节输入流
                    FileInputStream fr = new FileInputStream("Week4\\src\\d.txt");
                    //再创建字符输入流，指定编码方式
                    InputStreamReader reader = new InputStreamReader(fr, "UTF-8");
                    //2.创建缓冲字符输入流包装低级的字符输入流
                    BufferedReader br = new BufferedReader(reader);
            ){
                String line;
                //调用缓冲字节输入流读取方法，一次读取一行
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
                //拓展：每次读取多个字节，性能得到提升。
                //是按照字符读取，不会出现乱码。
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
            //打印流
        System.out.println("打印流");
            try(
                    //字符输出流printWriter ps = new PrintStream(new FileOutputStream("Week4\\src\\d.))
                    //字节输出流
                    PrintStream ps = new PrintStream("Week4\\src\\d.txt");
                    //打印流追加的写法
                    PrintStream ps1 = new PrintStream(new FileOutputStream("Week4\\src\\d.txt",true));
                    //特殊数据流,必须包一个低级流，可以指定类型并和类型信息一起写出
                    DataOutputStream dis = new DataOutputStream(new FileOutputStream("Week4\\src\\d.txt", true));
                    //特殊输入流
                    DataInputStream dis1 = new DataInputStream(new FileInputStream("Week4\\src\\d.txt"));

            ){
                dis.writeUTF("你嘎");
                dis.writeInt(100);
                //收发对应
                System.out.println(dis1.readUTF());
                System.out.println(dis1.readInt());
//                ps.println("hello world");
//                ps.println("a");
//                ps.println("小小的我");
//                ps1.println("hello world");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }
}
