package topic.linkedlist.medium

import common.ListNode
import common.createLinkedList

class _1669_merge_in_between_linked_lists {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var cur = list1
        var count = 0
        while (count < a - 1) {
            count++
            cur = cur?.next
        }
        val ath = cur
        while (count < b + 1) {
            count++
            cur = cur?.next
        }
        val bth = cur
        ath?.next = list2
        cur = list2
        while (cur?.next != null) {
            cur = cur.next
        }
        cur?.next = bth
        return list1
    }
}

fun main() {
    with(_1669_merge_in_between_linked_lists()) {
        mergeInBetween(createLinkedList(0,1,2,3,4,5), 3, 4, createLinkedList(1000000,1000001,1000002))!!.print()
        mergeInBetween(createLinkedList(0,1,2,3,4,5, 6), 2, 5, createLinkedList(1000000,1000001,1000002,1000003,1000004))!!.print()
    }
}
