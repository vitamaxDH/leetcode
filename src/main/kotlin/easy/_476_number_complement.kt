package easy

class _476_number_complement {
    fun findComplement(num: Int): Int {
        var temp = num
        var curPos = 0
        var res = 0
        while (temp > 0) {
            if (temp and 1 == 0) {
                res += 1 shl curPos
            }
            curPos++
            temp = temp shr 1
        }
        return res
    }
}
