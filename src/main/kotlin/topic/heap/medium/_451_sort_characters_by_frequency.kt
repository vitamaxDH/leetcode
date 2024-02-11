package topic.heap.medium

import java.util.PriorityQueue



class _451_sort_characters_by_frequency {
    fun frequencySort(s: String): String {
        val map = mutableMapOf<Char, Int>()
        s.forEach { c -> map[c] = (map[c] ?: 0) + 1 }

        val pq = PriorityQueue {
            a: Map.Entry<Char, Int>, b: Map.Entry<Char, Int> -> b.value - a.value
        }.apply {
            addAll(map.entries)
        }
        return buildString {
            while (pq.isNotEmpty()) {
                val mapByCount: Map.Entry<Char, Int> = pq.poll()
                repeat(mapByCount.value) {
                    append(mapByCount.key)
                }
            }
        }
    }
}

fun main() {
    with(_451_sort_characters_by_frequency()) {
        println(frequencySort("tree"))
    }
}
