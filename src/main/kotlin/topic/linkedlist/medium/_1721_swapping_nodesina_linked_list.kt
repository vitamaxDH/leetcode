package topic.linkedlist.medium

import common.ListNode
import common.createLinkedList

class _1721_swapping_nodesina_linked_list {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var size = 0
        var cur = head
        var kNode: ListNode? = null
        while (cur != null) {
            if (size == k - 1) {
                kNode = cur
            }
            cur = cur.next
            size++
        }

        cur = head
        var idx = 0
        while (cur != null) {
            if (idx == size - k) {
                val kValue = kNode!!.`val`
                kNode.`val` = cur.`val`
                cur.`val` = kValue
                return head
            }
            cur = cur.next
            idx++
        }
        return null
    }
}

fun main() {
    with(_1721_swapping_nodesina_linked_list()) {
        swapNodes(createLinkedList(1,2,3,4,5,), 2)!!.print()
        swapNodes(createLinkedList(7,9,6,6,7,8,3,0,9,5), 5)!!.print()
    }
}
