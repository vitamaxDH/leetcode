package topic.slidingwindow.easy

class _2269_findthe_k_beauty_of_a_number {
    fun divisorSubstrings(num: Int, k: Int): Int {
        val numStr = num.toString()
        var count = 0
        for (i in 0..numStr.length - k) {
            val divisor = numStr.substring(i, i + k).toInt()
            if (divisor != 0 && num % divisor == 0) {
                count++
            }
        }
        return count
    }
}

fun main() {
    with(_2269_findthe_k_beauty_of_a_number()) {
        println(divisorSubstrings(240, 2))
        println(divisorSubstrings(430043, 2))
        println(divisorSubstrings(2, 1))
        println(divisorSubstrings(10, 1))
    }
}
