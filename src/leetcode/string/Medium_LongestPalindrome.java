package leetcode.string;

public class Medium_LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        String temp = "$#";
        for (char ch : s.toCharArray()){
            temp += ch+"#";
        }

        int[] radius = new int[temp.length()];
        int maxRight = 0, maxRightmid = 0, maxLen = 0, resCen = 0;

        for (int curPos = 1; curPos < temp.length(); curPos++){
            if (curPos < maxRight){
                radius[curPos] = Math.min(radius[2 * maxRight - curPos], maxRight - curPos);
            } else {
                radius[curPos]++;
            }

            while (curPos - radius[curPos] >= 0 && radius[curPos] + curPos < temp.length() &&
                    temp.charAt(curPos + radius[curPos]) == temp.charAt(curPos - radius[curPos])){
                radius[curPos]++;
            }


        }
        return s.substring((resCen - maxLen) / 2, (resCen - maxLen) / 2 + maxLen - 1);
    }

}
