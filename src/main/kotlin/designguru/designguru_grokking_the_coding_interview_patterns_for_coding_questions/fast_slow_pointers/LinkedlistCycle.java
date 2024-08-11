package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.fast_slow_pointers;

import designguru.ListNode;

public class LinkedlistCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
