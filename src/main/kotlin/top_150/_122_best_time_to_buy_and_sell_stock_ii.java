package top_150;

public class _122_best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            if (min < curr) {
                int profit = curr - min;
                res += profit;
            }
            min = curr;
        }

        return res;
    }

    public static void main(String[] args) {
        var s = new _122_best_time_to_buy_and_sell_stock_ii();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
