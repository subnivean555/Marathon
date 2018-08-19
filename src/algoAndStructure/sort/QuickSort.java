package algoAndStructure.sort;

/**
 *  快速排序在数组接近有序时的效率和存在大量重复元素时的效率会非常低, 因为随机的 partition 会把数组分
 *  为极度不平衡的两部分,所以效率会非常低.
 *      对于 接近有序 的数组, 可以使用 对数组进行 shuffle, 或使用插入排序
 *      对于 存在大量重复元素的数组 , 可以使用 三路快排 来进行
 *
 *
 *  better sort 相对比较稳定, 存在大量重复元素时的性能也不会相差太多,
 *  当存在大量重复元素时, 快速排序的性能会下降非常多
 *  对于存在大量重复元素的数组而言, 使用 3路快排的性能最好,但 3路快排 不适合完全随机的数组
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(100000,0, 100000);
        Long begin = System.currentTimeMillis();
        sort(arr);
        System.out.println("quick sort 执行的时间为 : " + (System.currentTimeMillis() - begin));

        arr = SortTestHelper.generateRandomArray(100000,0, 100000);
        begin = System.currentTimeMillis();
        better_sort(arr);
        System.out.println("better quick sort 执行的时间为 : " + (System.currentTimeMillis() - begin));

        arr = SortTestHelper.generateRandomArray(100000, 0, 10);
        begin = System.currentTimeMillis();
        sort3Ways(arr);
        System.out.println("quick sort 3 ways 执行的时间为 : " + (System.currentTimeMillis() - begin));

    }

    public static void sort3Ways(Comparable[] arr){
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    private static void quickSort3Ways(Comparable[] arr, int lo, int hi) {
        if(hi <= lo){
            return;
        }
        Comparable temp = arr[lo];

        int lt = lo, gt = hi, i = lo + 1;
        while (i <= gt){
            int cmp = arr[i].compareTo(temp);
            if (cmp < 0){
                SortTestHelper.exch(arr, lt++, i++);
            }else if (cmp > 0){
                SortTestHelper.exch(arr, i, gt--);
            }else {
                i++;
            }
        }
        quickSort3Ways(arr, lo , lt-1);
        quickSort3Ways(arr, gt + 1, hi);
    }

    public static void sort(Comparable[] arr){
        quickSort(arr, 0, arr.length -1);
    }

    public static void better_sort(Comparable[] arr){
        better_quickSort(arr, 0, arr.length -1);
    }

    private static void quickSort(Comparable[] arr, int low, int high) {
        if (low >= high){
            return;
        }
        int p = partition(arr, low, high);
        quickSort(arr, low, p-1);
        quickSort(arr, p+1, high);
    }

    private static void better_quickSort(Comparable[] arr, int low, int high) {
        if (low >= high){
            return;
        }
        int p = better_partition(arr, low, high);
        better_quickSort(arr, low, p-1);
        better_quickSort(arr, p+1, high);
    }

    private static int partition(Comparable[] arr, int low, int high) {

        Comparable temp = arr[low];
        int j = low;
        for (int i = j + 1; i <= high; i++){
            if (SortTestHelper.less(arr[i], temp)){
                SortTestHelper.exch(arr, j+1, i);
                j++;
            }
        }
        SortTestHelper.exch(arr, low, j);
        return j;
    }

    /**
     *  设置两个临界点
     *      i 表示从 low + 1 ---- i 之间的元素 小于等于 temp
     *      j 表示从 j ---- hi 之间的元素 大于等于 temp
     *
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int better_partition(Comparable[] arr, int low, int high) {

        Comparable temp = arr[low];

        int i = low + 1, j = high;
        while (true){
            while (i <= high && SortTestHelper.less(arr[i], temp)){
                i++;
            }
            while(j >= low + 1 && SortTestHelper.less(temp, arr[j])){
                j--;
            }
            if (i > j)
                break;
            SortTestHelper.exch(arr, i, j);
            i++;
            j--;
        }
        SortTestHelper.exch(arr, low, j);
        return j;
    }


}
