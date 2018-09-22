package leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class Basic_RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0, lastVal = 0;
        for (int i = 0; i < s.length(); i++){
            int val = map.get(s.charAt(i));
            if (val > lastVal){
                sum = sum - 2 * lastVal + val;
            } else {
                sum += val;
            }
            lastVal = val;
        }
        return sum;
    }
}
