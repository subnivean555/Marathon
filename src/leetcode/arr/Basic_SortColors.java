package leetcode.arr;

import java.util.Arrays;

public class Basic_SortColors {

    public static void sortColors(int[] nums) {

        if (nums == null ||nums.length <= 1)
            return;

        if(nums.length < 3){
            for (int i = 1; i < nums.length; i++){
                for (int j = i; j > 0 && nums[j] > nums[j - 1]; j--){
                    swap(nums, j - 1 , j);
                }
            }
            return;
        }

        int begin = 0, current = 0, end = nums.length - 1;
        while (current <= end){
            if (nums[begin] == 2){
                swap(nums, current, end);
                end--;
            } else if (nums[current] == 1){
                current++;
            } else {
                if(begin != current && nums[current] > nums[begin]){
                    swap(nums, current, begin);
                }
                begin++;
                current++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
