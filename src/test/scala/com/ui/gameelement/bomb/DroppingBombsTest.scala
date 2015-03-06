package com.ui.gameelement.bomb

import org.scalatest.FunSuite
import java.awt.Point


class DroppingBombsTest extends FunSuite {
    val defaultDisplayScreenHeight = 200
    
    test("given a bomb that has reached the bottom of the screen then call to removeOffScreen will remove ") {

        val bomb = new Bomb(new Point(10, 190))

        val droppingBombs = new DroppingBombs(Seq(bomb))

        assertResult(0) {
            droppingBombs.removeOffScreenBombs(defaultDisplayScreenHeight).getBombCount
        }
    }

    test("given a bomb that has not reached the bottom of the screen then call to removeOffScreen will not remove the bomb ") {
    
        val bomb = new Bomb(new Point(10, 150))

        val droppingBombs = new DroppingBombs(Seq(bomb))

        assertResult(1) {
            droppingBombs.removeOffScreenBombs(defaultDisplayScreenHeight).getBombCount
        }
    }

    test("given a bomb that is touching the bottom of the screen then call to removeOffScreen will not remove the bomb ") {

        val bomb = new Bomb(new Point(10, 185))
        val droppingBombs = new DroppingBombs(Seq(bomb))

        assertResult(1) {
            droppingBombs.removeOffScreenBombs(defaultDisplayScreenHeight).getBombCount
        }
    }

    test("given two bombs dropping then call to updatePosition will update bomb poistions") {
        val bomb1 = new Bomb(new Point(10, 12))
        val bomb2 = new Bomb(new Point(10, 100))

        val droppingBombs = new DroppingBombs(Seq(bomb1,bomb2))

        val newDroppingBombs = droppingBombs.updatePosition

        assert(2 === newDroppingBombs.getBombCount)

        // as the bombs drop they do not move in X axis
        assert(bomb1.topLeft.x === newDroppingBombs.bombs(0).topLeft.x)
        // movement happens in Y axis only
        assert(bomb1.topLeft.y < newDroppingBombs.bombs(0).topLeft.y)
    }

}
