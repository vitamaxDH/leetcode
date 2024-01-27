package easy

class _1021_remove_outermost_parentheses {
    fun removeOuterParentheses(s: String): String {
        var stack = 0
        return buildString {
            for (c in s) {
                if (c == '(') {
                    stack++
                    if (stack != 1) {
                        append(c)
                    }
                } else {
                    stack--
                    if (stack != 0) {
                        append(c)
                    }
                }
            }
        }
    }
}
