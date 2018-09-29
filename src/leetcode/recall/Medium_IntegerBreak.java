package leetcode.recall;

public class Medium_IntegerBreak {

    public static int integerBreak(int n) {
        int[] mem = new int[n + 1];
        return result(n, mem);
    }

    private static int result(int n, int[] mem) {
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i - 1; j++){
                int temp = Math.max(mem[i], j * (i - j));
                mem[i] = Math.max(temp, j * mem[i - j]);
            }
        }
        return mem[n];
    }
    /*private static int result(int n , int[] mem){
        if (n == 1)
            return 1;
        if (mem[n] != -1)
            return mem[n];
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            int temp = Math.max(res, i * (n - i));
            res = Math.max(temp, i * integerBreak(n - i));
        }
        mem[n] = res;
        return res;
    }*/


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(integerBreak(50));
        System.out.println(System.currentTimeMillis() - start);
    }
}
