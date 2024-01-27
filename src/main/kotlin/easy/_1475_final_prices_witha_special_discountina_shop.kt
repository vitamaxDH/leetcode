package easy

import java.util.Stack

class _1475_final_prices_witha_special_discountina_shop {
    fun finalPrices(prices: IntArray): IntArray {
        val stack = Stack<Int>()
        val result = IntArray(prices.size) { prices[it] }
        for (i in prices.indices) {
            while (stack.isNotEmpty() && prices[i] <= prices[stack.peek()]) {
                val prevIdx = stack.pop()
                result[prevIdx] = prices[prevIdx] - prices[i]
            }
            stack.push(i)
        }
        return result
    }
}
