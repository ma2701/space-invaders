package com.ui

import java.awt.{Color, Graphics, Rectangle, Point}


class Player(val topLeft: Point) {

    import player._

    private val x = topLeft.x
    private val y = topLeft.y

    val parts = List[Rectangle] (
        TopSection(x, y).getBoundingBox,
        TopSupport(x, y).getBoundingBox,
        MidSection(x, y).getBoundingBox,
        Bottom(x, y).getBoundingBox
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