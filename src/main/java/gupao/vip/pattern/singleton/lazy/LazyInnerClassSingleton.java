package gupao.vip.pattern.singleton.lazy;

import java.io.Serializable;


public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){
        /**
         * 防止反射破坏
         */
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}
