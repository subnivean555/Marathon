package algoAndStructure.sort;

/**
 *  归并排序 时间复杂度为 n * logn
 *
 *  自底向上的归并排序, 对 归并排序 进行了优化 , 由于不适用数组的下标获取元素, 所以可以对链表进行排序
 *
 *  归并排序优化 :
 *      当 arr[mid] < arr[mid+1] 时, 即可不用再对其排序
 *      当 right - left 足够小时, 可以调用 InsertSort 来进行排序
 */
public class MergeSort {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(100_0000, 0, 100_0000);
        //Integer[] arr = SortTestHelper.generateNearlyOrderedArray(10000, 20);
        Long begin = System.currentTimeMillis();
        sortBU(arr);
        System.out.println("merge sort 执行的时间为 : " + (System.currentTimeMillis() - begin));

        arr = SortTestHelper.generateRandomArray(10_0000, 0, 10_0000);

        begin = System.currentTimeMillis();
        sortBU(arr);
        System.out.println("mergeBU sort 执行的时间为 : " + (System.currentTimeMillis() - begin));
        SortTestHelper.print(arr);
    }

    public static void sortBU(Comparable[] arr){
        int len = arr.length;
        Comparable[] aux = new Comparable[len];

        for (int i = 1; i < len; i = i + i){
            for (int j = 0; j < len - i; j += i + i){
                merge(arr, aux, j, j + i - 1, Math.min(j + i + i - 1, len - 1));
            }
        }
    }

    public static void sort(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
        assert SortTestHelper.isSorted(arr);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++){
            aux[k] = arr[k];
        }
        int i = low, j = mid + 1;
        for (int k = low ; k <= high; k++){
            if (i > mid){
                arr[k] = aux[j++];
            } else if (j > high){
                arr[k] = aux[i++];
            } else if (SortTestHelper.less(aux[j], aux[i])){
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
        assert SortTestHelper.isSorted(arr, low, high);
    }
}
