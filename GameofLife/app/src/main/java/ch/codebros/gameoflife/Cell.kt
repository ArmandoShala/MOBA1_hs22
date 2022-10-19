package ch.codebros.gameoflife

import kotlin.random.Random

class Cell constructor(var alive: Int? = null) {
    init {
        // give any cell a random chance to be alive
        alive = Random.nextInt(0, 2)
//        alive = 0; // for test cases
    }
}

