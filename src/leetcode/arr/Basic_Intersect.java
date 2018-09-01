package leetcode.arr;

import java.util.Arrays;

/**
 *  给定两个数组，编写一个函数来计算它们的交集
 */
public class Basic_Intersect {

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,3};
        int[] arr2 = {2,2};
        int[] arr3 = intersect(arr1,arr2);

    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] elems = new int[Math.min(nums1.length, nums2.length)];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i =0 , j = 0, index = 0;
        while((i < nums1.length) && (j < nums2.length)){
            if (nums1[i] == nums2[j]){
                elems[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else{
                j++;
            }
        }
        return Arrays.copyOfRange(elems, 0, index);
    }
}
