package ch.codebros.gameoflife

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var gb: Gameboard? = null;
    var xDimension = 36;
    var yDimension = 36;

    @Before
    fun initBoard() {
        gb = Gameboard(xDimension, yDimension)
    }

    @Test
    fun testHasNeighbor() {
        var hasNgDefault = 0;
        var hasNgOmer = 0;
        for (r in 0 until xDimension) {
            for (c in 0 until yDimension) {
                if (gb?.hasNeighbor(r, c) == 1)
                    hasNgDefault += 1

                if (hasNeighborOmer(r, c) == 1)
                    hasNgOmer += 1
            }
        }
        assertEquals(hasNgDefault, hasNgOmer)
    }

    fun hasNeighborOmer(x: Int, y: Int): Int {
        return if (gb?.getBoard()?.get(x)?.get(y)?.alive == 1) 1 else 0
    }
}