package problems;
/*
 * 给定一个长度为2n的数组
 * {a1,a2,a3,...an,b1,b2,b3...,bn}
 * 设计一个算法使其成为
 * {a1,b1,a2,b2,a3,b3,......,an,bn}
 * 要求空间复杂度为   O(n) , 时间复杂度为 O(1)
 *
 * 对于 2*n = 3^k-1 这种长度的数组,恰好只有k个圈,且每个圈的起始位置分别是1,3,9
 *
 * 算法流程 :
 * 	1.找到 2 * m = 3^k -1 ,且3^k <= 2*n < 3^(k+1)
 * 	2.把 a[m+1,...,m+n]那部分循环右移m位
 * 	3.对每个 i=0,1,2..k-1, 3^i 是每个 圈的起始位置,做 cycle_leader算法
 * 		因为子数组长度为m,所以对2*m+1取模
 * 	4.对数组的剩余部分继续使用本算法
 *
 *  完美洗牌算法的结果会使数组变为
 *  {b1,a1,b2,a2,b3,a3,......,bn,an}
 *  故 在数组最前方加一位即可
 *
 */

import java.util.Arrays;

public class PerfectShuffle {

    public void shuffle(Comparable[] arr) {
        int arrLen = arr.length;
        int n = (arrLen - 1) / 2;
        int start = 0;

        while (n > 1) {
            int k = 0, m = 1;
            for (; (arrLen - 1) / m >= 3; k++, m = m * 3) {
            }
            m /= 2;

            rightRotate(arr, start, m, n);

            for (int i = 0, t = 1; i < k; i++, t = t * 3) {
                cycleLeader(arr, t, m * 2 + 1);
            }
            start = start + m * 2;
            n = n - m;
        }
        swap(arr, 1 + start, 2 + start);
        for (int i = 1; i < arrLen; i = i + 2) {
            swap(arr, i, i + 1);
        }
        return;
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void cycleLeader(Comparable[] arr, int start, int mod) {
        for (int i = start * 2 % mod; i != start; i = i * 2 % mod) {
            swap(arr, i, start);
        }
    }

    private void rightRotate(Comparable[] arr, int start, int m, int n) {
        reverse(arr, start + m + 1, start + n);
        reverse(arr, start + n + 1, start + n + m);
        reverse(arr, start + m + 1, start + n + m);
        return;
    }

    private void reverse(Comparable[] arr, int start, int end) {
        while (start < end) {
            Comparable temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        PerfectShuffle ps = new PerfectShuffle();
        Integer[] arr = {0, 2, 3, 4, 5, 6, 9};
        ps.shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }
}
