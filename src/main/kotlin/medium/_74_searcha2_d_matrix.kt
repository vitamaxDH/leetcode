package medium

class _74_searcha2_d_matrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.lastIndex
        while (l < r) {
            val m = (l + r) ushr 1
            if (target < matrix[m][0]) {
                r = m
            } else if (matrix[m][0] < target) {
                l = m
            } else if (matrix[m][0] == target) {
                return true
            }
            if (r - l == 1) break
        }

        val row = if (target < matrix[r][0]) {
            l
        } else {
            r
        }

        val subMatrix = matrix[row]
        l = 0
        r = subMatrix.lastIndex
        while (l <= r) {
            val m = (l + r) ushr 1
            if (target > subMatrix[m]) {
                l = m + 1
            } else if (target < subMatrix[m]) {
                r = m - 1
            } else {
                return true
            }
        }
        return false
    }
}
