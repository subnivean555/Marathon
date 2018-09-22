package leetcode.dp;

public class Basic_ClimbStairs {

    public int climbStairs(int n) {
        int prev = 0, next = 1, result = 0;
        for (int i = 0; i < n; i++){
            result = prev + next;
            prev = next;
            next = result;
        }
        return result;
    }
}
