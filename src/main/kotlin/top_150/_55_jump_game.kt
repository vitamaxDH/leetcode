package top_150

object _55_jump_game {
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.lastIndex

        for (i in nums.lastIndex downTo 0) {
            if (i + nums[i] >= goal) {
                goal = i
            }
        }
        return goal == 0
    }

}

fun main() {
    with(_55_jump_game) {
        println(canJump(intArrayOf(2,3,1,1,4)))
    }
}
