package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.in_place_reversal_linked_list;

import designguru.ListNode;

public class ReverseASubList {
    public ListNode reverse(ListNode head, int p, int q) {
        if (p >= q) return head;
        ListNode prev = null;
        ListNode cur = head;
        for (int i = 0; cur != null && i < p - 1; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode lastNodeOfFirstPart = prev;
        ListNode reversed = cur;
        for (int i = 0; cur != null && i < q - p + 1; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = prev;
        } else {
            head = prev;
        }

        reversed.next = cur;
        return head;
    }

    public static void main(String[] args) {
        var s = new ReverseASubList();
        s.reverse(ListNode.createList(1,2,3,4,5), 2, 4).print();
        s.reverse(ListNode.createList(1,2,3,4,5,6), 1, 4).print();
    }
}
