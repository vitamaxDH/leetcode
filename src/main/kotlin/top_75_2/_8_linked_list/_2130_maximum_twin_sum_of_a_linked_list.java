package top_75_2._8_linked_list;

import designguru.ListNode;

public class _2130_maximum_twin_sum_of_a_linked_list {
    public int pairSum(ListNode head) {
        // 초기화: slow는 첫 노드, fast도 첫 노드, prev는 역전된 부분을 추적
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode next;

        // 한 번의 순회로 앞쪽 절반을 역전
        while (fast != null && fast.next != null) {
            next = slow.next; // slow의 다음 노드 임시 저장
            fast = fast.next.next;         // fast는 두 칸씩 이동

            // 현재 slow 노드를 역전 작업
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 역전된 앞쪽 리스트의 꼬리(원래의 head)가 이제 마지막 노드가 됨.
        // 이 노드와 뒤쪽(역전하지 않은) 리스트(slow가 가리키는 부분)를 연결
        head.next = slow;

        // prev는 역전된 앞쪽 리스트의 새 head이므로 반환
        int max = 0;
        while (slow != null) {
            max = Math.max(max, slow.val + prev.val);
            slow = slow.next;
            prev = prev.next;
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new _2130_maximum_twin_sum_of_a_linked_list();
        System.out.println(s.pairSum(ListNode.createList(5, 4, 2, 1)));
//        System.out.println(s.pairSum(ListNode.createList(4, 2, 2, 3)));
    }
}
