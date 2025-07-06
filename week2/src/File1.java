import java.io.File;
public class File1 {
    public static void main(String[] args){
        //创建"E:\javacode\week2\src\新建 文本文档.txt"文件对象
        File file = new File("E:\\javacode\\week2\\src\\1.txt");
        System.out.println(file.exists());
    }
}
