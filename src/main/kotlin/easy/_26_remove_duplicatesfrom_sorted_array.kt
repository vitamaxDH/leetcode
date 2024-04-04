package easy

object _26_remove_duplicatesfrom_sorted_array {
    fun removeDuplicates(nums: IntArray): Int {
        var lastIdx = 0
        for (i in nums.indices) {
            if (i == 0) continue
            if (nums[lastIdx] == nums[i]) continue
            nums[++lastIdx] = nums[i]
        }
        return lastIdx + 1
    }
}

fun main() {
    with(_26_remove_duplicatesfrom_sorted_array) {
        println(removeDuplicates(intArrayOf(1,1,2)))
        println(removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
    }
}
