package gupao.vip.pattern.singleton.test.singleton;

import gupao.vip.pattern.singleton.singleton.EnumSingleton;

import java.lang.reflect.Constructor;

public class EnumInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = EnumSingleton.class;
            //java.lang.NoSuchMethodException找不到构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o1 = c.newInstance();

            System.out.println(o1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
