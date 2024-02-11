package topic.heap.medium

import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

class _973_k_closest_pointsto_origin {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val minHeap = PriorityQueue<IntArray> { a, b ->
            val diff = a.lengthToOrigin - b.lengthToOrigin
            if (diff > 0) 1 else -1
        }.apply {
            points.forEach { add(it) }
        }
        return Array(k) { minHeap.poll() }
    }

    val IntArray.lengthToOrigin: Double get() =
        sqrt(this[0].toDouble().pow(2) + this[1].toDouble().pow(2))
}

fun main() {
    with(_973_k_closest_pointsto_origin()) {
        println(kClosest(arrayOf(
            intArrayOf(1,3),
            intArrayOf(-2,2),
        ), 1).forEach{ println(it.toList()) })
        println(kClosest(arrayOf(
            intArrayOf(3,3),
            intArrayOf(5,-1),
            intArrayOf(-2,4),
        ), 2).forEach{ println(it.toList()) })
    }
}
