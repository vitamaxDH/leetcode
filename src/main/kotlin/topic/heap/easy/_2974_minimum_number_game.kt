package topic.heap.easy

class _2974_minimum_number_game {
    fun numberGame(nums: IntArray): IntArray {
        nums.sort()
        for (i in 1 .. nums.lastIndex step 2) {
            val temp = nums[i]
            nums[i] = nums[i - 1]
            nums[i - 1] = temp
        }
        return nums
    }
}

fun main() {
    with(_2974_minimum_number_game()) {
        println(numberGame(intArrayOf(5,4,2,3)).toList())
        println(numberGame(intArrayOf(2,5)).toList())
    }
}
