package medium

import common.ListNode

class _24_swap_nodesin_pairs {
    fun swapPairs(head: ListNode?): ListNode? {
        head ?: return null
        if (head.next == null) return head
        val ans = ListNode(0)
        ans.next = head

        var cur: ListNode? = ans
        while (cur?.next?.next != null) {
            val t1 = cur.next
            val t2 = cur.next?.next
            cur.next = t2
            t1?.next = t2?.next
            t2?.next = t1
            cur = cur.next?.next
        }

        return ans.next
    }
}
