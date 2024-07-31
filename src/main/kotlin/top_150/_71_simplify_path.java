package top_150;

import java.util.Stack;

public class _71_simplify_path {
    public String simplifyPath(String path) {
        var stack = new Stack<Integer>();
        boolean nextPath = false;

        for (int i = 1; i < path.length(); i++) {
            
        }

        if (stack.isEmpty()) return "/";
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {

            sb.append("/");
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new _71_simplify_path();
        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/../"));
    }
}
