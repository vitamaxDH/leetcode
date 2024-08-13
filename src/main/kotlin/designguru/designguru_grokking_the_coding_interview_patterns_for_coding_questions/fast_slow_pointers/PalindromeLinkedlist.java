package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.fast_slow_pointers;

import designguru.ListNode;

public class PalindromeLinkedlist {
    public boolean isPalindrome(ListNode head) {
        if (head == null && head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode dummy = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        var s = new PalindromeLinkedlist();
        System.out.println(s.isPalindrome(ListNode.createList(2,4,6,4,2)));
        System.out.println(s.isPalindrome(ListNode.createList(1, 2, 3, 4, 5, 6)));
        System.out.println(s.isPalindrome(ListNode.createList(1, 2, 3, 4, 5, 6, 7)));
    }
}
