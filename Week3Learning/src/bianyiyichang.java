public class bianyiyichang {
    public static void main(String[] args) {

        try {
            Saveage(100);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("程序异常结束");
        }
    }
    public static void Saveage(int age) throws Exception {
        if(age<1||age>120){
            throw new Exception("年龄不合法");
        }
        else{
            System.out.println("年龄合法");
        }
    }
}
