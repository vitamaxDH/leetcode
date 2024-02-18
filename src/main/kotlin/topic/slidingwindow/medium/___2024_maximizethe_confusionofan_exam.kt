package topic.slidingwindow.medium

import kotlin.math.max

class ___2024_maximizethe_confusionofan_exam {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        return max(
            checkByChar(answerKey, k, 'T'),
            checkByChar(answerKey, k, 'F'),
        )
    }

    fun checkByChar(answerKey: String, k: Int, c: Char): Int {
        var subSum = 0
        var max = Int.MIN_VALUE
        val q = ArrayDeque<Int>()
        for (key in answerKey) {
            if (key == c) {
                subSum++
                continue
            }
            if (q.size != k) {
                q.add(subSum)
                subSum = 0
            } else {
                max = max(max, q.sum() + subSum + k)
                q.removeLastOrNull()
                q.add(subSum)
                subSum = 0
            }
        }
        if (max == Int.MIN_VALUE || subSum != 0) {
            max = max(max, subSum + q.sum() + k - q.size)
        }
        return max
    }
}

fun main() {
    with(___2024_maximizethe_confusionofan_exam()) {
        println(maxConsecutiveAnswers("TTFF", 2))
//        println(maxConsecutiveAnswers("TFFT", 1))
//        println(maxConsecutiveAnswers("TTFTTFTT", 1))
//        println(maxConsecutiveAnswers("F", 1))
//        println(maxConsecutiveAnswers("TF", 2))
//        println(maxConsecutiveAnswers("TTTTTFTFFT", 2))
    }
}
