package easy

object _80_remove_duplicates_from_sorted_array_ii {
    fun removeDuplicates(nums: IntArray): Int {
        var curIdx = 1
        for (i in 2..nums.lastIndex) {
            if (nums[curIdx - 1] == nums[curIdx] && nums[curIdx] == nums[i]) continue
            nums[++curIdx] = nums[i]
        }
        return curIdx + 1
    }

    fun removeDuplicates2(nums: IntArray): Int {
        var i = 0
        for (n in nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n
            }
        }
        return i
    }
}

fun main() {
    with(_80_remove_duplicates_from_sorted_array_ii) {
        println(removeDuplicates(intArrayOf(1,1,1,2,2,3)))
        println(removeDuplicates(intArrayOf(0,0,1,1,1,1,2,3,3)))
        println(removeDuplicates(intArrayOf(1,2)))
    }
}
