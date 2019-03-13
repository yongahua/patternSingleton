package gupao.vip.pattern.singleton.hungry;

import com.gupaoedu.vip.pattern.singleton.seriable.SeriableSingleton;

/**
 * 阻止反序列化导致单例破坏
 */
import java.io.Serializable;

/**
 * 阻止序列化破坏单例
 */
public class HungrySeriableSingleton implements Serializable {
    public  final static HungrySeriableSingleton INSTANCE = new HungrySeriableSingleton();
    private HungrySeriableSingleton(){}

    public static HungrySeriableSingleton getInstance(){
        return INSTANCE;
    }

    private  Object readResolve(){
        return  INSTANCE;
    }
}
