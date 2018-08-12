package leetcode.arr;

/**
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *  0 和任和数 异或 等于任何数, 一个数和它本身 异或 的结果为 0
 *  因为所有元素都出现两次, 两次异或后为0 , 所以返回的结果即为只出现了一次的数
 */
public class Basic_SingleNumber {

    public static int singleNumber(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++){
            flag^=nums[i];
        }
        return flag;
    }
}
