package leetcode.arr;

import java.util.Arrays;

/**
 *  给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组
 */

public class Basic_PlusOne {

    public static void main(String[] args) {

        int[] arr = {9,9,9,};
        System.out.println(Arrays.toString(plusOne(arr)));

    }

    public static int[] plusOne(int[] digits) {

        int carry = 1;
        for (int len = digits.length - 1; len >=0; len--){
            if (carry == 0){
                return digits;
            }
            int tmp = digits[len] + carry;
            carry = tmp / 10;
            digits[len] = tmp % 10;
        }
        if (carry != 0){
            int[] arr = new int[digits.length + 1];
            for (int i = 1; i < arr.length; i++){
                arr[i] = digits[i-1];
            }
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}
