package easy

class _1876_substringsof_size_threewith_distinct_characters {
    fun countGoodSubstrings(s: String): Int {
        if (s.length < 3) return 0
        var count = 0
        for (i in 0 .. s.lastIndex - 2) {
            if (s[i] != s[i + 1] && s[i + 1] != s[i + 2] && s[i] != s[i + 2]) {
                count++
            }
        }
        return count
    }
}

fun main() {
    with(_1876_substringsof_size_threewith_distinct_characters()) {
        println(countGoodSubstrings("xyzzaz"))
        println(countGoodSubstrings("aababcabc"))
    }
}
