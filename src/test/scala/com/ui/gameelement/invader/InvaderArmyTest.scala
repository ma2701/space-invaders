
package com.ui.gameelement.invader

import java.awt.Point
import java.awt.{Point, Graphics}
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

    test("given an army then invader army can move to point(x,y)") {
        val invaderArmy = new InvaderArmy(ArmyCommander.formAnArmy(startingPoint))

        val point = new Point(22,22)

       assertResult(point) {
           invaderArmy.moveTo(point).army(0).topLeft
       }
    }

    test("given an army of one then invader army can move to point(x,y) and back") {

        val invaderArmy = new InvaderArmy(ArmyCommander.formAnArmy(startingPoint))

        val point = new Point(22,22)

        assertResult(startingPoint) {
            invaderArmy.moveTo(point).moveTo(startingPoint).army(0).topLeft
        }
    }

    test("given an invader army the get its bounding box") {
        val invaderArmy = new InvaderArmy(ArmyCommander.formAnArmy(startingPoint))

        assertResult(startingPoint.x) {
            invaderArmy.getBoundingBox.getX
        }
    }


}


