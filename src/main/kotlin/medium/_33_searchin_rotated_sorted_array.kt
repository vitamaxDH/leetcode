package medium

class _33_searchin_rotated_sorted_array {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) return if (nums[0] == target) 0 else -1
        if (target > 0 && nums.first() < 0 && nums.last() < 0) return -1
        if (target < 0 && nums.first() > 0 && nums.last() > 0) return -1

        var lIdx = 0
        var rIdx = nums.lastIndex

        while(true) {
            val mIdx = (lIdx + rIdx) / 2
            val middle = nums[mIdx]
            val left = nums[lIdx]
            val right = nums[rIdx]

            when (target) {
                left -> return lIdx
                right -> return rIdx
                middle -> return mIdx
            }

            when (mIdx) {
                lIdx, rIdx -> return -1
            }

            if (left < middle && middle < right) {
                return nums.idxOf(target, lIdx, rIdx)
            }
            if (left > middle) {
                if (middle < target && target < right) {
                    return nums.idxOf(target, mIdx, rIdx)
                }
                rIdx = mIdx
            } else if (right < middle) {
                if (left < target && target < middle) {
                    return nums.idxOf(target, lIdx, mIdx)
                }
                lIdx = mIdx
            } else {
                return -1
            }
        }
    }

    fun IntArray.idxOf(target: Int, lIdx: Int, rIdx: Int): Int {
        var lIdx = lIdx
        var rIdx = rIdx
        while(lIdx < rIdx) {
            val mIdx = (lIdx + rIdx) / 2
            val left = this[lIdx]
            val middle = this[mIdx]
            val right = this[rIdx]

            when (target) {
                left -> return lIdx
                middle -> return mIdx
                right -> return rIdx
            }

            when (mIdx) {
                lIdx, rIdx -> return -1
            }

            if (left < target && target < middle) {
                rIdx = mIdx
            } else if (middle < target && target < right) {
                lIdx = mIdx
            } else {
                return -1
            }
        }
        return -1
    }
}
