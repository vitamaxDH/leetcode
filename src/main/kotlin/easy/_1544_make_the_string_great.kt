package easy

class _1544_make_the_string_great {
    fun makeGood(s: String): String {
        val q = ArrayDeque<Char>()
        for (c in s) {
            if (q.isNotEmpty()) {
                if (c >= 'a' && c - 32 == q.last()) {
                    q.removeLast()
                    continue
                } else if (c < 'a' && c + 32 == q.last()) {
                    q.removeLast()
                    continue
                }
            }
            q.add(c)
        }

        return buildString {
            while (q.isNotEmpty()) {
                append(q.removeFirst())
            }
        }
    }
}
