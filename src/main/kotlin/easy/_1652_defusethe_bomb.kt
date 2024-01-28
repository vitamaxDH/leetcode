package easy

class _1652_defusethe_bomb {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val res = IntArray(code.size) { 0 }
        return if (k == 0) {
            res
        } else if (k > 0) {
            for (i in code.indices) {
                var sum = 0
                repeat(k) {
                    sum += code[(i + 1 + it) % code.size]
                }
                res[i] = sum
            }
            res
        } else {
            for (i in code.indices) {
                var sum = 0
                repeat(k * -1) {
                    val subIdx = i - 1 - it
                    val idx = if (subIdx < 0) {
                        code.size + (subIdx % code.size)
                    } else {
                        subIdx
                    }
                    sum += code[idx]
                }
                res[i] = sum
            }
            res
        }
    }
}

fun main() {
    with(_1652_defusethe_bomb()) {
//        println(decrypt(intArrayOf(5,7,1,4), 3).toList())
//        println(decrypt(intArrayOf(1,2,3,4), 0).toList())
        println(decrypt(intArrayOf(2,4,9,3), -2).toList())
    }
}
