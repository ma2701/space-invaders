
package com.ui.gameelement.invader

import java.awt.Point
import java.awt.{Point, Graphics}
import com.ui.gameelement.invader.types.{Invader, ExplodingInvader, DeadInvader}
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import com.ui.gameelement.missile.Missile

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

        invaderArmy.draw(mockGraphics)

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

    /**
     * "not quite" in this context means the bounding boxes are touching but have not intersected yet
     */
    test("given a missile that has not quite collided with a soldier then hasCollided returns false") {
        val invaderArmy = new InvaderArmy(List(new Invader(new Point(0,0))))

        val missiles = List(new Missile(new Point(3,27)))

        assertResult(false) {
            invaderArmy.hasCollided(missiles(0), invaderArmy.army(0))
        }
    }

    test("given a missile that has collided with a soldier then hasCollided returns true") {
        val invaderArmy = new InvaderArmy(List(new Invader(new Point(0,0))))

        val missiles = List(new Missile(new Point(0,0)))

        assert(invaderArmy.hasCollided(missiles(0), invaderArmy.army(0)))
    }

    test("given a missile that has just collided with a soldier then hasCollided returns true") {
        val invaderArmy = new InvaderArmy(List(new Invader(new Point(0,0))))

        val missiles = List(new Missile(new Point(26,0)))

        assert(invaderArmy.hasCollided(missiles(0), invaderArmy.army(0)))
    }

    test("given one exploding invader when exploding to long enough then makeDeadInvadersInvisible will make it invisible") {
        val soldier= new ExplodingInvader(new Point(0, 0), System.currentTimeMillis() - 1000)
        val invaderArmy = new InvaderArmy(List(soldier))

        val newArmy     = invaderArmy.makeDeadInvadersInvisible

        assert(newArmy.army.size === 1)

        assert(newArmy.army(0).isInstanceOf[DeadInvader])
    }

    test("given all soldiers have not been hit with missile then  makeDeadInvadersInvisible has no effect") {
        val soldier= new Invader(new Point(0, 0))
        val invaderArmy = new InvaderArmy(List(soldier))

        val newArmy     = invaderArmy.makeDeadInvadersInvisible

        assert(newArmy.army.size === 1)

        assert(newArmy.army(0).isInstanceOf[Invader])
    }
}


