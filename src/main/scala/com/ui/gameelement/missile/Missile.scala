package com.ui.gameelement.missile

import java.awt.{Color, Graphics, Rectangle, Point}


class Missile(val head: Point) {

     private val x = head.x
     private val y = head.y

     val parts = List[Rectangle] (
         Line(head.x, head.y).getBoundingBox
     )

     def draw(g: Graphics): Unit = {
         g.setColor(Color.RED)

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