package ch.codebros.gameoflife

class Printer constructor(var gameboard: Gameboard) {

    private val iconAlive = "❤️"
    private val iconDead = "☠️"


    fun printGameboard() {
        for (i in 0 until gameboard.rows) {
            for (j in 0 until gameboard.columns) {
                print(if (gameboard.getBoard()[i][j].alive == 1) iconAlive else iconDead)
            }
            println()
        }
    }
}
