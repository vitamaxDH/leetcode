package topic.linkedlist.medium

import common.ListNode
import common.createLinkedList

class _2807_insert_greatest_common_divisorsin_linked_list {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var node = head
        val res = node
        var cur = res
        while (node != null) {
            val next = node.next ?: break
            val gcdNode = ListNode(gcd(node.`val`, next.`val`))
            gcdNode.next = next
            cur?.next = gcdNode
            cur = cur?.next?.next
            node = next
        }

        return res
    }

    fun gcd(a: Int, b: Int): Int {
        return if (b != 0) gcd(b, a % b) else a
    }
}

fun main() {
    with(_2807_insert_greatest_common_divisorsin_linked_list()) {
        insertGreatestCommonDivisors(createLinkedList(18,6,10,33))!!.print()
        insertGreatestCommonDivisors(createLinkedList(7))!!.print()
    }
}
