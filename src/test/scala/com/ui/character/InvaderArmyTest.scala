
package com.ui.character

import java.awt.{Point, Graphics}
import org.scalatest.FunSuite
import java.awt.{Point, Graphics}
import org.scalatest.mock.MockitoSugar
import com.ui.Invader
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

class InvaderArmyTest extends FunSuite with MockitoSugar {
    val startingPoint: Point = new Point(11, 11)

    test("can create an instance") {
        val armyOfOne = List(new Invader(startingPoint))

        new InvaderArmy(armyOfOne)
    }

    test("given a an army of one then invader army can draw it") {
        val mockGraphics = mock[Graphics]
        val mockInvader = mock[Invader]

        doNothing().when(mockInvader).draw(mockGraphics)

        val armyOfOne = List(mockInvader)
        val invaderArmy = new InvaderArmy(armyOfOne)

        invaderArmy.drawArmy(mockGraphics)

        verify(mockInvader).draw(mockGraphics)
    }

    test("given an army of one then invader army can move to point(x,y)") {
        val armyOfOne = List(new Invader(startingPoint))

        val invaderArmy = new InvaderArmy(armyOfOne)

        val point = new Point(22,22)

        invaderArmy.moveTo(point).army.foreach { invader =>
            assertResult(33) { invader.topRight.x }
            assertResult(33) { invader.topRight.y }
        }
    }


}


