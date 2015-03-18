package com.ui

import com.ui.gameelement.invader.types.CrabInvader
import org.scalatest.FunSuite
import java.awt.{Point, Graphics}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.mockito.Matchers._

class CrabInvaderTest extends FunSuite with MockitoSugar {

    test("given a crab invader then it can be moved to position x,y") {
        val invader = new CrabInvader(new Point(10, 10))

        assertResult(50) {
            invader.moveTo(new Point(50,50)).topLeft.x
        }
    }

    test("given a crab invader then it can draw itself") {
        val invader = new CrabInvader(new Point(10, 10))
        val mockGraphics = mock[Graphics]

        doNothing().when(mockGraphics).fillRect(anyInt(), anyInt(), anyInt(), anyInt())

        invader.draw(mockGraphics)

        verify(mockGraphics, times(16)).fillRect(anyInt(), anyInt(), anyInt(), anyInt())
    }
}




