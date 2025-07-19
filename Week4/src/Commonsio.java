import org.apache.commons.io.FileUtils;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Commonsio {
    public static void main(String[] args)throws Exception {
        //io框架
        FileUtils.copyFile(new File("Week4\\src\\csb.txt"), new File("Week4\\src\\csb_out.txt"));
        //jdk
//        Files.copy(Paths.get("Week4\\src\\csb.txt"), Paths.get("Week4\\src\\csb_out.txt"));
        FileUtils.deleteDirectory(new File("Week4\\src\\csb_out.txt"));
    }
}
