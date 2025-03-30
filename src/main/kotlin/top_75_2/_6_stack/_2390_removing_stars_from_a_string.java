package top_75_2._6_stack;

import java.util.Stack;

public class _2390_removing_stars_from_a_string {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Classic solution / textbook approach
    public String removeStars1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.add(c);
            } else {
                if (!stack.isEmpty()) stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!stack.isEmpty()) {
            for (Character c : stack) {
                sb.append(c);
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        var s = new _2390_removing_stars_from_a_string();
        System.out.println(s.removeStars("leet**cod*e"));
        System.out.println(s.removeStars("erase*****"));
    }
}
