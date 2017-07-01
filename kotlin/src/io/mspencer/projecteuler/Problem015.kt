package io.mspencer.projecteuler

class GridOfRoutes(val width: Int, val height: Int) {
    private val cache = MutableList(height + 1) { MutableList<Long?>(width + 1) { null } }

    fun numberOfRoutes() = numberOfRoutes(0, 0)

    fun numberOfRoutes(row: Int, col: Int): Long {
        if (cache[row][col] == null) {
            val count = if ((row + 1 == height && col == width) || (row == height && col + 1 == width)) {
                1L
            } else {
                (if (row < height) numberOfRoutes(row + 1, col) else 0L) +
                        (if (col < width) numberOfRoutes(row, col + 1) else 0L)
            }

            cache[row][col] = count
        }

        return cache[row][col]!!
    }
}

@SolvedProblem("Number of routes through a 20×20 grid", "137846528820")
fun euler15() = GridOfRoutes(20, 20).numberOfRoutes()