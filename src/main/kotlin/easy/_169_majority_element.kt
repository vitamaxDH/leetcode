package easy

object _169_majority_element {
    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        return nums[nums.lastIndex / 2]
    }
}
