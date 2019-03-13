package gupao.vip.pattern.singleton.test.lazy;

import gupao.vip.pattern.singleton.lazy.LazyDoubleCheckSingleton;
import gupao.vip.pattern.singleton.lazy.LazySafetySimpleSingleton;
import gupao.vip.pattern.singleton.lazy.LazySeriableSingleton;
import gupao.vip.pattern.singleton.lazy.LazySimpleSingleton;
import gupao.vip.pattern.singleton.test.ConcurrentExecutor;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new LazyExectorThread());
        Thread t2 = new Thread(new LazyExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");

        try{
            long start = System.currentTimeMillis();
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                public void handler() {
                    //存在线程安全
                    Object obj = LazySimpleSingleton.getInstance();

                    //Object obj = LazySeriableSingleton.getInstance();
                    //没有线程安全但是性能较差
                    //Object obj = LazySafetySimpleSingleton.getInstance();
                    //与上一个相比，用双重锁性能较好
                    //Object obj = LazyDoubleCheckSingleton.getInstance();
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
