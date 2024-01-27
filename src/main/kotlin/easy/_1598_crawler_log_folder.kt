package easy

import java.util.Stack

class _1598_crawler_log_folder {
    fun minOperations(logs: Array<String>): Int {
        val stack = Stack<String>()
        for (log in logs) {
            when (log) {
                "../" -> if (stack.isNotEmpty()) {
                    stack.pop()
                }
                "./" -> Unit
                else -> stack.push(log)
            }
        }
        return stack.size
    }

    fun minOperations2(logs: Array<String>): Int {
        var depth = 0
        for (log in logs) {
            when (log) {
                "../" -> if (depth > 0) {
                    depth--
                }
                "./" -> Unit
                else -> depth++
            }
        }
        return depth
    }
}
