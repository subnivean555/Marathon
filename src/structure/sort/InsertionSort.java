package structure.sort;

/**
 * 插入排序由于内循环可能会提前终止, 所以一般效率会比 选择排序 效率高
 *
 * 但是实际上未经优化的 插入排序 会进行多次交换, 所以降低排序效率
 *
 * 在数组接近有序时, 插入排序的效率可能比 高级排序算法的效率还高
 */
public class InsertionSort {

    public static void main(String[] args) {

        //Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000);
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(10000, 20);
        Long begin = System.currentTimeMillis();
        better_sort(arr);
        System.out.println("insertion sort 执行的时间为 : " + (System.currentTimeMillis() - begin));
    }

    private static void sort(Comparable[] arr){

        for (int i = 1; i < arr.length; i++){
            for (int j = i; j > 0 && SortTestHelper.less(arr[j], arr[j - 1]); j--){
                SortTestHelper.exch(arr, j, j - 1);
            }
        }

        assert SortTestHelper.isSorted(arr);
    }

    public static void better_sort(Comparable[] arr){

        for (int i = 1; i < arr.length; i++){
            int j;
            Comparable temp = arr[i];
            for(j=i-1; j>=0 && SortTestHelper.less(temp, arr[j]); j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }

       assert SortTestHelper.isSorted(arr);
    }
}
