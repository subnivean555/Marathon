package problems;

import java.math.BigInteger;
import java.util.Scanner;

public class PrintTrangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            System.out.println(trangle(num));
        }
        scanner.close();
    }

    private static String trangle(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("参数必须是正整数");
        }
        BigInteger[] t = new BigInteger[n * (n + 1) / 2];
        StringBuilder b = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int idx = (i - 1) * i / 2 + j - 1;
                if (j == 1 || i == j) {
                    t[idx] = BigInteger.ONE;
                } else {
                    int x = (i - 2) * (i - 1) / 2 + j - 1;
                    int y = (i - 2) * (i - 1) / 2 + j - 2;
                    t[idx] = t[x].add(t[y]);
                }
                b.append(t[idx].toString()).append(' ');
            }
            b.setCharAt(b.length() - 1, '\n');
        }
        return b.toString();
    }
}
