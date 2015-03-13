package com.ui.gameelement.invader.types

import java.awt.Point

import com.ui.gameelement.invader.ExcitedCrabInvaderParts
import com.ui.gameelement.displayelement.SingleDisplayElement

case class ExcitedCrabInvader(tl:Point, hit:Boolean) extends Invader(tl, hit) with ExcitedCrabInvaderParts {

    override val parts: List[SingleDisplayElement] = parts(x,y)

    override def getInstanceAtPoint(point: Point, isHit: Boolean): Invader =
        new CrabInvader(point,isHit)

    override def pointsWorth: Int = 30
}
