package gupao.vip.pattern.singleton.test.lazy;

import gupao.vip.pattern.singleton.hungry.HungrySingleton;
import gupao.vip.pattern.singleton.lazy.*;

public class LazyExectorThread implements Runnable{
    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        //LazySeriableSingleton singleton = LazySeriableSingleton.getInstance();
        //LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
        //LazySafetySimpleSingleton singleton =LazySafetySimpleSingleton.getInstance();
        //LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
