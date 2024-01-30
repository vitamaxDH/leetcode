package easy

import kotlin.math.abs

class _1763_longest_nice_substring {
    fun longestNiceSubstring(s: String): String {
        var prev: Char? = null
        var startIdx = -1
        var startIdxTmp = -1
        var maxSize = -1
        var continues = false

        for (i in s.indices) {
            if (i == 0) {
                prev = s[i]
                continue
            }

            if (!continues) {
                if (abs(prev!! - s[i]) == 32) {
                    startIdxTmp = i - 1
                    continues = true
                } else if (prev == s[i]) {
                    continues = true
                } else if (prev != s[i] && startIdxTmp != -1) {
//                    startIdxTmp -
                }
            }
        }
        return ""
    }
}

fun main() {
    with(_1763_longest_nice_substring()) {
        println()
    }
}
