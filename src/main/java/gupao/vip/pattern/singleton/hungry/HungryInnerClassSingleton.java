package gupao.vip.pattern.singleton.hungry;

/**
 * 阻止反射破坏单例
 */
public class HungryInnerClassSingleton {
    private static HungryInnerClassSingleton hungrySingleton = new HungryInnerClassSingleton();

    private HungryInnerClassSingleton() {
        if(hungrySingleton !=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static HungryInnerClassSingleton getInstance() {

        return hungrySingleton;
    }
}
