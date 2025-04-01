package top_75_2._8_linked_list;

import designguru.ListNode;

public class _2095_delete_the_middle_node_of_a_linked_list {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        // slow, fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // fast 포인터는 두 칸씩, slow 포인터는 한 칸씩 이동
        // fast가 null 또는 fast.next가 null이 되면 slow는 가운데 노드를 가리킵니다.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // prev가 가운데 노드의 이전 노드이므로, 그 다음 노드를 slow.next로 연결
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        var s = new _2095_delete_the_middle_node_of_a_linked_list();
//        s.deleteMiddle(ListNode.createList(1, 3, 4, 7, 1, 2, 6)).print();
//        s.deleteMiddle(ListNode.createList(1)).print(); // nothing
        s.deleteMiddle(ListNode.createList(1,2)).print(); // [1]
        s.deleteMiddle(ListNode.createList(1,2,3)).print(); // [1,3]
        s.deleteMiddle(ListNode.createList(1,2,3,4)).print(); // [1,2,4]
    }
}
