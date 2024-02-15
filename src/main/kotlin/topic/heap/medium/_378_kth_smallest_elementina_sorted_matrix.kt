package topic.heap.medium

class _378_kth_smallest_elementina_sorted_matrix {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        if (matrix.size == 1) return matrix[0][0]
        val arr = IntArray(matrix.size * matrix.size)
        for (i in matrix.indices) {
            for (j in matrix.indices) {
                arr[i * matrix.size + j] = matrix[i][j]
            }
        }
        arr.sort()
        return arr[k - 1]
    }
}

fun main() {
    with(_378_kth_smallest_elementina_sorted_matrix()) {
        println(
            kthSmallest(
                arrayOf(
                    intArrayOf(1, 5, 9),
                    intArrayOf(10, 11, 13),
                    intArrayOf(12, 13, 15),
                ), k = 8
            )
        )
        println(
            kthSmallest(
                arrayOf(
                    intArrayOf(1,2),
                    intArrayOf(1,3),
                ), k = 1
            )
        )
    }
}
