package medium

class _167_two_sum_i_i_input_array_is_sorted {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            if (nums[l] + nums[r] == target) return intArrayOf(l + 1, r + 1)
            if (nums[l] + nums[r] < target) {
                l++
            } else if (nums[l] + nums[r] > target) {
                r--
            }
        }
        return intArrayOf(l + 1, r + 1)
    }
}
