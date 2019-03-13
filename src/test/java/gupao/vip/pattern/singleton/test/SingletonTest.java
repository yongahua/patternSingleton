package gupao.vip.pattern.singleton.test;

import gupao.vip.pattern.singleton.innerClass.Singleton;

public class SingletonTest {
    public static void main(String args[]){
        Singleton t = new Singleton(2);
        Singleton.getInstance();
    }
}
