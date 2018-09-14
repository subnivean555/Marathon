package problems;

/**
输入描述: 　　输入包括多组数据。
　　每组数据仅有一个整数n (1≤n≤10000000)。

输出描述: 　　对于每组数据输入，输出一行，为1->n(包括n)之间的素数的个数。

 */

public class CountPrimeNumber {

    public static void main(String[] args) {
        System.out.println(guess(100000));
    }

    private static int guess(int n) {
        boolean[] mark = new boolean[n + 1];
        mark[0] = true;
        mark[1] = true;
        for (int i = 2; i < mark.length; i++) {
            if (!mark[i]) {
                for (int j = 2 * i; j < mark.length; j += i) {
                    mark[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < mark.length; i++) {
            if (!mark[i]) {
                count++;
            }
        }
        return count;
    }
}
