package common

fun isPalindrome(s: String): Boolean {
    val lastIndex = s.lastIndex
    for (i in 0..lastIndex / 2) {
        if (s[i] != s[lastIndex - i]) {
            return false
        }
    }
    return true
}
