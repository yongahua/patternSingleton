package gupao.vip.pattern.singleton.test.singleton;

import gupao.vip.pattern.singleton.singleton.ContainerSingleton;
import gupao.vip.pattern.singleton.test.ConcurrentExecutor;

public class ContainerSingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ContainerExectorThread());
        Thread t2 = new Thread(new ContainerExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");

        try {
            long start = System.currentTimeMillis();
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                public void handler() {
                    Object obj = ContainerSingleton.getInstance("gupao.vip.pattern.singleton.test.Pojo");
                    System.out.println(System.currentTimeMillis() + ": " + obj);
                }
            }, 10,6);
            long end = System.currentTimeMillis();
            System.out.println("总耗时：" + (end - start) + " ms.");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
