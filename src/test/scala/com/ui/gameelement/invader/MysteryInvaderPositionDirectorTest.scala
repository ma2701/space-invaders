package com.ui.gameelement.invader

import org.scalatest.FunSuite
import com.ui.gameelement.invader.types.MysteryInvader
import java.awt.Point
import com.ui.gameelement.invader.MysteryInvaderDirection.LeftToRight

class MysteryInvaderPositionDirectorTest extends FunSuite {

    test("given a mystery invader moving from right to left then nextPosition returns the next position on the screen") {
        val invader  =  MysteryInvader(new Point(4,0))
        val expected = new Point(4 - MysteryInvaderPositionDirector.SINGLE_HOP_IN_X,0)

        assertResult(expected) {
            MysteryInvaderPositionDirector.nextPosition(invader)
        }
    }

    test("given a mystery invader moving from left to right then nextPosition returns the next position on the screen") {
        val invader  =  MysteryInvader(new Point(4,0), direction = LeftToRight )
        val expected = new Point(4 + MysteryInvaderPositionDirector.SINGLE_HOP_IN_X,0)

        assertResult(expected) {
            MysteryInvaderPositionDirector.nextPosition(invader)
        }
    }
}
