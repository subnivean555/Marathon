package leetcode.arr;

/**
 * 从数组中删除重复项,不使用额外的空间, 使得每个元素只出现一次，返回移除后数组的新长度
 *
 * 思路 : 快慢指针
 */
public class Basic_RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
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
}
