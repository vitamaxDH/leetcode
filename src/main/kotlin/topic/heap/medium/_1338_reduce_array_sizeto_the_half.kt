package topic.heap.medium

import java.util.PriorityQueue

class _1338_reduce_array_sizeto_the_half {
    fun minSetSize(arr: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        arr.forEach { v ->
            map[v] = (map[v] ?: 0) + 1
        }

        val pq = PriorityQueue {
            a: Int, b: Int -> b - a
        }.apply { addAll(map.values) }

        var sum = 0
        var count = 0
        while (sum < arr.size / 2) {
            sum += pq.poll()
            count++
        }

        return count
    }
}

fun main() {
    with(_1338_reduce_array_sizeto_the_half()) {
        println(minSetSize(intArrayOf(3,3,3,3,5,5,5,2,2,7)))
        println(minSetSize(intArrayOf(7,7,7,7,7)))
    }
}

