package easy

class _405_convert_a_number_to_hexadecimal {
    @OptIn(ExperimentalStdlibApi::class)
    fun toHex(num: Int): String {
        return if (num > 0) {
            var nonZeroIdx = -1
            val toHexString = num.toHexString()
            toHexString.forEachIndexed { i, e ->
               if (nonZeroIdx == -1 && e != '0') {
                   nonZeroIdx = i
               }
            }
            toHexString.substring(nonZeroIdx)
        } else if (num == 0) {
            "0"
        } else {
            num.toHexString()
        }
    }
}
