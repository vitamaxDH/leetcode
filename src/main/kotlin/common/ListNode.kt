package common

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print() {
        var dummy: ListNode? = this
        val list = mutableListOf<Int>()
        while (dummy != null) {
            list.add(dummy.`val`)
            dummy = dummy.next
        }
        println("ListNode: $list")
    }
}

fun createLinkedList(vararg arr: Int): ListNode? {
    if (arr.isEmpty()) return null

    val head = ListNode(arr[0])
    var current = head

    for (i in 1..< arr.size) {
        current.next = ListNode(arr[i])
        current = current.next!!
    }

    return head
}
