package leetcode.string;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 *  利用 java 自带的类型转换的解法
 */
public class Basic_ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseInteger(-123));
    }

    public static int reverseInteger(int x){
        char[] arr = new String(String.valueOf(x)).toCharArray();
        if (arr[0] == '-'){
            reverseArr(arr, 1 , arr.length - 1);
            arr[0] = '0';
            if (check(arr)){
                return Integer.valueOf(new String(arr)) * -1;
            } else{
                return 0;
            }
        } else {
            reverseArr(arr, 0 , arr.length -1);
            if (check(arr)){
                return Integer.valueOf(new String(arr));
            } else{
                return 0;
            }
        }
    }

    private static boolean check(char[] arr) {
        return Long.valueOf(new String(arr)) < 2147483647 && Long.valueOf(new String(arr)) > -2147483648;
    }

    private static void reverseArr(char[] arr, int begin, int end) {
        while(begin < end){
            char temp = arr[begin];
            arr[begin++] = arr[end];
            arr[end--] = temp;
        }
    }

}
