package leetcode.search;

/**
 * leetcode 303
 */
public class Basic_NumArray {

    private int[] sum;

    public Basic_NumArray(int[] nums){
       sum = new int[nums.length + 1];
       sum[0] = 0;
       for (int i = 1; i < sum.length; i++)
           sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int i, int j){
        return sum[j + 1] - sum[i];
    }
}
