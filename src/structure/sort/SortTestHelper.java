package structure.sort;

import java.util.Arrays;
import java.util.Random;

public class SortTestHelper {

    public static Integer[] generateNearlyOrderedArray(int len, int swapTimes){
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < swapTimes; i++){
            int j = rand.nextInt(len);
            int k = rand.nextInt(len);
            int temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static Integer[] generateRandomArray(int len, int left, int right){

        assert (right > left);

        Integer[] arr = new Integer[len];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < len; i++){
            arr[i] = random.nextInt() % (right - left + 1) + left;
        }
        return arr;
    }

    public static void print(Comparable[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isSorted(Comparable[] arr) {
        return isSorted(arr, 0, arr.length);
    }

    public static boolean isSorted(Comparable[] arr, int begin, int end) {
        for (int i = begin + 1; begin < end; i++){
            if (less(arr[i], arr[i - 1])){
                return false;
            }
        }
        return true;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
