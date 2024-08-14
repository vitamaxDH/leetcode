package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.fast_slow_pointers;

import designguru.ListNode;

public class RearrangeALinkedlist {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = secondHalf;
            secondHalf = slow;
            slow = next;
        }

        ListNode firstHalf = head;

        while (secondHalf != null) {
            ListNode temp = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = temp;

            temp = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = temp;
        }

        if (firstHalf != null) {
            firstHalf.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        var s = new RearrangeALinkedlist();
        s.reorder(ListNode.createList(2,4,6,8,10,12)).print();
    }
}
