package easy

import java.util.Stack

class _1047_remove_all_adjacent_duplicates_in_string {
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()
        for (c in s) {
            if (stack.isNotEmpty() && c == stack.peek()) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        return buildString {
            while(stack.isNotEmpty()) {
                insert(0, stack.pop())
            }
        }
    }
}
