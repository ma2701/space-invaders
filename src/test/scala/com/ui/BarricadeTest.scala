package com.ui

import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar
import java.awt.{Rectangle, Point}
import com.ui.gameelement.barricade.Barricade


class BarricadeTest extends FunSuite with MockitoSugar {

    test("can create an instance") {
        val instance = new Barricade(new Point(0, 0))
    }

    test("can get the bounding box") {
        val instance = new Barricade(new Point(0, 0))

        val expectedWidth  = instance.parts.sortWith( _.width > _.width)(0).width
        val expectedHeight = instance.parts.take(12).map(_.height).sum

        assertResult(new Rectangle(0,0,expectedWidth,expectedHeight) ){
            instance.boundingBox
        }
    }


}
