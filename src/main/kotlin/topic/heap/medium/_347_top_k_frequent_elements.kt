package topic.heap.medium

import java.util.PriorityQueue

class _347_top_k_frequent_elements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            map[it] = map[it]?.run { this + 1 } ?: 1
        }
        val pq = PriorityQueue { a: Map.Entry<Int, Int>, b: Map.Entry<Int, Int> ->
            b.value - a.value
        }
        pq.addAll(map.entries)
        return IntArray(k) { pq.poll().key }
    }
}

fun main() {
    with(_347_top_k_frequent_elements()) {
//        println(topKFrequent(intArrayOf(1,1,1,2,2,3), 2).toList())
//        println(topKFrequent(intArrayOf(1), 1).toList())
        println(topKFrequent(intArrayOf(3,0,1,0), 1).toList())
    }
}
