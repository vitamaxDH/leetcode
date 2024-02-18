package topic.heap.medium

class _1738_find_kth_largest_x_o_r_coordinate_value {
    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val nums = IntArray((matrix.size * matrix[0].size))
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {

            }
        }
        nums.sort()
        return nums[k - 1]
    }
}

fun main() {
    with(_1738_find_kth_largest_x_o_r_coordinate_value()) {
        println(kthLargestValue(arrayOf(
            intArrayOf(5,2),
            intArrayOf(1,6),
        ), k = 1))
        println(kthLargestValue(arrayOf(
            intArrayOf(5,2),
            intArrayOf(1,6),
        ), k = 2))
        println(kthLargestValue(arrayOf(
            intArrayOf(5,2),
            intArrayOf(1,6),
        ), k = 3))
    }
}
