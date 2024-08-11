package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.fast_slow_pointers;

import designguru.ListNode;

public class StartOfLinkedlistCycle {
    // https://chatgpt.com/g/g-ByS3wyXLW-algorithm-ace/c/3225ce82-93c8-4d74-b8c5-d0549131ff0d
    public ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        var s = new StartOfLinkedlistCycle();

    }
}
