package gupao.vip.pattern.singleton.lazy;

/**
 * 存在线程安全
 */
public class LazySimpleSingleton {
    private LazySimpleSingleton(){}

    private static LazySimpleSingleton lazy = null;

    public static LazySimpleSingleton getInstance(){
        if(lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
