package medium

class _36_valid_sudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val visited = mutableSetOf<Char>()
        for (i in 0 .. 8) {
            for (j in 0 .. 8) {
                val row = (j / 3) + (i / 3) * 3
                val column = (j % 3) + (i * 3) - ((i / 3) * 9)
                if (board[row][column] == '.') continue
                if (visited.contains(board[row][column])) {
                    return false
                } else {
                    visited.add(board[row][column])
                }
            }
            visited.clear()
        }

        for (i in 0 .. 8) {
            // by row
            for (j in 0..8) {
                println("row: $i, column: $j")
                if (board[i][j] == '.') continue
                if (visited.contains(board[i][j])) {
                    return false
                } else {
                    visited.add(board[i][j])
                }
            }
            visited.clear()

            // by column
            for (j in 0..8) {
                println("row: $j, column: $i")
                if (board[j][i] == '.') continue
                if (visited.contains(board[j][i])) {
                    return false
                } else {
                    visited.add(board[j][i])
                }
            }
            visited.clear()
        }
        return true
    }
}
