package easy

import java.util.Stack

class _496_next_greater_element_i {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        val stack = Stack<Int>()
        for (num in nums2) {
            while (stack.isNotEmpty() && num > stack.peek()) {
                map[stack.pop()] = num
            }
            stack.push(num)
        }

        return IntArray(nums1.size) { map[nums1[it]] ?: -1 }
    }
}
