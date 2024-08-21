package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.in_place_reversal_linked_list;

import designguru.ListNode;

public class ReverseALinkedlist {
    public ListNode reverse(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }
}
