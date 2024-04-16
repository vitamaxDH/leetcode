package top_150;

public class _2_add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var dummy = new ListNode(0);
        var tail = dummy;
        var carry = false;

        while (l1 != null || l2 != null || carry) {
            // when there's a value to handle,
            // what we're going to do is to return the ListNode, not the actual sum value,
            // So we don't need to track the value for 10 the power of 10s.
            // add both values and the carry
            var d1 = l1 != null ? l1.val : 0;
            var d2 = l2 != null ? l2.val : 0;

            var sum = d1 + d2 + (carry ? 1 : 0);
            var d = sum % 10;
            carry = (sum / 10) != 0;

            ListNode newNode = new ListNode(d);
            tail.next = newNode;
            tail = tail.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        var s = new _2_add_two_numbers();
        System.out.println(s.addTwoNumbers(ListNode.createList(2,4,3), ListNode.createList(5,6,4)));
        System.out.println(s.addTwoNumbers(ListNode.createList(0), ListNode.createList(0)));
        System.out.println(s.addTwoNumbers(ListNode.createList(9,9,9,9,9,9,9,9), ListNode.createList(9,9,9,9)));
    }
}

