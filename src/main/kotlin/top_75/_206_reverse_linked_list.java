package top_75;

import java.util.LinkedList;

public class _206_reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var tmp = head.next;
        var node = reverseList(head.next);
        tmp.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseList2(ListNode head) {
        // to reverse a linked list, we need to keep track of the previous node and the next node
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        var s = new _206_reverse_linked_list();
        s.reverseList2(ListNode.createList(1, 2, 3, 4, 5)).print();
//        s.reverseList2(ListNode.createList(1, 2)).print();
//        s.reverseList2(ListNode.createList(1)).print();
    }
}
