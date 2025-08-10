package top_150;

import java.util.Stack;

public class _20_valid_parentheses {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (var c: s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '(') return false;
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '[') return false;
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '{') return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var s= new _20_valid_parentheses();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
    }
}
