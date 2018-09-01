package leetcode.string;

/**
 * 解决方案来自于 leetcode 官方,
 * 只是把循环定位第一个非空字符串改为了 trim()
 */
public class Basic_MyAtoi {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int sign = 1, base = 0, i = 0;

        if (str.charAt(i) == '-' || str.charAt(i) =='+')
            sign = str.charAt(i++) == '-' ? -1 : 1;

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){

            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)){
               return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

}
