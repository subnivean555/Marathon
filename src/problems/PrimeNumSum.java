package problems;/*
##题目描述 　　NowCoder发现某些整数可以拆分成两个不同的素数的和。例如7=2+5、20=3+17=7+13等。
　　他想知道每个正整数都有几种拆分的方法，你能帮他解决吗？

##输入描述: 　　输入包括多组数据。
　　每组数据仅有一个整数n (1≤n≤100000)。

##输出描述: 　　对应每个整数，输出其拆成不同素数和的个数，每个结果占一行。

 */

import java.util.Scanner;

public class PrimeNumSum {

    private final static int Num = 100_000 + 1;
    private final static int[] ANS = new int[Num];

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(ANS[n]);
        }
        scanner.close();
    }

    private static void init() {
        boolean[] mark = new boolean[Num];

        int[] primes = new int[Num];
        int count = 0;
        for (int i = 2; i < Num; i++) {
            if (!mark[i]) {
                primes[count] = i;
                count++;

                for (int j = 2 * i; j < Num; j += i) {
                    mark[j] = true;
                }
            }
        }

        int v;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                v = primes[i] + primes[j];
                if (v < Num) {
                    ANS[v]++;
                } else {
                    break;
                }
            }
        }
    }
}
