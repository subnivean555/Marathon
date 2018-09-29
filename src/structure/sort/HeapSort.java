package structure.sort;

import structure.heap.MaxPriorityQueue;

/**
 * 建堆的过程中并不会对数组进行完全排序, 只有输出其 最大/小 值的过程才是对其的排序.
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(100_0000, 0 , 100_0000);
        Long begin = System.currentTimeMillis();
        heapsort(arr);
        System.out.println("heap sort 执行的时间为 : " + (System.currentTimeMillis() - begin));

    }

    private static void sort(Integer[] arr){
        MaxPriorityQueue<Integer> maxHeap = new MaxPriorityQueue<>(arr.length);
        for (int i = 0; i < arr.length; i++){
            maxHeap.insert(arr[i]);
        }
    }

    private static void heapsort(Integer[] arr){
        for (int i = (arr.length - 1)/2; i >= 0; i--){
            shiftDown(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--){
            swap(arr,0, i);
            shiftDown(arr, i, 0);
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void shiftDown(Integer[] arr, int len, int k) {
        while (2 * k + 1 < len){
            int j = 2 * k + 1;
            if (j + 1 < len && arr[j+1] > arr[j]){
                j += 1;
            }
            if (arr[k] >= arr[j]){
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }
}
