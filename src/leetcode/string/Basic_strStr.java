package leetcode.string;

public class Basic_strStr {

    public static int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        int i = 0;
        int p = 0;
        int q = 0;
        int hayl = hay.length;
        int neel = nee.length;

        while(i<hayl){
            p = 0 + i;
            q = 0;
            while(p < hayl && q < neel){
                if(hay[p] == nee[q]){
                    if(q == neel-1)
                        return p - neel +1;
                }else {
                    break;
                }
                p++;
                q++;
            }
            i++;

        }

        return -1;
    }

}
