package easy

class _2824_count_pairs_whose_sumis_lessthan_target {
    fun countPairs(nums: List<Int>, target: Int): Int {
        val sorted = nums.sorted()

        var result = 0
        for (i in 0 .. sorted.lastIndex) {
            for (j in i + 1 .. sorted.lastIndex) {
                if (sorted[i] + sorted[j] < target) {
                    result++
                } else {
                    break
                }
            }
        }

        return result
    }
}
