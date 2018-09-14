package leetcode.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Basic_isIsomorphic {

    /**
     *  ex : 30
     *  runtime : 14ms
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1)
            return true;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)){
                if (map.get(a).equals(b))
                    continue;
                else
                    return false;
            } else {
                if (!map.containsValue(b))
                    map.put(a, b);
                else
                    return false;
            }
        }
        return true;
    }

    public static boolean better(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        int[] map1 = new int[128];
        int[] map2 = new int[128];

        for (int i = 0; i < s.length(); i++){
            map1[s.charAt(i)] = i;
            map2[t.charAt(i)] = i;
        }

        System.out.println(Arrays.toString(map1));
        System.out.println(Arrays.toString(map2));


        for (int i = 0; i < s.length(); i++){
            if (map1[s.charAt(i)] != map2[t.charAt(i)]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(better("agg","edd"));
    }
}
