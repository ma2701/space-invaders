package com.ui.gameelement

import java.awt.{Point, Color, Graphics, Rectangle}
import com.ui.SpaceInvaderGame
import com.ui.gameelement.element.SingleDisplayElement

abstract class Displayable(val topLeft: Point){
    val parts:List[SingleDisplayElement]

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
        val longestBlock = parts.sortWith( _.getBoundingBox.width > _.getBoundingBox.width)(0)
        val width        = parts.map(_.getBoundingBox.height).sum

        new Rectangle(x, y, longestBlock.getBoundingBox.getWidth.toInt, width)
    }

    protected def drawBox(g: Graphics, displayElement: SingleDisplayElement): Unit = {
        g.setColor(displayElement.color)
        g.fillRect(displayElement.getBoundingBox.x,
            displayElement.getBoundingBox.y, displayElement.getBoundingBox.width, displayElement.getBoundingBox.height)
    }

    override def toString:String = s"position: ${this.topLeft} bounding box: ${boundingBox}"
}
