package topic.heap.easy

class _1464_maximum_productof_two_elementsinan_array {
    fun maxProduct(nums: IntArray): Int {
        nums.sort()
        return (nums.last() - 1) * (nums[nums.lastIndex - 1] - 1)
    }
}

fun main() {
    with(_1464_maximum_productof_two_elementsinan_array()) {
        println(maxProduct(intArrayOf(3,4,5,2)))
        println(maxProduct(intArrayOf(1,5,4,5)))
    }
}
