package gupao.vip.pattern.singleton.hungry;

public class HungryStaticSingleton {
    private static HungryStaticSingleton hungrySingleton;
    static {
           hungrySingleton = new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){}
    public static HungryStaticSingleton getInstance(){
        return  hungrySingleton;
    }
    private  Object readResolve(){
        return  hungrySingleton;
    }
}
