package leetcode.arr;

import java.util.Arrays;

public class Basic_ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1 ; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
