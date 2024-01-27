package medium

class _31_next_permutation {
    fun nextPermutation(nums: IntArray) {
        if (nums.size == 1) {
            return
        }

        val size = nums.size
        var i = 1
        var lastInc = -1
        while (i < size) {
            if (nums[i] > nums[i - 1]) {
               lastInc = i
            }
            i++
        }

        if (lastInc == -1) {
            (0 .. nums.lastIndex / 2).forEach {
                nums.swap(it, nums.lastIndex - it)
            }
            return
        }

        var index = lastInc
        (lastInc + 1 ..< size).forEach {
            if (nums[it] > nums[lastInc - 1] && nums[it] < nums[index]) {
                index = it
            }
        }
        nums.swap(lastInc - 1, index)
        nums.sort(fromIndex = lastInc)
    }

    private fun IntArray.swap(index1: Int, index2: Int) {
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }
}
