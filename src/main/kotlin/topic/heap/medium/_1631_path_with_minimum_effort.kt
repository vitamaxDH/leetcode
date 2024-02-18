package topic.heap.medium

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max

class _1631_path_with_minimum_effort {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val heap = PriorityQueue<Triple<Int, Int, Int>> { a, b ->
            a.first - b.first
        }.apply {
            add(Triple(0, 0, 0))
        }
        val directions = arrayOf(
            Pair(0, 1),
            Pair(0, -1),
            Pair(1, 0),
            Pair(-1, 0),
        )
        val visited = HashSet<Pair<Int, Int>>()
        while (heap.isNotEmpty()) {
            val (diff, r, c) = heap.poll()
            if (Pair(r, c) in visited) continue

            visited.add(Pair(r, c))
            if (r == heights.lastIndex && c == heights[0].lastIndex) {
                return diff
            }
            for ((dr, dc) in directions) {
                val newR = r + dr
                val newC = c + dc
                if (newR < 0 || newR == heights.size ||
                    newC < 0 || newC == heights[0].size ||
                    Pair(newR, newC) in visited) {
                    continue
                }

                val newDiff = max(diff, abs(heights[newR][newC] - heights[r][c]))
                heap.add(Triple(newDiff, newR, newC))
            }
        }
        return 0
    }
}

fun main() {
    with(_1631_path_with_minimum_effort()) {
//        println(minimumEffortPath(arrayOf(
//            intArrayOf(10,8),
//            intArrayOf(10,8),
//            intArrayOf(1,2),
//            intArrayOf(10,3),
//            intArrayOf(1,3),
//            intArrayOf(6,3),
//            intArrayOf(5,2),
//        )))
        println(minimumEffortPath(arrayOf(
            intArrayOf(1,2,2),
            intArrayOf(3,8,2),
            intArrayOf(5,3,5),
        )))
//        println(minimumEffortPath(arrayOf(
//            intArrayOf(1,2,3),
//            intArrayOf(3,8,4),
//            intArrayOf(5,3,5),
//        )))
//        println(minimumEffortPath(arrayOf(
//            intArrayOf(1,10,6,7,9,10,4,9),
//        )))
    }
}
