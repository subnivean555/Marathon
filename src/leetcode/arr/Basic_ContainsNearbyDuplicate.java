package leetcode.arr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Basic_ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0){
            return false;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() == k + 1)
                set.remove(nums[i - k]);
        }

        return false;
    }

}
