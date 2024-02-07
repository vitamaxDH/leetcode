package topic.linkedlist.easy

import common.ListNode
import common.createLinkedList

class _206_reverse_linked_list {
    fun reverseList(head: ListNode?): ListNode? {
        var cur = head
        var prev: ListNode? = null
        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur // <- 이전 놈
            cur = next
        }
        return prev

//        var node = head
//        var prev: ListNode? = null
//        while (node != null) {
//            // 1. 노드 하나 하나 뒤로 갈 것이기 때문에 마지막에 다음 노드를 붙여줄 temp 선언
//            // 사실 상 next 라고 봐도 됨
//            val temp = node.next
//
//            // 2. 현재 노드 기준으로 이전것을 붙여줘야함
//            // 1 -> null, 2 -> 1
//            node.next = prev
//
//            // 3. 작업이 끝났으니 prev 에 이전 작업한 (reversed) 놈을 업데이트
//            prev = node
//
//            // 4. 임시로 저장해둔 다음 참조값을 다시 node 에 넣어줌.
//            node = temp
//        }
//        return prev
    }
}

fun main() {
    with(_206_reverse_linked_list()) {
        reverseList(createLinkedList(1, 2, 3, 4, 5))?.print()
    }
}
