public class AgeIlegal extends Exception {
    /**
     * 自定义的运行时异常
     * 1、继承RuntimeException做爸爸。
     * 2、重写RuntimeException的构造器。
     * 3、哪里需要用这个异常返回，哪里就throw
     */
    public AgeIlegal() {
    }
    public AgeIlegal(String message) {
        super(message);
    }
}
