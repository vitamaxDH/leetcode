package topic.linkedlist.medium

import common.ListNode
import common.createLinkedList

class _382_linked_list_random_node {
    class Solution(head: ListNode?) {
        val head = head
        val size = head.run {
            var cur = this
            var size = 0
            while (cur != null) {
                size++
                cur = cur.next
            }
            size
        }

        fun getRandom(): Int {
            var randomSize = (0 ..< size).random()
            var node = head
            while (randomSize > 0) {
                node = node?.next
                randomSize--
            }
            return node!!.`val`
        }
    }
}

fun main() {
    with(_382_linked_list_random_node()) {
        val solution = _382_linked_list_random_node.Solution(createLinkedList(1, 2, 3))
        repeat(100) {
            println(solution.getRandom())
        }
    }
}
