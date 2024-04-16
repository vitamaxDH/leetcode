package top_150;

public class _21_merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var dummy = new ListNode(0);
        var tail = dummy;

        while (list1 != null || list2 != null) {
            var v1 = list1 != null ? list1.val : 101;
            var v2 = list2 != null ? list2.val : 101;

            dummy.print();
            if (v1 < v2) {
                tail.next = list1;
                list1 = list1 != null ? list1.next : null;
            } else {
                tail.next = list2;
                list2 = list2 != null ? list2.next : null;
            }
            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        var s = new _21_merge_two_sorted_lists();
        s.mergeTwoLists(ListNode.createList(1,2,4), ListNode.createList(1,3,4)).print();
    }
}
