package com.ui.gameelement.invader.types

import com.ui.gameelement.displayelement.SingleDisplayElement
import java.awt.Point
import com.ui.gameelement.invader.OctopusInvaderParts

case class OctopusInvader(tl: Point,
                          hit: Boolean = false) extends Invader(tl,hit) with OctopusInvaderParts{

    override val parts: List[SingleDisplayElement] = parts(x, y)

    override def getOppositeCharacterAtPoint(point: Point, isHit: Boolean): Invader = ExcitedOctopusInvader(point,isHit)

    override def pointsWorth: Int = 10
}