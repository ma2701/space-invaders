package com.ui.gameelement.invader.types

import java.awt.Point

import com.ui.gameelement.invader.ExplodedInvaderParts
import com.ui.gameelement.displayelement.SingleDisplayElement

class ExplodedInvader(tl:Point,
                       val explosionTime:Long= System.currentTimeMillis()) extends Invader(tl) with  ExplodedInvaderParts{

    override val parts: List[SingleDisplayElement] = parts(x,y)

    override def moveTo(point:Point): Invader = new ExplodedInvader(point, explosionTime)

    /**
     * want to show an exploding invader only for one frame and then mark it dead. this is calculating
     * if the explosion has been displayed on screen long enough
     */
    override def beenExplodingForTooLong(currentTime:Long):Boolean = (currentTime - explosionTime) >= 333

    // if the invader has been hit with a missile then it can not drop a bomb
    override def feelLikeDroppingABomb: Boolean = false

    override def pointsWorth = 0

    /**
     * once hit and exploding it does not make sense to get an opposite character
     *
     */
    override def getOppositeCharacterAtPoint(point: Point, isHit: Boolean): Invader =
        new ExplodedInvader(point,explosionTime)
}
