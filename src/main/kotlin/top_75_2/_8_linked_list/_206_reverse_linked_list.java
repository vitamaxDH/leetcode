package top_75_2._8_linked_list;

import designguru.ListNode;

public class _206_reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

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
        System.out.println(s.reverseList(ListNode.createList(1, 2, 3, 4, 5)));
        System.out.println(s.reverseList(ListNode.createList(1, 2)));
    }
}
