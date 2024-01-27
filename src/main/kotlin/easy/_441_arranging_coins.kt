package easy

class _441_arranging_coins {
    fun arrangeCoins(n: Int): Int {
        var coins = n
        var completeRows = 0
        for (i in 1..Int.MAX_VALUE) {
            coins -= i
            if (coins >= 0) {
                completeRows++
                if (coins == 0) {
                    return completeRows
                }
            } else {
                break
            }
        }
        return completeRows
    }
}
