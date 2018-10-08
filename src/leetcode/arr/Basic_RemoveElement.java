package leetcode.arr;

import java.util.Arrays;

public class Basic_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0 && nums == null)
            return 0;

        int count = 0;
        int i = 0, j = nums.length - 1;

        while (i < j){
            if (nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                count++;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    public static int removeElement2(int[] nums, int val) {
        if (nums != null && nums.length != 0){
            int j = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] != val){
                    nums[j++] = nums[i];
                }
            }
            System.out.println(Arrays.toString(nums));
            return j;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {0,4,0,4,2,3,64,7,1,4,1};
        System.out.println(removeElement2(arr, 4));
    }
}
