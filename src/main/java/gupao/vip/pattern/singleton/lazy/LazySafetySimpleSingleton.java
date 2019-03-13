package gupao.vip.pattern.singleton.lazy;

/**
 * 没有线程安全但是性能较差
 */
public class LazySafetySimpleSingleton {
    private LazySafetySimpleSingleton(){}

    private static LazySafetySimpleSingleton lazy = null;

    public synchronized static LazySafetySimpleSingleton getInstance(){
        if(lazy == null){
            lazy = new LazySafetySimpleSingleton();
        }
        return lazy;
    }
}
