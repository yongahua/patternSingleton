package gupao.vip.pattern.singleton.innerClass;

public class Singleton {
    public static class Inner{
        static {
            System.out.println("TestInner Static!");
        }
        public final static Singleton testInstance = new Singleton(3);
    }

    public static Singleton getInstance(){
        return Inner.testInstance;
    }

    public Singleton(int i ) {
        System.out.println("Test " + i +" Construct! ");
    }

    //类静态属性
    public static Singleton testOut = Inner.testInstance;

    //类静态块
    static {
        System.out.println("Test Static");
    }


}
