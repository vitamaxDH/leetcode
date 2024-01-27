package easy

import java.util.Stack

class _844_backspace_string_compare {
    fun backspaceCompare(s: String, t: String): Boolean {
        fun process(s: String) = with(Stack<Char>()) {
            for (c in s) {
                if (c == '#') {
                    if (isNotEmpty()) pop()
                } else {
                    push(c)
                }
            }
            this
        }

        val s1 = process(s)
        val s2 = process(t)

        while (s1.isNotEmpty() && s2.isNotEmpty()) {
            if (s1.pop() != s2.pop()) return false
        }
        return s1.isEmpty() && s2.isEmpty()
    }
}

fun main() {
    with(_844_backspace_string_compare()) {
        println(backspaceCompare("ab#c", "ad#c"))
        println(backspaceCompare("ab##", "c#d#"))
        println(backspaceCompare("a#c", "b"))
        println(backspaceCompare("y#fo##f", "y#f#o##f"))
    }
}
