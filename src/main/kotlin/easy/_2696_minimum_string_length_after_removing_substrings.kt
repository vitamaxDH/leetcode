package easy

import java.util.Stack

class _2696_minimum_string_length_after_removing_substrings {
    fun minLength(s: String): Int {
        val stack = Stack<Char>()
        for (c in s) {
            if (stack.isNotEmpty()) {
                val peek = stack.peek()
                if (peek == 'A' && c == 'B') {
                    stack.pop()
                } else if (peek == 'C' && c == 'D') {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            } else {
                stack.push(c)
            }
        }
        return stack.size
    }
}
