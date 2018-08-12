import java.util.Scanner;

/*
    计算 0 —— n 之间包含1的数字的个数
 */
public class CountSelectNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(countOne(n));
        }
        scanner.close();
    }

    private static int countOne(int num) {
        int countedN = 0;
        int result = 0;

        for (int i = 1, onesPerI = 0, cur; num != 0; onesPerI = onesPerI * 9 + i, i *= 10, num /= 10) {
            cur = num % 10;
            if (cur == 0) {
                continue;
            } else if (cur == 1) {
                result = onesPerI + countedN + 1;
            } else {
                result += (cur - 1) * onesPerI + i;
            }
            countedN += cur * i;
        }
        return result;
    }
}
