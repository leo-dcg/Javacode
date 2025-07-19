import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Recovercsb {
    public static void main(String[] args) {
        //读取出师表用list集合接对其进行排序
        try (
                BufferedReader br = new BufferedReader(new FileReader("Week4\\src\\csb.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("Week4\\src\\csb_out.txt"));

        ) {
            String line;
            ArrayList<String> list1 = new ArrayList<>();
            //调用缓冲字节输入流读取方法，一次读取一行
            while ((line = br.readLine()) != null) {
                list1.add(line);
            }
            //按升序排列
            Collections.sort(list1);
            for (String s : list1) {
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            System.out.println("排序完成！");
            bw.close();
            //拓展：每次读取多个字节，性能得到提升。
            //是按照字符读取，不会出现乱码。
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
