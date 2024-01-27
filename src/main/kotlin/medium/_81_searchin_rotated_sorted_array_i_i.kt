package medium

class _81_searchin_rotated_sorted_array_i_i {
    fun search(nums: IntArray, target: Int): Boolean {
        nums.sort()
        return nums.binSearch(0, nums.lastIndex, target)
    }

    fun IntArray.binSearch(l: Int, r: Int, target: Int): Boolean {
        var l = l
        var r = r
        while (l <= r) {
            val m = (l + r) ushr 1
            if (target < this[m]) {
                r = m - 1
            } else if (target > this[m]) {
                l = m + 1
            } else {
                return true
            }
        }
        return false
    }
}
