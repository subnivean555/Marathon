package leetcode.search;

import java.util.HashMap;
import java.util.Map;

public class Basic_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length){
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++){
            char a = pattern.charAt(i);
            String b = strings[i];
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
}
