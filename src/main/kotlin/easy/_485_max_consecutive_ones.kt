package easy

class _485_max_consecutive_ones {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0

        var cur = 0
        nums.forEach { n ->
            if (n == 1) {
                cur++
            } else {
                max = if (cur > max) cur else max
                cur = 0
            }
        }

        max = if (cur > max) cur else max
        return max
    }
}
