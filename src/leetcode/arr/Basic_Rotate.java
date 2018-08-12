package leetcode.arr;

import java.util.Arrays;

/**
 * 将数组分为两部分进行旋转, 之后再将整个数组旋转即可
 */
public class Basic_Rotate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 0|| nums == null){
            return;
        }
        k = k % nums.length;
        int len = nums.length - 1;
        reverse(nums, 0, len - k);
        reverse(nums, len - k + 1, len);
        reverse(nums, 0, len);
    }
    public static void reverse(int[] arr , int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
