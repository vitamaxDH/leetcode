package top_150


/**
 * price
 *
 */
object _121_best_time_to_buy_and_sell_stock {
    fun maxProfit(prices: IntArray): Int {
        var maxIdx = 0
        var maxDiff = 0
        for (i in 1..prices.lastIndex) {
            val prev = prices[i - 1]
            val price = prices[i]
            if (prev > price) {
                continue
            }
            var idx = maxIdx
            while (idx < i) {
                val newDiff = price - prices[maxIdx]
                if (newDiff > maxDiff) {
                    maxDiff = newDiff
                    maxIdx = i
                }
                idx++
            }
        }
        return maxDiff
    }
}

fun main() {
    with(_121_best_time_to_buy_and_sell_stock) {
        println(maxProfit(intArrayOf(7,1,5,3,6,4)))
        println(maxProfit(intArrayOf(7,6,4,3,1)))
    }
}
