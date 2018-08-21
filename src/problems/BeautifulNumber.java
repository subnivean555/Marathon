package problems;

/**
 * 如果一个数可以写为 111 的形式, 那么就认为这个数时 beautiful 的,
 * 请你判断一个将一个数转换为, 111 格式的进制,
 *
 *  输入一个整数.
 *  输出将其转换为 111 位数最长的进制
 *
 *
 */

public class BeautifulNumber {

    private static int beautifulSmallData(int n){
        for (int radix = 2; radix < n; radix++){
            if (isBeautiful(n, radix)){
                return radix;
            }
        }
        return n - 1;
    }

    private static boolean isBeautiful(int n, int radix) {
        while (n > 0){
            if (n % radix != 1){
                return false;
            }
            n /= radix;
        }
        return true;
    }

    private static long beautifulLargeData(long n){
        for (int bits = 64; bits >= 2; bits--){
            long radix = getRadix(n, bits);
            if (radix != -1){
                return radix;
            }
        }
        return n - 1;
    }

    private static long getRadix(long n, int bits) {
        long minRadix = 2, maxRadix = n;

        while (minRadix < maxRadix){
            long m = minRadix + (maxRadix - minRadix) / 2;
            long t = convert(m , bits);
            if (t == n){
                return m;
            } else if (t < n){
                minRadix = m + 1;
            } else if (t > n){
                maxRadix = m;
            }
        }

        return -1;
    }

    private static long convert(long radix, int bits){
        long component = 1, sum = 0;

        for (int i = 0; i < bits; i++){
            if (Long.MAX_VALUE - sum < component){
                return Long.MAX_VALUE;
            } else {
                sum += component;
            }

            if (Long.MAX_VALUE / component < radix){
                component = Long.MAX_VALUE;
            } else {
                component *= radix;
            }
        }
        return sum;
    }
}
