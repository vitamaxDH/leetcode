package topic.slidingwindow.medium

import kotlin.math.max

class _1493_longest_subarray_of_1_s_after_deleting_one_element {
    fun longestSubarray(nums: IntArray): Int {
        var l = 0
        var r = 0
        var max = 0
        var init = false
        for (i in nums.indices) {
            if (!init) {
                if (nums[i] == 1) {
                    l++
                } else {
                    init = true
                }
            } else {
                if (nums[i] == 1) {
                    r++
                } else {
                    max = max(max, l + r)
                    l = r
                    r = 0
                }
            }
        }
        if (!init) return nums.size - 1
        max = max(max, l + r)
        return max
    }
}

fun main() {
    with(_1493_longest_subarray_of_1_s_after_deleting_one_element()) {
        println(longestSubarray(intArrayOf(1,1,0,1)))
        println(longestSubarray(intArrayOf(0,1,1,1,0,1,1,0,1)))
        println(longestSubarray(intArrayOf(1,1,1)))
    }
}
