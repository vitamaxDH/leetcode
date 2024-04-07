package top_150

object _45_jump_game_ii {
    fun jump(nums: IntArray): Int {
        var steps = 0
        var l = 0
        var r = 0
        while (r < nums.lastIndex) {
            var farthest = 0
            for (i in l..r) {
                farthest = maxOf(farthest, i + nums[i])
            }
            l = r + 1
            r = farthest
            steps++
        }
        return steps
    }
}

fun main() {
    with(_45_jump_game_ii) {
        val nums = intArrayOf(2, 3, 1, 1, 4)
        println(jump(nums))
    }
}
