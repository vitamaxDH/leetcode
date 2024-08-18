package medium;

import designguru.ListNode;

public class _92_reverse_linked_list_ii {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode prev = null;
        int count = 1;
        while (cur != null) {
            prev = cur;
            cur = cur.next;
            if (count++ == left) break;
        }
        ListNode reversed = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = reversed;
            reversed = cur;
            cur = next;
        }
        ListNode last = reversed;
        while (last.next != null) {
            last = last.next;
        }
        last.next = cur;
        prev.next = reversed;
        return dummy.next;
    }

    public static void main(String[] args) {
        var s = new _92_reverse_linked_list_ii();
        s.reverseBetween(ListNode.createList(1,2,3,4,5), 2, 4).print();
        s.reverseBetween(ListNode.createList(5), 1, 1).print();
        s.reverseBetween(ListNode.createList(3, 5), 1, 2).print();
    }
}
