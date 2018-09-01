package leetcode.string;

public class Basic_IsPalindrome {

    public static void main(String[] args) {
        String sb = new String("race a car");
        System.out.println(isPalindrome(sb));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1){
            return true;
        }
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++){
            if ((arr[i] > ('a'-1)&& arr[i] < ('z'+1))||(arr[i] > ('0'-1) && arr[i] <('9'+1))){
                sb.append(arr[i]);
            }
        }
        String sbb = sb.toString();
        System.out.println(sbb);
        String sbt = sb.reverse().toString();
        if (sbb.equals(sbt)){
            return true;
        }
        return false;
    }
}
