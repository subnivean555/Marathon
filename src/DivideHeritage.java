import java.util.Scanner;

/*
##输入描述: 　　输入包括多组测试数据。
　　每组测试数据包括两行：
　　第一行为m、n，分别代表老人拥有的马匹数和几个儿子。
　　第二行有n个数据a1、a2、...、an，依次代表大儿子、二儿子...第n个儿子分到的遗产的份额。(0 < ai < 50)
　　程序以输入0 0结束，该行不做处理。

##输出描述: 　　按照上面介绍的方法解决这个问题。
　　如果那种方法不能解决这个问题(即所有儿子不能得到整数匹马)，则你的程序要输出"Can't Solve"；
　　否者依次输出大儿子、二儿子...得到的马的匹数。
　　每个数之间有一个空格隔开(最后一个数据后面没有空格)。
 */
public class DivideHeritage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains("0 0")) {
                break;
            }

            String[] parts = line.split("(\\s)+");

            long hours = Long.parseLong(parts[0]);

            int num = Integer.parseInt(parts[1]);

            line = scanner.nextLine();
            parts = line.split("(\\s)+");

            int[] arr = new int[parts.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            System.out.println(heritage(hours, arr));
        }
        scanner.close();
    }

    private static String heritage(long hours, int[] arr) {

        long v = arr[0];
        for (int i = 1; i < arr.length; i++) {
            v = lcm(v, arr[i]);
        }

        long sum;
        long[] result = new long[arr.length];
        for (int times = 1; ; times++) {
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                result[i] = times * v / arr[i];
                sum += result[i];
            }
            if (sum >= hours) {
                break;
            }
        }

        if (sum != hours) {
            return "can't solve";
        } else {
            StringBuilder sb = new StringBuilder();
            for (long i : result) {
                sb.append(i).append(' ');
            }
            return sb.substring(0, sb.length() - 1);
        }
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        long t;
        while ((t = a % b) != 0) {
            a = b;
            b = t;
        }
        return b;
    }
}
