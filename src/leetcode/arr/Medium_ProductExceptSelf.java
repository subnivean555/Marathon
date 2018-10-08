package leetcode.arr;

import structure.arr.Array;

import java.util.Arrays;

public class Medium_ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] pres = new int[nums.length];
        int[] after = new int[nums.length];
        int[] res = new int[nums.length];
        pres[0] = nums[0];
        after[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++){
            pres[i] = pres[i - 1] * nums[i];
        }
        System.out.println(Arrays.toString(pres));
        for (int i = nums.length - 2; i >= 0; i--){
            after[i] = after[i + 1] * nums[i];
        }
        System.out.println(Arrays.toString(after));

        res[0] = after[1];
        res[nums.length - 1] = pres[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++){
            res[i] = pres[i - 1] * after[i + 1];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public int[] productExceptSelf_better(int[] nums){
        if (nums == null || nums.length == 0)
            return nums;

        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for(int i=1; i<len; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        int temp = 1;
        for(int i=len-1; i>=0; i--) {
            res[i] = res[i] * temp;
            temp = temp * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Medium_ProductExceptSelf demo = new Medium_ProductExceptSelf();
        int[] arr = {4,3,2,1,2};
        System.out.println(Arrays.toString(demo.productExceptSelf_better(arr)));

    }

}
