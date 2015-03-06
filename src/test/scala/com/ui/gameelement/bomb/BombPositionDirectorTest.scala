package com.ui.gameelement.bomb

import org.scalatest.FunSuite
import java.awt.Point

class BombPositionDirectorTest extends FunSuite {

    test("given current location of invader bomb then nextlocation "){

        val currentPos = new Point(0,0)

        assertResult(new Point(0, 0 + BombPositionDirector.SINGLE_HOP_IN_Y)){
            BombPositionDirector.nextPosition(currentPos)
        }
    }

}
