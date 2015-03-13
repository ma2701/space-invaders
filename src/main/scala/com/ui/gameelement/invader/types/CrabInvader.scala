package com.ui.gameelement.invader.types

import java.awt.Point
import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.invader.CrabInvaderParts

case class CrabInvader(tl:Point, hit:Boolean = false) extends Invader(tl,hit) with CrabInvaderParts {
    override val parts: List[SingleDisplayElement] = parts(x,y)

    override def getInstanceAtPoint(point: Point, isHit: Boolean): Invader =
        new ExcitedCrabInvader(point,isHit)

    override def pointsWorth: Int = 30
}
