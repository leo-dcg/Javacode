import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        //目标：搞清楚缓冲字节输入流读取字符内容：性能提升，多了以行读取字符的功能。
        //1穿件文件输入流对象
        try(
                FileReader fr = new FileReader("Week4\\src\\d.txt");
                //2.创建缓冲字符输入流包装低级的字符输入流
                BufferedReader br = new BufferedReader(fr);
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

    }
}
