package gupao.vip.pattern.singleton.test.singleton;

import gupao.vip.pattern.singleton.lazy.LazySimpleSingleton;
import gupao.vip.pattern.singleton.singleton.EnumSingleton;

public class EnumExectorThread implements Runnable{
    @Override
    public void run() {
        EnumSingleton singleton =  EnumSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
