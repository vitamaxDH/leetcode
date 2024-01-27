package easy

class _415_add_strings {
    fun addStrings(num1: String, num2: String): String {
        val minLenNum = if (num1.length > num2.length) num2 else num1
        val maxLenNum = if (minLenNum == num1) num2 else num1
        val sb = StringBuilder()
        var carried = false
        for (i in 0..maxLenNum.lastIndex) {
            val maxLenDigit = maxLenNum[maxLenNum.lastIndex - i].digitToInt()
            var sum = if (minLenNum.lastIndex - i >= 0) {
                val minLenDigit = minLenNum[minLenNum.lastIndex - i].digitToInt()
                minLenDigit + maxLenDigit
            } else {
                maxLenDigit
            }
            sum += if (carried) {
                1
            } else {
                0
            }
            carried = sum / 10 > 0
            sb.insert(0, sum % 10)
        }
        return if (carried) sb.insert(0, 1).toString() else sb.toString()
    }
}
