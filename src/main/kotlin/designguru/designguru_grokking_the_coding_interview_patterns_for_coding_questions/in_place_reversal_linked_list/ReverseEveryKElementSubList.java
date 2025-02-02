package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.in_place_reversal_linked_list;

import designguru.ListNode;

public class ReverseEveryKElementSubList {
    public ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        ListNode reversed;
        while (cur != null) {
            ListNode subhead = cur;
            reversed = subhead;
            for (int i = 0; cur != null && i < k; i++) {
                ListNode next = subhead.next;
                subhead.next = reversed;
                reversed = subhead;
                subhead = next;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        var s = new ReverseEveryKElementSubList();
        s.reverse(ListNode.createList(1,2,3,4,5,6,7,8), 3).print();
    }
}
