package easy

class _455_assign_cookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var i = 0
        for (j in i ..< g.size) {
            if (g[i] <= s[j]) {
                i++
                if (i == g.size) break
            }
        }
        return i
    }
}
