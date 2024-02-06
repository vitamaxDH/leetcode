package topic.linkedlist.easy

import common.ListNode
import common.createLinkedList

class _876_middleofthe_linked_list {
    fun middleNode(head: ListNode?): ListNode? {
        val list = mutableListOf<Int>()
        var cur: ListNode? = head
        while (cur != null) {
            list.add(cur.`val`)
            cur = cur.next
        }
        val mid = list.size / 2
        cur = head
        var count = 0
        while (cur != null) {
            if (count == mid) return cur
            cur = cur.next
            count++
        }
        return null
    }
}

fun main() {
    with(_876_middleofthe_linked_list()) {
        middleNode(createLinkedList(1,2,3,4,5))?.print()
        middleNode(createLinkedList(1,2,3,4,5,6))?.print()
        middleNode(createLinkedList(12,86,47,6,23,6,11,30,16,81,62,32,80,61,66,41,8,88,5,98,77,54,24,60,52,32,99,84,81,66,1,25,31,27,70,90,19,54,50,6,72,32,69,88,18,10,75,40,22,97))?.print()
    }
}
