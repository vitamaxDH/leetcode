package top_150;

import java.util.Stack;

public class _71_simplify_path2 {

    public String simplifyPath(String path) {
        var shreds = path.split("/");
        Stack<String> stack = new Stack<>();
        // needs to filter
        for (var shred: shreds) {
            switch (shred) {
                case "", "." -> {}
                case ".." -> {
                    if (!stack.empty()) stack.pop();
                }
                default -> stack.push(shred);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (var s: stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        var s = new _71_simplify_path2();
        System.out.println(s.simplifyPath("/home/")); // /home
        System.out.println(s.simplifyPath("/home//foo/")); // /home
        System.out.println(s.simplifyPath("/home/user/Documents/../Pictures")); // /home
        System.out.println(s.simplifyPath("/.../a/../b/c/../d/./")); // /home
        System.out.println(s.simplifyPath("/../")); // /home
    }
}
