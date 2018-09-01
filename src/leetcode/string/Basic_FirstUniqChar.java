package leetcode.string;

/**
 *  给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class Basic_FirstUniqChar {


    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s.length() == 1){
            return 0;
        }
        int flags[] = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            flags[arr[i]-'a']++;
        }

        for (int i = 0; i < arr.length; i++){
            if (flags[arr[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }

}
