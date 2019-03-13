package gupao.vip.pattern.singleton.test.threadlocal;

import gupao.vip.pattern.singleton.threadlocal.ThreadLocalSingleton;

public class ThreadLocalExectorThread implements Runnable{
    @Override
    public void run() {
        ThreadLocalSingleton singleton =  ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
