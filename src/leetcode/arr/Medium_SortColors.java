package leetcode.arr;

public class Medium_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int start = 0, last = nums.length - 1;

        for (int i = 0; i <= last; i++){
            if (nums[i] == 0){
                nums[start++] = 0;
            } else if (nums[i] == 2){
                swap(nums, i, last);
                last--;
                i--;
            }
        }

        while (start <= last){
            nums[start++] = 1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
