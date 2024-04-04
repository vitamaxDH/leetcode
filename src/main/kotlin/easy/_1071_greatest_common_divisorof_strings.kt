package easy

class _1071_greatest_common_divisorof_strings {
    fun gcdOfStrings(str1: String, str2: String): String {
        return if (str1 + str2 == str2 + str1) {
            str1.substring(0, gcd(str1.length, str2.length))
        } else {
            ""
        }
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}

fun main() {
    with(_1071_greatest_common_divisorof_strings()) {
        println(gcdOfStrings("ABCABC", "ABC"))
        println(gcdOfStrings("ABABAB", "ABAB"))
        println(gcdOfStrings("LEET", "CODE"))
    }
}
