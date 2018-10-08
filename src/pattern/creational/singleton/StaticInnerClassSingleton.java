package pattern.creational.singleton;


/**
 *  使用静态内部类避免指令重排序问题
 */
public class StaticInnerClassSingleton {

    private static class InnerClass{
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton(){

    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }

    private Object readResolve(){
        return getInstance();
    }
}
