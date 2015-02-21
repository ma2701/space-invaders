package com.ui.gameelement

import java.awt.{Point, Color, Graphics, Rectangle}
import com.ui.SpaceInvaderGame

abstract class Displayable(val topLeft: Point){
    val parts:List[Rectangle]
    val color:Color

    protected val x = topLeft.x
    protected val y = topLeft.y

    def draw(g: Graphics): Unit = {
        if(SpaceInvaderGame.DEBUG_MODE){
            g.drawString(s".x:${boundingBox.x + boundingBox.width} y:${boundingBox.y + boundingBox.height}",
                boundingBox.x+ boundingBox.width, boundingBox.y + boundingBox.height)
        }

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

    override def toString:String = s"position: ${this.topLeft} bounding box: ${boundingBox}"
}
