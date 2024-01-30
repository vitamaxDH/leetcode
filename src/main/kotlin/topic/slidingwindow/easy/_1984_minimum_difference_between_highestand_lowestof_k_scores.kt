package topic.slidingwindow.easy

import kotlin.math.min

class _1984_minimum_difference_between_highestand_lowestof_k_scores {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        nums.sort()
        var min = nums.last() - nums.first()
        for (i in k - 1 .. nums.lastIndex) {
            min = min(min, nums[i] - nums[i - k + 1])
        }
        return min
    }
}

fun main() {
    with(_1984_minimum_difference_between_highestand_lowestof_k_scores()) {
        println(minimumDifference(intArrayOf(90), 1))
        println(minimumDifference(intArrayOf(9,4,1,7), 2))
        println(minimumDifference(intArrayOf(11181,23291,24520,92567,19530,12631,11048,37325,36730,45935,43785,85701,60558,4847,88701,27809,76264,73637,50367,48998,31556,28617,60992,76542,71383,22035,95023,89149,54342,12712,93885,1243,5682,75211,60667,68766,94505,67043,98893,80977,6367,13446,64482,13383,71717,22432,49079,52101,61754,98448,42679,35519,523,93809,91584,12763,49377,42131,9990,23324,22887,91557,21905,49635,14267), 39))
    }
}
