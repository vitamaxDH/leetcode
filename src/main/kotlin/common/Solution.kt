package common

class Solution() {
    fun solution(maze: List<List<Long>>, n: Long): Boolean {
        if (maze[0][0] == 1L) return false

        val way = ArrayDeque<Pair<Int, Int>>()
        val visited = HashSet<Pair<Int, Int>>()
        val dx = listOf(0, 0, 1, -1)
        val dy = listOf(1, -1, 0, 0)

        val startPoint = Pair(0, 0)
        way.add(startPoint)
        visited.add(startPoint)

        while (way.isNotEmpty()) {
            val qPoint = way.removeFirst()
            val x = qPoint.first
            val y = qPoint.second

            if (x.toLong() == n - 1 && y.toLong() == n - 1) {
                return true
            }

            for (i in 0..3) {
                val newX = x + dx[i]
                val newY = y + dy[i]
                val range = 0..< n
                val point = Pair(newX, newY)

                if (newX in range && newY in range && maze[newX][newY] != 1L && !visited.contains(point)) {
                    way.add(point)
                    visited.add(point)
                }
            }
        }
        return false
    }
}

fun main() {
    with(Solution()) {
        val result = solution(
            listOf(
                listOf(0, 0, 1),
                listOf(1, 0, 0),
                listOf(1, 1, 0),
            ),
            3
        )
        println("result: $result")
        val result2 = solution(
            listOf(
                listOf(0, 1, 0, 0, 0, 1, 0, 0, 0),
                listOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
                listOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
                listOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
                listOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
                listOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
                listOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
                listOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
                listOf(0, 0, 0, 1, 0, 0, 0, 1, 1),
            ),
            9
        )
        println("result2: $result2")
    }

}
