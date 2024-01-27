package medium

class _162_find_peak_element {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        if (nums.last() > nums[nums.lastIndex - 1]) return nums.lastIndex
        if (nums[0] > nums[1]) return 0

        return nums.binSearch(0, nums.lastIndex)
    }

    fun IntArray.binSearch(l: Int, r: Int): Int {
        if (l > r) {
            return -1 // Target not found
        }

        val m = (l + r) ushr 1

        return when {
            m == 0 -> {
                if (this[0] > this[1]) return 0
                else binSearch(0 + 1, r)
            }
            m == lastIndex -> {
                if (this[m - 1] < this[m]) return m
                else binSearch(l, m - 1)
            }
            this[m - 1] < this[m] && this[m] > this[m + 1] -> m
            else -> {
                val left = binSearch(l, m - 1)
                val right = binSearch(m + 1, r)
                if (left == -1) right else left
            }
        }
    }
}
