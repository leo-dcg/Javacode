import java.io.File;

public class Blianlizhaowenjian {
    public static void main(String[] args) {
    File file = new File("E:" +
            "/");
    searchfile(file,"1.txt");
    }
    /**
     * 递归搜索文件
     * @param file 搜索的目录
     * @param Filename  搜索的文件名称
     */
    public static void searchfile(File file, String Filename){
       // 判断file是否为空，是否为文件夹
        if(file == null||!file.exists()||file.isFile()){
           return;
       }
        // 获取file下的所有文件对象
        File[] files = file.listFiles();
        // 判断当前目录下是否存在一级对象
        if(files != null &&files.length > 0){
            //遍历文件对象
            for(File f:files){
                //判断当前文件对象是否为文件
                if(f.isFile()){
                    //判断文件名是否相同
                    if(f.getName().equals(Filename)){
                        System.out.println(f.getAbsolutePath());
                    }
                }else{
                    searchfile(f,Filename);
                }
            }
        }

    }
}

