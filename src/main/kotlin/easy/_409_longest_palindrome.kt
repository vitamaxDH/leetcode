package easy

class _409_longest_palindrome {
    fun longestPalindrome(s: String): Int {
        if (s.isEmpty() || s.length == 1) return s.length
        val map = mutableMapOf<Char, Int>()
        s.forEach { c ->
            val count = map[c]
            if (count == null) {
                map[c] = 1
            } else {
                map[c] = count + 1
            }
        }
        var result = 0
        var isOdd = false
        map.entries.forEach { (_, v) ->
            result += (v / 2) * 2
            if (!isOdd) {
                isOdd = v % 2 == 1
            }
        }
        return result + if (isOdd) 1 else 0
    }
}
