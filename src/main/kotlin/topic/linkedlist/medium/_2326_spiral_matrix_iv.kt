package topic.linkedlist.medium

import common.ListNode
import common.createLinkedList

class _2326_spiral_matrix_iv {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        head ?: return emptyArray()
        val result = mutableListOf<IntArray>().apply {
            repeat(m) { add(IntArray(n) { -1 }) }
        }
        var leftEnd = 0
        var rightEnd = n - 1
        var downEnd = m - 1
        var upEnd = 1
        var direction = 'r'

        var rowIdx = 0
        var columnIdx = 0
        var cur = head

        while (cur != null) {
            when (direction) {
                'r' -> {
                    result[rowIdx][columnIdx] = cur.`val`
                    if (columnIdx == rightEnd) {
                        println("make down at rowIdx: $rowIdx, cIdx: $columnIdx, value: ${cur.`val`}")
                        rightEnd--
                        rowIdx++
                        direction = 'd'
                    } else {
                        columnIdx++
                    }
                }
                'd' -> {
                    result[rowIdx][columnIdx] = cur.`val`
                    if (rowIdx == downEnd) {
                        println("make left at rowIdx: $rowIdx, cIdx: $columnIdx, value: ${cur.`val`}")
                        downEnd--
                        columnIdx--
                        direction = 'l'
                    } else {
                        rowIdx++
                    }
                }
                'l' -> {
                    result[rowIdx][columnIdx] = cur.`val`
                    if (columnIdx == leftEnd) {
                        println("make up at rowIdx: $rowIdx, cIdx: $columnIdx, value: ${cur.`val`}")
                        leftEnd++
                        rowIdx--
                        direction = 'u'
                    } else {
                        columnIdx--
                    }
                }
                'u' -> {
                    result[rowIdx][columnIdx] = cur.`val`
                    if (rowIdx == upEnd) {
                        println("make right at rowIdx: $rowIdx, cIdx: $columnIdx, value: ${cur.`val`}")
                        upEnd++
                        columnIdx++
                        direction = 'r'
                    } else {
                        rowIdx--
                    }
                }
            }
            cur = cur.next
        }
        return result.toTypedArray()
    }
}

fun main() {
    with(_2326_spiral_matrix_iv()) {
        spiralMatrix(3, 5, createLinkedList(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)).map { it.toList() }
            .forEach(::println)
        spiralMatrix(1, 4, createLinkedList(0,1,2)).map { it.toList() }
            .forEach(::println)
        spiralMatrix(10, 8, createLinkedList(483,100,904,632,267,352,386,887,753)).map { it.toList() }
            .forEach(::println)
        spiralMatrix(8, 7, createLinkedList(405,341,910,645,954,915,447,924,263,350,472,1,481,972,807,970,898,525,318,620,21,922,231,192,659,976,153,130,273,997,889,488,528,832,768,444,894,682,116,569,305,112,259,810,898,831,675,165,224,367,959,783,477,974)).map { it.toList() }
            .forEach(::println)
    }
}
