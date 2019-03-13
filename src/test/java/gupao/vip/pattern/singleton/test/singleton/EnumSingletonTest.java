package gupao.vip.pattern.singleton.test.singleton;

import gupao.vip.pattern.singleton.singleton.EnumSingleton;
import gupao.vip.pattern.singleton.test.ConcurrentExecutor;
import gupao.vip.pattern.singleton.test.lazy.LazyExectorThread;

import java.lang.reflect.Constructor;

public class EnumSingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new EnumExectorThread());
        Thread t2 = new Thread(new EnumExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");

        try{
            long start = System.currentTimeMillis();
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                public void handler() {
                    Object obj = EnumSingleton.getInstance();
                    System.out.println(System.currentTimeMillis() + ": " + obj);
                }
            }, 20,10);
            long end = System.currentTimeMillis();
            System.out.println("总耗时：" + (end - start) + " ms.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
