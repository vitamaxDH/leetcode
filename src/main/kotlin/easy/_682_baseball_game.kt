package easy

import java.util.Stack

class _682_baseball_game {
    fun calPoints(operations: Array<String>): Int {
        val stack = Stack<Int>()
        for (i in operations.indices) {
            when (operations[i]) {
                "+" -> stack.push(stack.last() + stack.elementAt(stack.lastIndex - 1))
                "D" -> stack.push(stack.last() * 2)
                "C" -> stack.pop()
                else -> stack.push(operations[i].toInt())
            }
        }
        return stack.sum()
    }
}
