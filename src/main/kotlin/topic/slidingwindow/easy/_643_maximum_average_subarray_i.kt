package topic.slidingwindow.easy

import kotlin.math.max

class _643_maximum_average_subarray_i {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var max = nums.sliceArray(0..< k).sum()
        var subsum = max
        for (i in 0 .. nums.lastIndex - k) {
            subsum = subsum - nums[i] + nums[i + k]
            max = max(max, subsum)
        }
        return max.toDouble() / k.toDouble()
    }
}

fun main() {
    with(_643_maximum_average_subarray_i()) {
        println(findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4))
        println(findMaxAverage(intArrayOf(5), 1))
    }
}
