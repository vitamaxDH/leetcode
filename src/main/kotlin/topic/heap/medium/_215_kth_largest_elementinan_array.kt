package topic.heap.medium

import java.util.PriorityQueue

class _215_kth_largest_elementinan_array {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int> { a, b -> b - a }.apply {
            nums.forEach { add(it) }
        }
        repeat(k - 1) {
            maxHeap.poll()
        }
        return maxHeap.poll()
    }
}

fun main() {
    with(_215_kth_largest_elementinan_array()) {
        println(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
        println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }
}
