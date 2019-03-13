package gupao.vip.pattern.singleton.test.singleton;

import gupao.vip.pattern.singleton.singleton.ContainerSingleton;

public class ContainerExectorThread implements Runnable{
    @Override
    public void run() {
        Object singleton = ContainerSingleton.getInstance("gupao.vip.pattern.singleton.test.Pojo");
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
