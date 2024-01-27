package medium

class _153_sum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans = mutableSetOf<List<Int>>()
        nums.sort()

        for (i in 0 .. nums.lastIndex - 2) {
            var left = i + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                if (sum == 0) {
                    ans.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                } else if (sum < 0) (
                    left++
                ) else {
                    right--
                }
            }
        }
        return ans.toList()
    }
}
