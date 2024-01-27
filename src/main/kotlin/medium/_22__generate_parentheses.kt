package medium

class _22__generate_parentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun helper(parenthesisInBits: Int, opening: Int, closing: Int) {
            val newBits = parenthesisInBits shl 1
            if (opening > 0 && closing > 0) {
                helper(newBits + 1, opening - 1, closing + 1)
                helper(newBits , opening, closing - 1)
            } else if (opening > 0 && closing == 0) {
                helper(newBits + 1, opening - 1, 1)
            } else if (opening == 0 && closing > 0) {
                helper(newBits , opening, closing - 1)
            } else {
                val sb = StringBuilder()
                var tempBits = parenthesisInBits
                while (tempBits != 0) {
                    if (tempBits and 1 ==  0) {
                        sb.append("(")
                    } else {
                        sb.append(")")
                    }
                    tempBits = tempBits shr 1
                }
                result.add(sb.toString())
                return
            }
        }

        helper(1, n - 1, 1)

        return result
    }
}
