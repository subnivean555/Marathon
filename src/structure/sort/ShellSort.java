package structure.sort;

public class ShellSort {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(100_0000, 0, 100_0000);
        //Integer[] arr = SortTestHelper.generateNearlyOrderedArray(10000, 20);
        Long begin = System.currentTimeMillis();
        sort(arr, arr.length);
        System.out.println("shell sort 执行的时间为 : " + (System.currentTimeMillis() - begin));

    }

    public static void sort(Comparable[] arr, int len){
        int h = 1;
        while (h < len / 3){
            h = 3 * h + 1;
        }
        while (h >= 1){
            for (int i = h; i < len; i++){
                for (int j = i; j >= h && SortTestHelper.less(arr[j], arr[j - h]); j -= h){
                    SortTestHelper.exch(arr, j, j-h);
                }
            }
            h /= 3;
        }
        assert SortTestHelper.isSorted(arr);
    }
}
