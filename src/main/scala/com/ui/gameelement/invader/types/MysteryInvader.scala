package com.ui.gameelement.invader.types

import java.awt.Point
import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.invader.MysteryInvaderParts
import com.ui.util.RandomNumberGenerator

case class MysteryInvader(tl:Point, hit:Boolean = false) extends Invader(tl,hit) with MysteryInvaderParts {
    override val parts: List[SingleDisplayElement] = parts(x,y)

    override def getOppositeCharacterAtPoint(point: Point, isHit: Boolean): Invader =
        new ExcitedCrabInvader(point,isHit)

    override def pointsWorth: Int = new RandomNumberGenerator().next(20.to(200))
}
