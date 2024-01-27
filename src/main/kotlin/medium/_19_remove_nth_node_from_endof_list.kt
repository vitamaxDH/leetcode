package medium

import common.ListNode

class _19_remove_nth_node_from_endof_list {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null
        val dummy = ListNode(0)
        dummy.next = head

        var left: ListNode? = dummy
        var right = head

        var target = n
        while (target-- > 0) {
            right = right?.next
        }

        while (right != null) {
            left = left?.next
            right = right.next
        }

        left?.next = left?.next?.next
        return dummy.next
    }
}
