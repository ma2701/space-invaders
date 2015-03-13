package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}
import com.ui.gameelement.displayelement.SingleDisplayElement

class DeadInvader(tl:Point) extends Invader(tl)  {

    override val parts: List[SingleDisplayElement] = Nil

    override def draw(g:Graphics) :Unit = Unit

    override def moveTo(point:Point): Invader = new DeadInvader(point)

    override def boundingBox: Rectangle = new Rectangle(0 ,0, 0, 0)

    override def feelLikeDroppingABomb: Boolean = false

    override def pointsWorth = 0

    override def getInstanceAtPoint(point: Point, isHit: Boolean): Invader = new DeadInvader(point)

}
