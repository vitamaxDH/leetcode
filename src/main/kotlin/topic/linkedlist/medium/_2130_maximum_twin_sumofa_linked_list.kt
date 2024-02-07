package topic.linkedlist.medium

import common.ListNode
import common.createLinkedList
import kotlin.math.max

class _2130_maximum_twin_sumofa_linked_list {
    fun pairSum(head: ListNode?): Int {
        head ?: return 0
        var size = 0
        var cur: ListNode? = head

        while (cur != null) {
            size++
            cur = cur.next
        }

        val midIdx = size / 2
        var curIdx = 0
        cur = head

        while (curIdx < midIdx) {
            curIdx++
            cur = cur?.next
        }

        var reversedHalf: ListNode? = null
        while (cur != null) {
            val next = cur.next
            cur.next = reversedHalf
            reversedHalf = cur
            cur = next
        }

        var max = 0

        cur = head
        var revCur = reversedHalf
        while (revCur != null) {
            max = max(cur!!.`val` + revCur.`val`, max)
            cur = cur.next
            revCur = revCur.next
        }

        return max
    }
}

fun main() {
    with(_2130_maximum_twin_sumofa_linked_list()) {
        println(pairSum(createLinkedList(5, 4, 2, 1)))
        println(pairSum(createLinkedList(4,2,2,3)))
    }
}
