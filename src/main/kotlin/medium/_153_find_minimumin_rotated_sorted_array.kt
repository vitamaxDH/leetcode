package medium

class _153_find_minimumin_rotated_sorted_array {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex

        while (l <= r) {
            if (nums[l] <= nums[r]) return nums[l]
            val m = (l + r) ushr 1
            if (nums[l] > nums[m]) {
                r = m
            } else if (nums[r] < nums[m]) {
                l = m + 1
            }
            if (nums[l] <= nums[r]) return nums[l]
        }
        return 0
    }
}
