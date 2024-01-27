package medium

class _6_zigzag_conversion {
    fun convert(s: String, numRows: Int): String {
        if (s.length <= numRows) return s
        if (s.length == 1) return s[0].toString()
        if (numRows == 1) return s
        val rows = List(numRows) {
            if (it == 0) {
                mutableListOf(s[0])
            } else {
                mutableListOf()
            }
        }
        var sIdx = 1
        var rowUp = true
        while (sIdx < s.length) {
            rowUp = if (rowUp) {
                var rIdx = 1
                repeat(numRows - 1) {
                    if (sIdx < s.length) {
                        rows[rIdx++].add(s[sIdx++])
                    }
                }
                false
            } else {
                var rIdx = numRows - 2
                repeat(numRows - 1) {
                    if (sIdx < s.length){
                        rows[rIdx--].add(s[sIdx++])
                    }
                }
                true
            }
        }

        return buildString {
            repeat(rows.size) {
                append(rows[it].joinToString(""))
            }
        }
    }
}
