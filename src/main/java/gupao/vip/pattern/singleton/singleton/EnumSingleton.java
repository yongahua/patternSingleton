package gupao.vip.pattern.singleton.singleton;

/**
 * 枚举式单例，绝对的线程安全，无法被反射和序列化破坏
 */
public enum EnumSingleton {
    INSTANCE;
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
