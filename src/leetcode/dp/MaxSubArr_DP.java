package leetcode.dp;

import java.util.Arrays;

public class MaxSubArr_DP {

    public static int findMaxSubArr(int[] arr) {
        int start = 0, end = 0;
        int maxSum;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        maxSum = dp[0];
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = arr[i];
                temp = i;
            } else {
                dp[i] = arr[i] + dp[i - 1];
            }
            if (dp[i] > maxSum) {
                maxSum = dp[i];
                start = temp;
                end = i;
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println("最大子序列的下标 : " + start + "---" + end);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(findMaxSubArr(arr));
    }
}
