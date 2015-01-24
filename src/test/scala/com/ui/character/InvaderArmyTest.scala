package com.ui.character

import org.scalatest.FunSuite
import java.awt.{Point, Graphics}
import org.scalatest.mock.MockitoSugar
import com.ui.Invader
import org.scalatest.FunSuite
import java.awt.Graphics
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

class InvaderArmyTest extends FunSuite with MockitoSugar {

    test("can create an instance") {
        val armyOfOne = List(new Invader(11,11))

        new InvaderArmy(armyOfOne)
    }

    test("can draw an army of one") {
        val mockGraphics = mock[Graphics]
        val mockInvader = mock[Invader]

        doNothing().when(mockInvader).draw(mockGraphics)

        val armyOfOne = List(mockInvader)
        val invaderArmy = new InvaderArmy(armyOfOne)

        invaderArmy.drawArmy(mockGraphics)

        verify(mockInvader).draw(mockGraphics)
    }
}


