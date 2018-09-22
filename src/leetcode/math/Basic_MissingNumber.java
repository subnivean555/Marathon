package leetcode.math;

public class Basic_MissingNumber {

    public static int missingNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] < nums.length){
                temp = temp ^ (i);
                temp = temp ^ nums[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(missingNumber(arr));
    }

}
