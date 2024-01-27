package medium

class _34_find_firstand_last_positionof_elementin_sorted_array {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(
            nums.binSearch(target, true),
            nums.binSearch(target, false),
        )
    }

    fun IntArray.binSearch(target: Int, leftBias: Boolean): Int {
        var l = 0
        var r = lastIndex

        var i = -1
        while (l <= r) {
            val m = (l + r) ushr 1
            if (target > this[m]) {
                l = m + 1
            } else if (target < this[m]) {
                r = m - 1
            } else {
                i = m
                if (leftBias) {
                    r = m - 1
                } else {
                    l = m + 1
                }
            }
        }
        return i
    }
}
