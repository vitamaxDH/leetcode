package easy

fun findTheDifference(s: String, t: String): Char {
    if (s.isEmpty()) return t[0]
    val charCount = mutableMapOf<Char, Int>()
    s.forEach { c ->
        val count = charCount[c]
        if (count != null) {
            charCount[c] = count + 1
        } else {
            charCount[c] = 1
        }
    }
    t.forEach { c ->
        val count = charCount[c]
        if (count == null || count == 0) {
            return c
        } else {
            charCount[c] = count - 1
        }
    }
    throw Exception()
}
