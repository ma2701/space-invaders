package com.ui.gameelement

import java.awt.{Point, Color, Graphics, Rectangle}


abstract class Displayable(val topLeft: Point){

    protected val x = topLeft.x
    protected val y = topLeft.y

    val parts:List[Rectangle]

    def draw(g: Graphics): Unit = {
        parts.foreach(drawBox(g, _))
    }

    def boundingBox: Rectangle = {
        val longestBlock = parts.sortWith( _.width > _.width)(0)
        val width        = parts.map(_.height).sum

        new Rectangle(x, y, longestBlock.getWidth.toInt, width)
    }

    protected def drawBox(g: Graphics, rect: Rectangle): Unit = {
        g.fillRect(rect.getX.toInt, rect.getY.toInt, rect.getWidth.toInt, rect.getHeight.toInt)
    }
}
