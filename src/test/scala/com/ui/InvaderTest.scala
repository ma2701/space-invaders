package com.ui

import org.scalatest.FunSuite
import java.awt.Graphics
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

class InvaderTest extends FunSuite with MockitoSugar {

    test("can create instance") {
        val oneInvader = new Invader(10, 10)
    }

    test("can move an invader to position ") {
        val invader = new Invader(10, 10)

        assertResult(50) {
            invader.moveTo(50,50).x
        }
    }

    test("can draw itself") {
        val invader = new Invader(10, 10)
        val mockGraphics = mock[Graphics]

        doNothing().when(mockGraphics).fillRect(1,2,3,4)

        invader.draw(mockGraphics)

        verify(mockGraphics).fillRect(1,2,3,4)

    }
}




