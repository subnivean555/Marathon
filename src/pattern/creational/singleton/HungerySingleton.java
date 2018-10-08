package pattern.creational.singleton;

import java.io.Serializable;

public class HungerySingleton implements Serializable, Cloneable {

    private final static HungerySingleton instance = new HungerySingleton();

    private HungerySingleton(){
        if (instance != null){
            throw new RuntimeException("单例对象不能被反射获取");
        }
    }

    public static HungerySingleton getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }
}
