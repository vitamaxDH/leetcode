package topic.linkedlist.medium

import common.ListNode
import common.TreeNode

class _109_convert_sorted_listto_binary_search_tree {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        head ?: return null
        var size = 0
        var cur: ListNode? = head
        while (cur != null) {
            size++
            cur = cur.next
        }
        cur = head
        val nums = IntArray(size) {
            val value = cur!!.`val`
            cur = cur?.next
            value
        }
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
