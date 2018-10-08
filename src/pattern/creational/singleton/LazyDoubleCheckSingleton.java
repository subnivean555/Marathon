package pattern.creational.singleton;

public class LazyDoubleCheckSingleton {

    private static volatile LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton(){  }

    public static LazyDoubleCheckSingleton getInstacne(){
        if (lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }

    private Object readResolve(){
        return lazyDoubleCheckSingleton;
    }
}
