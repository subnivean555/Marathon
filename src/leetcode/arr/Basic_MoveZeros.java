package leetcode.arr;

/**
 *  给定一个数组, 编写一个函数将所有的 0 移动到数组的末尾
 */
public class Basic_MoveZeros {

    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0 ; i < nums.length; i++){
            if (nums[j] != 0){
                j++;
            } else if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

}
