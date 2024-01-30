package easy

import kotlin.math.min

class _2379_minimum_recolorsto_get_k_consecutive_black_blocks {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var wLength = blocks.substring(0, k).filter { it == 'W' }.length
        var min = wLength
        for (i in k .. blocks.lastIndex) {
            if (blocks[i - k] == 'W') {
                wLength--
            }
            if (blocks[i] == 'W') {
                wLength++
            }
            min = min(wLength, min)
        }
        return min
    }
}

fun main() {
    with(_2379_minimum_recolorsto_get_k_consecutive_black_blocks()) {
        println(minimumRecolors("WBBWWBBWBW", 7))
        println(minimumRecolors("WBWBBBW", 2))
        println(minimumRecolors("BWWWBB", 6))
        println(minimumRecolors("WWBBBWBBBBBWWBWWWB", 16))
        println(minimumRecolors("BWBBWWBBBWBWWWBWWBBWBWBBWBB", 11))
        println(minimumRecolors("WBBWWBBWBW", 7))
    }
}
