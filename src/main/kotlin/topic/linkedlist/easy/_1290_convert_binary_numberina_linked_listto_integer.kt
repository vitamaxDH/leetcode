package topic.linkedlist.easy

import common.ListNode
import common.createLinkedList

class _1290_convert_binary_numberina_linked_listto_integer {
    fun getDecimalValue(head: ListNode?): Int {
        head ?: return 0
        var result = 0
        var cur = head
        while (cur != null) {
            result += cur.`val`
            cur = cur.next
            if (cur != null) {
                result = result shl 1
            }
        }
        return result
    }
}

fun main() {
    with(_1290_convert_binary_numberina_linked_listto_integer()) {
        println(getDecimalValue(createLinkedList(1,0,1,0)))
    }
}
