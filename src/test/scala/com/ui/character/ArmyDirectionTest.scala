
package com.ui.character

import java.awt.{Rectangle, Point}
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar
import com.ui.character.MovementDirection.ArmyMovement
import com.ui.character.GeneralArmyDirection.GeneralArmyDirection


class ArmyDirectionTest extends FunSuite with MockitoSugar {

    test("verify correct internal state is kept when moving invader army around") {
        val army          = new InvaderArmy(ArmyCommander.formAnArmy(new Point(0,0)))
        val displayWindow = new Rectangle(0,0,army.getBoundingBox.width + 10,army.getBoundingBox.height + 10)

        val initialPoint = ArmyDirection.whereToNext(displayWindow, army.getBoundingBox)
        assert(new Point(5,5) == initialPoint )

        val leftEdge = makeNConsecutiveMoves(displayWindow,army.getBoundingBox, 5)
        assert(new Point(0,5) == leftEdge)

        val oneDown = ArmyDirection.whereToNext(displayWindow, army.getBoundingBox)
        assert(new Point(0,6) == oneDown)

        val oneRight = ArmyDirection.whereToNext(displayWindow, army.getBoundingBox)
        assert(new Point(1,6) == oneRight)

        val rightEdge = makeNConsecutiveMoves(displayWindow,army.getBoundingBox,19)
        assert(new Point(20,6) == rightEdge)
//
//        val rightEdgeOneDown = ArmyDirection.whereToNext(displayWidth,displayHeight)
//        assert(new Point(20,5) == rightEdgeOneDown)
//
//        assert(new Point(0,5) == makeNConsecutiveMoves(displayWidth, displayHeight, 20))
//
//        val oneDown2 = ArmyDirection.whereToNext(displayWidth,displayHeight)
//        assert(new Point(0,6) == oneDown2)
//
//        val rightEdge2= makeNConsecutiveMoves(displayWidth,displayHeight, 20)
//        assert(new Point(20,6) == rightEdge2)
//
//        val oneDownThree = makeNConsecutiveMoves(displayWidth,displayHeight, (20*19) + 19)

//        println(oneDownThree)

    }

    private def makeNConsecutiveMoves(displayWindow:Rectangle,armyBoundingBox:Rectangle, n : Int ): Point = {
        1 to n-1 foreach {i =>
            ArmyDirection.whereToNext(displayWindow, armyBoundingBox)
        }

        ArmyDirection.whereToNext(displayWindow, armyBoundingBox)
    }
}









