package topic.heap.easy

import kotlin.math.max

class _2500_delete_greatest_valuein_each_row {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        var result = 0
        grid.forEach { it.sort() }
        for (i in grid[0].indices) {
            var subMax = 0
            for (j in grid.indices) {
                subMax = max(subMax, grid[j][i])
            }
            result += subMax
        }
        return result
    }
}

fun main() {
    with(_2500_delete_greatest_valuein_each_row()) {
        println(deleteGreatestValue(arrayOf(
            intArrayOf(1,2,4),
            intArrayOf(3,3,1),
        )))
        println(deleteGreatestValue(arrayOf(
            intArrayOf(10),
        )))
    }
}
