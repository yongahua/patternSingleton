package gupao.vip.pattern.singleton.test.hungry;

import gupao.vip.pattern.singleton.hungry.HungrySeriableSingleton;

public class HungryExectorThread implements Runnable{
    @Override
    public void run() {
        //HungrySingleton singleton = HungrySingleton.getInstance();
        //HungryInnerClassSingleton singleton = HungryInnerClassSingleton.getInstance();
        HungrySeriableSingleton singleton = HungrySeriableSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
