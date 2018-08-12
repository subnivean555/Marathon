package leetcode.arr;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 *
 *
 */
public class Basic_MaxProfit {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4,};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i - 1] < prices[i]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
