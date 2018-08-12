import java.util.Scanner;

/*
题目描述 　　老猴子辛苦了一辈子，给那群小猴子们留下了一笔巨大的财富——一大堆桃子。老猴子决定把这些桃子分给小猴子。
　　第一个猴子来了，它把桃子分成五堆，五堆一样多，但还多出一个。它把剩下的一个留给老猴子，自己拿走其中的一堆。
　　第二个猴子来了，它把桃子分成五堆，五堆一样多，但又多出一个。它把多出的一个留给老猴子，自己拿走其中的一堆。 　　后来的小猴子都如此照办。最后剩下的桃子全部留给老猴子。 　　这里有n只小猴子，请你写个程序计算一下在开始时至少有多少个桃子，以及最后老猴子最少能得到几个桃子。

##输入描述: 　　输入包括多组测试数据。
　　每组测试数据包括一个整数n(1≤n≤20)。
　　输入以0结束，该行不做处理。

##输出描述: 　　每组测试数据对应一行输出。
　　包括两个整数a，b。
　　分别代表开始时最小需要的桃子数，和结束后老猴子最少能得到的桃子数。

    设有x个桃子，则a1 = （x-1）/5 ，a2 = （4a1-1）/5 , a3 = 4(a2-1)/5
        an = (4/5)^(n-1) * (a1 + 1 )
        x = 5^n - 4
 */

public class DividePeach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            long[] r = peach(n);
            System.out.println(r[0] + "  " + r[1]);
        }
        scanner.close();
    }

    private static long[] peach(int n) {
        long power5 = 1;
        long power4 = 1;
        for (int i = 0; i < n; i++) {
            power4 *= 4;
            power5 *= 5;
        }
        return new long[]{power5 - 4, power4 + n - 4};
    }
}
