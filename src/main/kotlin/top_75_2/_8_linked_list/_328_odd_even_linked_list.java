package top_75_2._8_linked_list;

import designguru.ListNode;

public class _328_odd_even_linked_list {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        // o(n1) = 무조건 포인터 2개 써야함
        var odd = head;
        var even = head.next;
        var evenHead = even;

        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        var s = new _328_odd_even_linked_list();
        s.oddEvenList(ListNode.createList(1,2,3,4,5)).print();
        s.oddEvenList(ListNode.createList(2,1,3,5,6,4,7)).print();
    }
}
