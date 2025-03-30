package top_75_2._6_stack;

import java.util.Stack;

public class _394_decode_string {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                // closing brackets must be adjacent -> find until it finds a char rather than ']'
                StringBuilder subSb = new StringBuilder();
                char curChar = stack.pop();
                while (curChar != '[') {
                    subSb.insert(0, curChar);
                    curChar = stack.pop();
                }
                char[] subChars = subSb.toString().toCharArray();
                subSb.setLength(0);
                while (!stack.isEmpty() && '0' <= stack.peek() && stack.peek() <= '9') {;
                    subSb.insert(0, stack.pop() - '0');
                }

                int times = Integer.parseInt(subSb.toString());
                for (int j = 0; j < times; j++) {
                    for (char subChar : subChars) {
                        stack.push(subChar);
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : stack) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        var s = new _394_decode_string();
        System.out.println(s.decodeString("3[a]2[bc]"));
        System.out.println(s.decodeString("3[a2[c]]"));
        System.out.println(s.decodeString("2[abc]3[cd]ef"));
        System.out.println(s.decodeString("100[leetcode]"));
    }
}
