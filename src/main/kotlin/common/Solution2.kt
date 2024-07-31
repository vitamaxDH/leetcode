package common

class Solution2 {
    fun solution(n:Long) : List<Long> {
        if (n < 2) {
            return emptyList()
        }

        val dp = LongArray(n.toInt() + 1)
        dp[0] = 0L
        dp[1] = 1L

        for (i in 2..n) {
            val i = i.toInt()
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp.filter(::isPrime)
    }

    private fun isPrime(n: Long): Boolean {
        if (n < 2) return false
        var isPrime = true

        for (i in 2..n / 2) {
            if ((n % i).toInt() == 0) {
                isPrime = false
                break
            }
        }
        return isPrime
    }
}

fun main() {
    with(Solution2()) {
        val result = solution(10)
        println("result: $result")
    }
}
