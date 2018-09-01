package leetcode.string;

public class Basic_IsAnagram {

    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t){
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int i;
        int[] comp = new int[26];

        for (i = 0 ; i < sarr.length; i++){
            comp[sarr[i] - 'a']++;
        }

        for (i = 0; i < tarr.length; i++){
            comp[tarr[i] - 'a']-=1;
        }
        i = 0;
        while (i < 26){
            if(comp[i] != 0){
                return false;
            }
            i++;
        }
        return true;
    }

}
