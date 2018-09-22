package leetcode.dp;

/*
分治法实现最大子数组和问题
 */
public class MaxCrossSubArr {

    private final static int infinate = -10000;

    private static int findMaxCrossSubArray(int[] arr, int low, int mid, int hi) {
        int left_sum = infinate;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        }

        int right_sum = infinate;
        sum = 0;
        for (int i = mid + 1; i <= hi; i++) {
            sum += arr[i];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }
        return left_sum + right_sum;
    }

    public static int findMaxSubArr(int[] arr, int low, int hi) {

        int left_sum, right_sum, cross_sum;
        if (hi == low)
            return arr[low];
        else {
            int mid = (low + hi) / 2;
            left_sum = findMaxSubArr(arr, low, mid);
            right_sum = findMaxSubArr(arr, mid + 1, hi);
            cross_sum = findMaxCrossSubArray(arr, low, mid, hi);
            if (left_sum >= right_sum && left_sum >= cross_sum)
                return left_sum;
            else if (right_sum >= left_sum && right_sum >= cross_sum)
                return right_sum;
            else
                return cross_sum;
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int temp = findMaxSubArr(arr, 0, arr.length - 1);
        System.out.println(temp);
    }

}
