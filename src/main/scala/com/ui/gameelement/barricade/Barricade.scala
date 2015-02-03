package com.ui.gameelement.barricade

import java.awt.{Color, Graphics, Rectangle, Point}


class Barricade(val topLeft: Point) {

    import com.ui.gameelement.barricade._

    private val x = topLeft.x
    private val y = topLeft.y

    val parts = List[Rectangle] (
        TopSection(x, y).getBoundingBox,
        TopSectionTwo(x, y).getBoundingBox,
        TopSectionThree(x, y).getBoundingBox,

        MidSectionOne(x, y).getBoundingBox,
        MidSectionTwo(x, y).getBoundingBox,
        MidSectionThree(x, y).getBoundingBox,
        MidSectionFour(x, y).getBoundingBox,

        LeftLegOne(x, y).getBoundingBox,
        LeftLegTwo(x, y).getBoundingBox,
        LeftLegThree(x, y).getBoundingBox,
        LeftLegFour(x, y).getBoundingBox,
        LeftLegFive(x, y).getBoundingBox,

        RightLegOne(x, y).getBoundingBox,
        RightLegTwo(x, y).getBoundingBox,
        RightLegThree(x, y).getBoundingBox,
        RightLegFour(x, y).getBoundingBox,
        RightLegFive(x, y).getBoundingBox
    )

    def draw(g: Graphics): Unit = {
        g.setColor(Color.GREEN)

        parts.foreach(drawBox(g, _))
    }

    def boundingBox: Rectangle = {
        val longestBlock = parts.sortWith( _.width > _.width)(0)
        val width        = parts.map(_.height).sum

        new Rectangle(x, y, longestBlock.getWidth.toInt, width)
    }

    private def drawBox(g: Graphics, rect: Rectangle): Unit = {
        g.fillRect(rect.getX.toInt, rect.getY.toInt, rect.getWidth.toInt, rect.getHeight.toInt)
    }

}