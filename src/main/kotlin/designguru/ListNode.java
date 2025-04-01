package designguru;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ListNode {
    public int val = 0;
    public ListNode next;

    public ListNode(int value) {
        this.val = value;
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

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        ListNode current = this;
        while (current != null) {
            list.add(String.valueOf(current.val));
            current = current.next;
        }
        return String.join(" -> ", list);
    }

}


