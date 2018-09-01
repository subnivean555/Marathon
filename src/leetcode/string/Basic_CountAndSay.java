package leetcode.string;

/**
 *
 * 并不理解这道题目是什么意思.
 *
 */
public class Basic_CountAndSay {

    public String countAndSay(int n){
        if (n <= 0)
            return "-1";

        String result = "1";

        for (int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < result.length()){
                char val = result.charAt(index);

                int count = 0;

                while ((index < result.length()) && (result.charAt(index) == val)){
                    index++;
                    count++;
                }

                sb.append(String.valueOf(count));
                sb.append(val);
            }
            result = sb.toString();
        }
        return result;

    }
}
