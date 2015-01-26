
package com.ui.character

import java.awt.{Rectangle, Point}
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar
import com.ui.character.MovementDirection.ArmyMovement
import com.ui.character.GeneralArmyDirection.GeneralArmyDirection


class ArmyDirectionTest extends FunSuite with MockitoSugar {
    val displayWidth = 20
    val displayHeight = 24

    test("verify correct internal state is kept when moving invader army around") {
        val initialPoint = ArmyDirection.whereToNext(displayWidth,displayHeight)
        assert(new Point(8,3) == initialPoint )

        val leftEdge = makeNConsecutiveMoves(displayWidth,displayHeight, 8)
        assert(new Point(0,3) == leftEdge)

        val oneDown = ArmyDirection.whereToNext(displayWidth,displayHeight)
        assert(new Point(0,4) == oneDown)

        val oneRight = ArmyDirection.whereToNext(displayWidth,displayHeight)
        assert(new Point(1,4) == oneRight)

        val rightEdge = makeNConsecutiveMoves(displayWidth,displayHeight, 19)
        assert(new Point(20,4) == rightEdge)

        val rightEdgeOneDown = ArmyDirection.whereToNext(displayWidth,displayHeight)
        assert(new Point(20,5) == rightEdgeOneDown)

        assert(new Point(0,5) == makeNConsecutiveMoves(displayWidth, displayHeight, 20))

        val oneDown2 = ArmyDirection.whereToNext(displayWidth,displayHeight)
        assert(new Point(0,6) == oneDown2)

        val rightEdge2= makeNConsecutiveMoves(displayWidth,displayHeight, 20)
        assert(new Point(20,6) == rightEdge2)

        val oneDownThree = makeNConsecutiveMoves(displayWidth,displayHeight, (20*19) + 19)

        println(oneDownThree)

    }

    private def makeNConsecutiveMoves(displayWidth: Int, displayHeight: Int, n : Int ): Point = {
        1 to n-1 foreach {i =>
            ArmyDirection.whereToNext(displayWidth, displayHeight)
        }
        ArmyDirection.whereToNext(displayWidth, displayHeight)
    }
}









