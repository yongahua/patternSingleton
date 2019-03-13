单例模式有 ：饿汉式单例模式，懒汉式单例模式，注册式单例模式
    1.饿汉式单例：
        描述：在单例类首次加载时就创建实例，不管你用不用，（以空间换时间），这是绝对的线程安全；
        优点：没有加载任何锁执行效率高，线程安全；
        缺点：占用了空间。

    2.懒汉式单例：
        描述：被外部类调用时才创建实例延迟初始化，但是它是线程不安全的，需要在方法用 synchronized 加锁或用内部类，才能解决线程安全问题；
        优点：避免了饿汉式的那种在没有用到的情况下创建事例，资源利用率高；
        缺点：是线程不安全的，若加上synchronized锁，但是这样第一次加载时不够快，多线程使用不必要的同步开销大。

        解决线程不安全问题

        2.1方法内部双重检测
            public class LazyDoubleCheckSingleton {
                private volatile static LazyDoubleCheckSingleton lazy = null;

                private LazyDoubleCheckSingleton(){}

                public static LazyDoubleCheckSingleton getInstance(){
                    if(lazy == null){
                        synchronized (LazyDoubleCheckSingleton.class){
                            if(lazy == null){
                                lazy = new LazyDoubleCheckSingleton();
                            }
                        }
                    }
                    return lazy;
                }
            }
            但是还是加有synchronized锁，多少还是会影响执行效率；

        2.2静态内部类
            public class LazyInnerClassSingleton {

                private LazyInnerClassSingleton(){}

                public static final LazyInnerClassSingleton getInstance(){
                    return LazyHolder.LAZY;
                }

                private static class LazyHolder{
                    private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
                }

            }
        结合了饿汉式和懒汉式的优点 高资源利用率、高执行效率；

    3.注册式单例：
        介绍：将每一个实例都缓存到统一的容器中，使用唯一标识获取实例 相对于其他单例来说枚举写法最简单，并且任何情况下都是单例的；
        优点：线程安全；

        枚举式单例：无法被反射和序列化破坏；
        容器缓存：适用于创建实例非常多的情况，便于管理。但是，是非线程安全的。

    4.ThreadLocal 线程单例 （也是一种注册式单例）
        介绍：ThreadLocal 不能保证其创建的对象是全局唯一，但是能保证在单个线程中是唯一的即在单个线程中是安全的。


    类的执行顺序是 静态属性（或类静态块 谁写在前面先执行谁）方法和内部类调用谁就执行谁， 内部类中的执行顺序遵循类的执行方法
