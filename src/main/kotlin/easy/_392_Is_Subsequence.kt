package easy

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    var cursor = 0
    t.forEach { c ->
        if (cursor == s.length) return true
        if (s[cursor] == c) {
            cursor++
        }
    }
    return cursor == s.length
}
