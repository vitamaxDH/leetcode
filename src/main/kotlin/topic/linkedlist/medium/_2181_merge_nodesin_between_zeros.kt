package topic.linkedlist.medium

import common.ListNode
import common.createLinkedList

class _2181_merge_nodesin_between_zeros {
    fun mergeNodes(head: ListNode?): ListNode? {
        head ?: return null
        val res = ListNode(-1)
        var cur: ListNode? = res
        var node = head.next
        var sum = 0
        while (node != null) {
            if (node.`val` == 0) {
                cur?.next = ListNode(sum)
                cur = cur?.next
                sum = 0
            } else {
                sum += node.`val`
            }
            node = node.next
        }
        return res.next
    }
}

fun main() {
    with(_2181_merge_nodesin_between_zeros()) {
        mergeNodes(createLinkedList(0,3,1,0,4,5,2,0))!!.print()
        mergeNodes(createLinkedList(0,1,0,3,0,2,2,0))!!.print()
    }
}
