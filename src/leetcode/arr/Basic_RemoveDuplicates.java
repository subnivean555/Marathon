package leetcode.arr;

import java.util.Arrays;

/**
 * 从数组中删除重复项,不使用额外的空间, 使得每个元素只出现一次，返回移除后数组的新长度
 *
 * 思路 : 快慢指针
 */
public class Basic_RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        helper(nums, 3);
    }

    public static int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int i = 0, j = 0;

        for (; i < nums.length; i++){
            if (nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    /**
     *  leetcode 80 , 数组中一个元素最多出现两次
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0 && nums == null)
            return 0;

        int count = 0;
        int i = 0, j = nums.length - 1;

        while (i < j){
            if (i + 2 <= j && nums[i] == nums[i+2]){
                helper(nums, i+2);
                j--;
                count++;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    private static void helper(int[] arr, int index){
        int temp = arr[index];
        for (int i = index; i < arr.length - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = temp;
        System.out.println(Arrays.toString(arr));
    }

}
