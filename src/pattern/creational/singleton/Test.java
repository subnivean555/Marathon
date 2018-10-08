package pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {

        HungerySingleton instance = HungerySingleton.getInstance();

        /*Class clazz = HungerySingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungerySingleton newInstance = (HungerySingleton) constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);*/

        ObjectOutput oos = new ObjectOutputStream(new FileOutputStream("demo"));
        oos.writeObject(instance);

        File file = new File("demo");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungerySingleton newInstance = (HungerySingleton) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
