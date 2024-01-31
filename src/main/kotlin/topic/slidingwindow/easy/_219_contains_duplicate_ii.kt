package topic.slidingwindow.easy

class _219_contains_duplicate_ii {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val window = HashSet<Int>()
        var l = 0
        for (r in nums.indices) {
            if (r - l > k) window.remove(nums[l++])
            if (window.contains(nums[r])) return true
            window.add(nums[r])
        }
        return false
    }
}

fun main() {
    with(_219_contains_duplicate_ii()) {
        println(containsNearbyDuplicate(intArrayOf(1,2,3,1), 3))
        println(containsNearbyDuplicate(intArrayOf(1,0,1,1), 1))
        println(containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2))
        println(containsNearbyDuplicate(intArrayOf(2,2), 3))
    }
}
