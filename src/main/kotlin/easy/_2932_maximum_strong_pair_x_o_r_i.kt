package easy

import kotlin.math.abs

class _2932_maximum_strong_pair_x_o_r_i {
    fun maximumStrongPairXor(nums: IntArray): Int {
        if (nums.size == 1) return 1
        nums.sort()
        var maxXor = Int.MIN_VALUE
        for (i in nums.indices) {
            var found = false
            for (j in i .. nums.lastIndex) {
                val small = nums[i]
                val big = nums[j]
                if (abs(small - big) <= small) {
                    found = true
                    maxXor = if (small xor big > maxXor) small xor big else maxXor
                } else {
                    if (found) break
                }
            }
        }
        return maxXor
    }
}

fun main() {
    with(_2932_maximum_strong_pair_x_o_r_i()) {
        println(maximumStrongPairXor(intArrayOf(1,2,3,4,5)))
        println(maximumStrongPairXor(intArrayOf(10, 100)))
        println(maximumStrongPairXor(intArrayOf(5,6,25,30)))
        println(maximumStrongPairXor(intArrayOf(1,1,10,3,9)))
    }
}
