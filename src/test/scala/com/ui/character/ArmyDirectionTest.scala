
package com.ui.character

import java.awt.{Rectangle, Point}
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar


class ArmyDirectionTest extends FunSuite with MockitoSugar {

    /**
     *
     * TODO:rewite this test so that it is not sensitive to size changes
     */
    test("verify correct internal state is kept when moving invader army around") {
//        val army          = new InvaderArmy(ArmyCommander.formAnArmy(new Point(0,0)))
//        val displayWindow = new Rectangle(0,0,army.getBoundingBox.width + 10,army.getBoundingBox.height + 10)
//
//        val initialPoint = ArmyDirection.whereToNext(displayWindow, army.getBoundingBox)
//        assert(new Point(5,5) == initialPoint )
//
//        val leftEdge = makeNConsecutiveMoves(displayWindow,army.getBoundingBox, 5)
//        assert(new Point(15,12) == leftEdge)
//
//        val oneDown = ArmyDirection.whereToNext(displayWindow, army.getBoundingBox)
//        assert(new Point(20,12) == oneDown)
//
//        val oneRight = ArmyDirection.whereToNext(displayWindow, army.getBoundingBox)
//        assert(new Point(25,12) == oneRight)
//
//        val rightEdge = makeNConsecutiveMoves(displayWindow,army.getBoundingBox,48)
//        assert(new Point(250,5) == rightEdge)
//
//        assert(new Point(245,5) == ArmyDirection.whereToNext(displayWindow, army.getBoundingBox))
    }

    private def makeNConsecutiveMoves(displayWindow:Rectangle,armyBoundingBox:Rectangle, n : Int ): Point = {
        1 to n-1 foreach {i =>
            ArmyDirection.whereToNext(displayWindow, armyBoundingBox)
        }

        ArmyDirection.whereToNext(displayWindow, armyBoundingBox)
    }
}









