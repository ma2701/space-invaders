package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}

class DeadInvader(tl:Point) extends Invader(tl) {
    override def draw(g:Graphics) :Unit = Unit
    override def moveTo(point:Point): Invader = new DeadInvader(point)
    override def boundingBox: Rectangle = new Rectangle(0 ,0, 0, 0)
}
