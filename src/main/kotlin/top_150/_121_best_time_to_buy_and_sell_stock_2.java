package top_150;

public class _121_best_time_to_buy_and_sell_stock_2 {
    public int maxProfit(int[] prices) {
        var res = 0;
        var min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            var curr = prices[i];
            if (curr < min) {
                min = curr;
            } else if (curr > min) {
                res = Math.max(res, curr - min);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _121_best_time_to_buy_and_sell_stock_2();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));
    }
}
