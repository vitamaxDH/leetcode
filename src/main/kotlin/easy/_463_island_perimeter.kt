package easy

class _463_island_perimeter {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var perimeter = 0
        for (i in 0 .. grid.lastIndex) {
            for (j in 0 .. grid[i].lastIndex) {
                if (grid[i][j] == 0) continue
                if (i - 1 < 0) {
                    perimeter++
                } else if (grid[i - 1][j] == 0) {
                    perimeter++
                }
                if (j + 1 > grid[i].lastIndex){
                    perimeter++
                } else if (grid[i][j + 1] == 0) {
                    perimeter++
                }
                if (i + 1 > grid.lastIndex){
                    perimeter++
                } else if (grid[i + 1][j] == 0) {
                    perimeter++
                }
                if (j - 1 < 0) {
                    perimeter++
                } else if (grid[i][j - 1] == 0) {
                    perimeter++
                }
            }
        }
        return perimeter
    }
}
