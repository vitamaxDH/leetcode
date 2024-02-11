package topic.heap.medium

import java.util.PriorityQueue

class _1753_maximum_score_from_removing_stones {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        val maxHeap = PriorityQueue<Int> { a, b -> b - a }
            .apply {
            add(a)
            add(b)
            add(c)
        }

        var count = 0
        while (true) {
            val a = maxHeap.poll()
            val b = maxHeap.poll()
            if (b == 0) {
                return count
            }
            maxHeap.add(a - 1)
            maxHeap.add(b - 1)
            count++
        }

        return count

        /**
         *  The code below is not an algorithm
         */
//        if (a == b && b == c) return (a * 1.5).toInt()
//        val arr = intArrayOf(a, b, c).apply { sort() }
//        return if (arr[2] - arr[1] > arr[0]) {
//            arr[0] + arr[1]
//        } else {
//            arr[0] + (arr[1] + arr[2] - arr[0]) / 2
//        }
    }
}

fun main() {
    with(_1753_maximum_score_from_removing_stones()) {
        println(maximumScore(2,4,6))
        println(maximumScore(4,4,6))
        println(maximumScore(1,8,8))
        println(maximumScore(1,2,6))
        println(maximumScore(10,10,10))
        println(maximumScore(11,11,11))

    }
}
