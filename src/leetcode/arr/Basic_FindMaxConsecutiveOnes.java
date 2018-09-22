package leetcode.arr;

import java.util.Arrays;

public class Basic_FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                count += 1;
            } else {
                if (count > max){
                    max = count;
                }
                count = 0;
            }
        }
        if (count > max)
            max = count;
        return max;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] * nums[1] > nums[nums.length-3] * nums[nums.length - 2]){
            return nums[0] * nums[1] * nums[nums.length - 1];
        } else {
            return nums[nums.length-1] * nums[nums.length - 2] * nums[nums.length - 3];
        }
    }

    public static void main(String[] args) {
        int nums[] = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
