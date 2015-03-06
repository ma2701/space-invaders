package com.ui.gameelement.invader.types

import java.awt.{Graphics, Point, Rectangle}

import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement._
import com.ui.gameelement.invader.InvaderParts
import com.ui.util.RandomNumberGenerator


object Invader {
    val INVADER_WIDTH : Int = 11 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH
    val INVADER_HEIGHT: Int = 8 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT
}

case class Invader(tl: Point,
                   var isHit: Boolean = false) extends Displayable(tl) with InvaderParts {

    override val parts: List[SingleDisplayElement] = parts(x, y)

    /**
     * if this one is hit by a missile then when moving turn it into an exploded invader (well it's hit so it should explode..)
     * else return an excited invader. This will make the invader animated on the screen
     *
     * @param point: the location to move this invader to
     * @return     : new  invader at a new location
     */
    def moveTo(point: Point): Invader =
        if (isHit)
            new ExplodedInvader(topLeft)
        else
            new ExcitedInvader(point, isHit)

    def markHitByMissile = isHit = true

    def isHitByMissile = isHit == true

    override def boundingBox: Rectangle = new Rectangle(x, y, Invader.INVADER_WIDTH, Invader.INVADER_HEIGHT)

    def beenExplodingForTooLong(currentTime: Long): Boolean = false

    def feelLikeDroppingABomb: Boolean = new RandomNumberGenerator().randomTrueOrFalse
}
