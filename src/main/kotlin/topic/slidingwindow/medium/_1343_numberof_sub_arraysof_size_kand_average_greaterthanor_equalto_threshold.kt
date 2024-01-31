package topic.slidingwindow.medium

class _1343_numberof_sub_arraysof_size_kand_average_greaterthanor_equalto_threshold {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        val threshold = k * threshold
        var sum = arr.sliceArray(0..< k).sum()
        var ans = if (sum >= threshold) 1 else 0
        for (i in 0 .. arr.lastIndex - k) {
            sum = sum - arr[i] + arr[i + k]
            if (sum >= threshold) ans++
        }
        return ans
    }
}

fun main() {
    with(_1343_numberof_sub_arraysof_size_kand_average_greaterthanor_equalto_threshold()) {
        println(numOfSubarrays(intArrayOf(2,2,2,2,5,5,5,8), 3, 4))
        println(numOfSubarrays(intArrayOf(11,13,17,23,29,31,7,5,2,3), 3, 5))
    }
}
