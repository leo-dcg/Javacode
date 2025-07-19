import java.io.*;

public class Buffereddemo {
    public class FileOutPutStream {
        public static void main(String[] args) throws Exception{
            //1.创建文件字节输出流对象,true表示追加数据
            FileOutputStream fos = new FileOutputStream("week3\\src\\DCG.txt", true);
            fos.write(97);
            fos.write(98);
            fos.write('徐');//输出中文字符会乱码
            //2.使用write方法，把数组写入到文件中
            byte[] bytes = "阿斯达所多".getBytes();
            fos.write(bytes);
            //3.使用write方法，把数组的指定部分写入到文件中
            fos.write("\r\n".getBytes());
            fos.write(bytes,0,1);
            fos.close();
            //文件复制
            copy("C:\\Users\\dcg\\Pictures\\Default.jpg","week3\\src\\1.jpg");
        }
        public static void copy(String src, String dest) throws Exception{
            try ( //这里只能放置资源对象，用完后会自动调用close方法关闭
                  //资源是最终实现了AutoCloseable接口的资源对象
                  FileInputStream fis = new FileInputStream(src);
                  //把低级的流包装成高级的缓冲流
                  InputStream bis = new BufferedInputStream(fis);
                  FileOutputStream fos = new FileOutputStream(dest);
            ){
                byte[] bytes = new byte[1024];
                int len;
                while((len=bis.read(bytes)) != -1){
                    fos.write(bytes, 0, len);
                }
                System.out.println("复制完成");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
