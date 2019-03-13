package gupao.vip.pattern.singleton.test.threadlocal;

import gupao.vip.pattern.singleton.threadlocal.ThreadLocalSingleton;

public class ThreadLocalSingletonTest {
    public static void main(String[] args) {

        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ThreadLocalExectorThread());
        Thread t2 = new Thread(new ThreadLocalExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");

    }
}
