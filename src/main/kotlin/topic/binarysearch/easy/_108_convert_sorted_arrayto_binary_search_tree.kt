package topic.binarysearch.easy

import common.TreeNode

class _108_convert_sorted_arrayto_binary_search_tree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        fun build(left: Int, right: Int): TreeNode? {
            if (left > right) return null
            val mid = (left + right) ushr 1
            return TreeNode(nums[mid]).apply {
                this.left = build(left, mid - 1)
                this.right = build(mid + 1, right)
            }
        }
        return build(0, nums.lastIndex)
    }
}
