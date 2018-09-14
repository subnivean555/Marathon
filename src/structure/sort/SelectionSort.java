package structure.sort;

/**
 *   编码简单,易于实现,是一些简单情景的首选
 *   在一些特殊的情况下, 简单的排序算法更有效.
 *
 *   选择排序
 *
 */
public class SelectionSort{

    public static void main(String[] args) {

        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000);
        //Integer[] arr = SortTestHelper.generateNearlyOrderedArray(10000, 20);
        Long begin = System.currentTimeMillis();
        sort(arr, arr.length);
        System.out.println("select sort 执行的时间为 : " + (System.currentTimeMillis() - begin));

    }

    public static void sort(Comparable[] arr, int len){
        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = i + 1; j < len; j++){
                if (SortTestHelper.less(arr[j], arr[min])){
                    min = j;
                }
            }
            SortTestHelper.exch(arr, i, min);
            assert SortTestHelper.isSorted(arr, 0, i);
        }
        assert SortTestHelper.isSorted(arr);
    }


}
