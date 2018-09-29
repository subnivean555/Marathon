package leetcode.arr;

import structure.arr.Array;

import java.util.Arrays;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class Basic_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        if (nums.length == 0 && nums ==null){
            return arr;
        }
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (target == nums[i] + nums[j]){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}
