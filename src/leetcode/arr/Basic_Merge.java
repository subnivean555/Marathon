package leetcode.arr;

import java.util.Arrays;

public class Basic_Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int len = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0){
            nums1[len--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0){
            nums1[len--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);
    }

}
