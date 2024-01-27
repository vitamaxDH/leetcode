package medium

import java.util.Stack

class _739_daily_temperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = Stack<Int>()
        val result = IntArray(temperatures.size) { 0 }
        for (i in temperatures.indices) {
            while(stack.isNotEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val prev = stack.pop()
                result[prev] = i - prev
            }
            stack.push(i)
        }
        return result
    }
}
