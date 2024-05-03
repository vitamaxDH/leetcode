package top_75;

public class _2095_delete_the_middle_node_of_a_linked_list {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        var cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        cur = head;
        int half = size / 2;
        while (half-- > 1) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public ListNode deleteMiddle2(ListNode head) {
        if (head == null || head.next == null) return null;
        var slow = head;
        var fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        var s = new _2095_delete_the_middle_node_of_a_linked_list();
        s.deleteMiddle2(ListNode.createList(1,3,4,7,1,2,6)).print();
        s.deleteMiddle2(ListNode.createList(1,2,3,4)).print();
        s.deleteMiddle2(ListNode.createList(2,1)).print();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode createList(int... values) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public void print() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
