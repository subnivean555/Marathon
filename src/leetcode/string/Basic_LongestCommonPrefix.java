package leetcode.string;

public class Basic_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length ==0 || strs[0].length() == 0)
            return new String();
        if (strs.length == 1)
            return strs[0];

        int i = 0;

        while (i < strs[0].length()){
            for (int j = 1; j < strs.length; j++){
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }

        return strs[0];
    }

}
