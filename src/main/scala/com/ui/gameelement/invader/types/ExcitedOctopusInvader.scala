package com.ui.gameelement.invader.types

import java.awt.Point

import com.ui.gameelement.invader.ExcitedOctopusInvaderParts
import com.ui.gameelement.displayelement.SingleDisplayElement

case class ExcitedOctopusInvader(tl:Point, hit:Boolean=false) extends Invader(tl, hit) with ExcitedOctopusInvaderParts {
    override val parts: List[SingleDisplayElement] = parts(x,y)

    override def getOppositeCharacterAtPoint(point: Point, isHit: Boolean): Invader =
        new OctopusInvader(point, isHit)

    override def pointsWorth: Int = 10
}
