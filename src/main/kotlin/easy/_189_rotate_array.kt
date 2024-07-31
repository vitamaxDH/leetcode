package easy

object _189_rotate_array {
    fun rotate(nums: IntArray, k: Int): Unit {
        var nextVal = Int.MIN_VALUE
        var curIdx = 0
        val lastIndex = nums.lastIndex
        repeat(nums.size) {
            val idxCand = curIdx + k
            val nextIdx = if (idxCand > lastIndex) idxCand - lastIndex - 1 else idxCand
            println("nextIdx: $nextIdx")
            val prevVal = nextVal
            nextVal = nums[nextIdx]
            nums[nextIdx] = if (it == 0) nums[curIdx] else prevVal
            curIdx = nextIdx
        }
        println(nums.toList())
    }
}

fun main() {
    with(_189_rotate_array) {
        println(rotate(intArrayOf(1,2,3,4,5,6,7), 6))
        println(rotate(intArrayOf(-1,-100,3,99), 2))
    }
}
