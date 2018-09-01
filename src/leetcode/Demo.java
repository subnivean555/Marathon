package leetcode;

import java.lang.reflect.Field;

/**
 *  只有不处于 -128---127 之间时可以使用, 否则会从 缓存中读数,
 *  而该位置缓存数会被修改为相同数字 所以不能交换, 而会输出两个相同的数
 */
public class Demo {

    public static void main(String[] args) {
        Integer a = 1000 , b = 2000;
        swap(a,b);
        System.out.println(a);
        System.out.println(b);
    }

    private static void swap(Integer num1, Integer num2){
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            Integer tmp = num1.intValue();
            field.set(num1, num2);
            System.out.println(tmp);
            field.set(num2, tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
