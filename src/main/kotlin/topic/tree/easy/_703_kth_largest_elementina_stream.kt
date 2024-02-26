package topic.tree.easy

import java.util.PriorityQueue

object _703_kth_largest_elementina_stream {
    class KthLargest(k: Int, nums: IntArray) {
        val k = k
        val pq = PriorityQueue<Int>().apply { nums.forEach(this::add) }

        fun add(`val`: Int): Int {
            pq.offer(`val`)
            while (pq.size > k) {
                pq.poll()
            }
            return pq.peek()
        }
    }
}

fun main() {
    with(_703_kth_largest_elementina_stream.KthLargest(3, intArrayOf(4,5,8,2))) {
        println(add(3))
        println(add(5))
        println(add(10))
        println(add(9))
        println(add(4))
    }
}
