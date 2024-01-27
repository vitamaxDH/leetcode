package easy

class _1614_maximum_nesting_depthofthe_parentheses {
    fun maxDepth(s: String): Int {
        var max = 0
        var stack = 0
        for (c in s) {
            when (c) {
                '(' -> stack++
                ')' -> stack--
            }
            if (max < stack) max = stack
        }
        return max
    }
}
