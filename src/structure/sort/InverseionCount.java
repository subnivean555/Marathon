package structure.sort;

import java.util.Arrays;

public class InverseionCount {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000);

        System.out.println("数组中的逆序对有 : " + inverseCount(arr));

    }

    public static long inverseCount(Comparable[] arr) {
        int len = arr.length;
        return count(arr, 0, len - 1);
    }

    private static long count(Comparable[] arr, int begin, int end) {
        if (end <= begin){
            return 0L;
        }

        int mid = begin + (end - begin) / 2;
        long res1 = count(arr, begin, mid);
        long res2 = count(arr, mid+1, end);

        return res1 + res2 + merge(arr, begin, mid, end);
    }

    private static long merge(Comparable[] arr, int begin, int mid, int end) {

        Comparable[] aux = Arrays.copyOfRange(arr, begin, end+1);

        // 初始化逆序数对个数 res = 0
        long res = 0L;
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = begin, j = mid+1;
        for( int k = begin ; k <= end; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - begin];
                j++;
            }
            else if( j > end ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - begin];
                i ++;
            }
            else if( aux[i - begin].compareTo(aux[j - begin]) <= 0 ){  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i - begin];
                i ++;
            }
            else{   // 右半部分所指元素 < 左半部分所指元素
                arr[k] = aux[j - begin];
                j ++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                res += mid - i + 1;
            }
        }

        return res;
    }

}
