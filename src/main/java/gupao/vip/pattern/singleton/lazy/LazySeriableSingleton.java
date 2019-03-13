package gupao.vip.pattern.singleton.lazy;

import java.io.Serializable;

/**
 * 防止反序列化破坏
 */
public class LazySeriableSingleton implements Serializable {


    public static final LazySeriableSingleton getInstance(){
        return LazySeriableSingleton.LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazySeriableSingleton LAZY = new LazySeriableSingleton();
    }

    private  Object readResolve(){
        return  LazyHolder.LAZY;
    }
}
