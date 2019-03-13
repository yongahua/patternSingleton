package gupao.vip.pattern.singleton.test.hungry;

import gupao.vip.pattern.singleton.hungry.HungryInnerClassSingleton;

import java.lang.reflect.Constructor;

public class HungryInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = HungryInnerClassSingleton.class;
            //通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问，强吻，不愿意也要吻
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();

            //调用了两次构造方法，相当于new了两次
            //犯了原则性问题，
            Object o2 = c.newInstance();
            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o1 == o2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
