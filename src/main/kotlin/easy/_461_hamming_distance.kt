package easy

class _461_hamming_distance {
    fun hammingDistance(x: Int, y: Int): Int {
        var xorResult = x xor y
        var dis = 0
        while (xorResult > 0) {
            if (xorResult and 1 == 1) {
                dis++
            }
            xorResult = xorResult shr 1
        }
        return dis
    }
//    fun hammingDistance(x: Int, y: Int): Int {
//        val (xStr, yStr) = let {
//            val xStr = x.toString(2)
//            val yStr = y.toString(2)
//
//            val xLen = xStr.length
//            val yLen = yStr.length
//
//            if (xLen == yLen) {
//                Pair(xStr, yStr)
//            } else if (xLen > yLen) {
//                val padding = buildString {
//                    repeat(xLen - yLen) {
//                        append("0")
//                    }
//                }
//                Pair(xStr, padding + yStr)
//            } else {
//                val padding = buildString {
//                    repeat(yLen - xLen) {
//                        append("0")
//                    }
//                }
//                Pair(padding + xStr, yStr)
//            }
//        }
//        var result = 0
//        for (i in 0 .. xStr.lastIndex) {
//            if (xStr[i] == '1' && yStr[i] == '0') {
//                result++
//            } else if (xStr[i] == '0' && yStr[i] == '1') {
//                result++
//            }
//        }
//
//        return result
//    }
}
