package ch.codebros.gameoflife

class Gameboard constructor(var rows: Int, var columns: Int) {

    fun getBoard(): Array<Array<Cell>> {
        return board
    }

    private var board: Array<Array<Cell>> = Array(rows) { Array(columns) { Cell() } }

    fun determineFate() {

        val futureState: MutableSet<Triple<Int, Int, Boolean>> = mutableSetOf()

        for (r in 0 until rows) {
            for (c in 0 until columns) {

                var aliveNeighbours = 0

                // check top left
                aliveNeighbours += hasNeighbor(r - 1, c - 1)
                // check top middle
                aliveNeighbours += hasNeighbor(r - 1, c)
                // check top right
                aliveNeighbours += hasNeighbor(r - 1, c + 1)


                // check left
                aliveNeighbours += hasNeighbor(r, c - 1)
                // check right
                aliveNeighbours += hasNeighbor(r, c + 1)


                // check bottom left
                aliveNeighbours += hasNeighbor(r + 1, c - 1)
                // check bottom middle
                aliveNeighbours += hasNeighbor(r + 1, c)
                // check bottom right
                aliveNeighbours += hasNeighbor(r + 1, c + 1)



                if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                    //    1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                    //    3. Any live cell with more than three live neighbours dies, as if by overpopulation.
//                    board[r][c].alive = 0
                    futureState += Triple(r, c, false)
                }
                else if (board[r][c].alive == 0 && aliveNeighbours == 3 ) {
                    //    4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
//                    board[r][c].alive = 1
                    futureState += Triple(r, c, true)
                }
                    //    2. Any live cell with two or three live neighbours lives on to the next generation.

            }
        }
        reviveAndKill(futureState);
    }

    fun reviveAndKill(futureCellState: Set<Triple<Int, Int, Boolean>>) {
        for (state in futureCellState) {
            board[state.first][state.second].alive = if (state.third) 1 else 0
        }
    }


    fun hasNeighbor(row: Int, column: Int): Int {
        var retVal = 0
        if (row < 0 || column < 0)
            retVal = 0
        else if (row >= rows || column >= columns)
            retVal = 0
        else if (board[row][column].alive == 1) {
            retVal = 1;
        }
        return retVal
    }
}






