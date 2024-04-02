package easy

object _88_merge_sorted_array {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        if (nums1.isEmpty() || nums2.isEmpty()) return
        var a1 = m - 1
        var a2 = n - 1

        for (i in nums1.lastIndex downTo 0) {
            if (a1 >= 0 && (a2 < 0 || nums1[a1] > nums2[a2])) {
                nums1[i] = nums1[a1--]
            } else {
                nums1[i] = nums2[a2--]
            }
        }

        println(nums1.toList())
    }
}

fun main() {
    with(_88_merge_sorted_array) {
        merge(
            intArrayOf(1, 2, 3, 0, 0, 0),
            3,
            intArrayOf(2, 5, 6),
            3
        )
    }
}
