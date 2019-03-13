package gupao.vip.pattern.singleton.test.hungry;

import gupao.vip.pattern.singleton.hungry.HungryInnerClassSingleton;
import gupao.vip.pattern.singleton.hungry.HungrySeriableSingleton;
import gupao.vip.pattern.singleton.hungry.HungrySingleton;
import gupao.vip.pattern.singleton.test.ConcurrentExecutor;

public class HungrySingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new HungryExectorThread());
        Thread t2 = new Thread(new HungryExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");

        try{
            long start = System.currentTimeMillis();
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                public void handler() {
                    //Object obj = HungrySingleton.getInstance();
                    //Object obj = HungryInnerClassSingleton.getInstance();
                    Object obj = HungrySeriableSingleton.getInstance();
                    System.out.println(System.currentTimeMillis() + ": " + obj);
                }
            }, 10,10);
            long end = System.currentTimeMillis();
            System.out.println("总耗时：" + (end - start) + " ms.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
