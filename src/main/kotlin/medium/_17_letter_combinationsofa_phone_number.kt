package medium

class _17_letter_combinationsofa_phone_number {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) return emptyList()
        val result = mutableListOf<String>()
        when(digits.length) {
            1 -> return getChars(digits[0]).map { it }
            2 -> {
                for (i in getChars(digits[0])) {
                    for (j in getChars(digits[1])) {
                        result.add(i + j)
                    }
                }
            }
            3 -> {
                for (i in getChars(digits[0])) {
                    for (j in getChars(digits[1])) {
                       for (k in getChars(digits[2])) {
                           result.add(i + j + k)
                       }
                    }
                }
            }
            4 -> {
                for (i in getChars(digits[0])) {
                    for (j in getChars(digits[1])) {
                        for (k in getChars(digits[2])) {
                            for (l in getChars(digits[3])) {
                                result.add(i + j + k + l)
                            }
                        }
                    }
                }
            }
        }

        return result
    }

    private fun getChars(char: Char): List<String> =
        when(char) {
            '2' -> listOf("a", "b", "c")
            '3' -> listOf("d", "e", "f")
            '4' -> listOf("g", "h", "i")
            '5' -> listOf("j", "k", "l")
            '6' -> listOf("m", "n", "o")
            '7' -> listOf("p", "q", "r", "s")
            '8' -> listOf("t", "u", "v")
            '9' -> listOf("w", "x", "y", "z")
            else -> throw Exception("")
        }
}
