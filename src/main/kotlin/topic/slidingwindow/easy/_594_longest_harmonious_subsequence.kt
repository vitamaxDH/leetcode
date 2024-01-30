package topic.slidingwindow.easy

import kotlin.math.max

class _594_longest_harmonious_subsequence {
    fun findLHS(nums: IntArray): Int {
        nums.sort()
        var max = 0
        var left = 0

        for (right in nums.indices) {

            while (nums[left] + 1 < nums[right]) {
                left++
            }

            if (nums[left] < nums[right]) {
                max = max(right - left + 1, max)
            }
        }

        return max
    }
}

fun main() {
    with(_594_longest_harmonious_subsequence()) {
        println(findLHS(intArrayOf(1,3,2,2,5,2,3,7)))
        println(findLHS(intArrayOf(1,2,3,4)))
        println(findLHS(intArrayOf(1,1,1,1)))
        println(findLHS(intArrayOf(1,2,2,1)))
        println(findLHS(intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 17)))
    }
}
