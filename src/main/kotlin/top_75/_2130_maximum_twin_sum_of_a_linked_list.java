package top_75;

import java.util.ArrayList;
import java.util.List;

public class _2130_maximum_twin_sum_of_a_linked_list {
    public int pairSum(ListNode head) {
        // naive approach
        // create a list
//        List<Integer> values = new ArrayList<>();
//        var slow2 = head;
//        while (slow2 != null) {
//            values.add(slow2.val);
//            slow2 = slow2.next;
//        }
//        int max = 0;
//        for (int i = 0; i < values.size() / 2; i++) {
//            max = Math.max(max, values.get(i) + values.get(values.size() - 1 - i));
//        }
//        return max;

        // Approach 2
        // two pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // I'm going to reverse the second half for the convenience's sake.
        ListNode prev = null;
        ListNode next = null;

        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int max = 0;
        while (prev != null) {
            max = Math.max(max, prev.val + head.val);
            prev = prev.next;
            head = head.next;
        }

        return max;
    }

    public static void main(String[] args) {
        var s = new _2130_maximum_twin_sum_of_a_linked_list();
        System.out.println(s.pairSum(ListNode.createList(5,4,2,1)));
        System.out.println(s.pairSum(ListNode.createList(4, 2, 2, 3)));
    }
}
