package easy

class _459_repeated_substring_pattern {
    fun repeatedSubstringPattern(s: String): Boolean {
        if (s.isEmpty()) return false
        var pattern = StringBuilder()
        var firstChar: Char? = null
        for (i in 0 .. s.lastIndex / 2) {
            if (i == 0) {
                pattern.append(s[i])
                firstChar = s[i]
                continue
            }
            val c = s[i]
//            if (c == first)
        }
//        s.forEachIndexed { index, char ->
//            if (index == 0) {
//                pattern += char
//                return@forEachIndexed
//            }
//
//            if (char == pattern[0]) {
//                val isRepeated = s.replace(pattern, "").isBlank()
//                if (isRepeated) {
//                    return true
//                }
//            }
//            pattern += char
//        }
        return false
    }
}
