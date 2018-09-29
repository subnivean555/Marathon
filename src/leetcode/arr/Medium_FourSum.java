package leetcode.arr;

import java.util.HashMap;

public class Medium_FourSum {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : C){
            for (int j : D){
                int temp = i + j;
                if (map.containsKey(temp)){
                    int val = map.get(temp);
                    map.put(temp, val + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        for (int i : A){
            for (int j : B){
                int temp = 0 - i - j;
                if (map.containsKey(temp)){
                    res += map.get(temp);
                }
            }
        }

        return res;
    }
}
