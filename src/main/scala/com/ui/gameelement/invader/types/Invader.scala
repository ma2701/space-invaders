package com.ui.gameelement.invader.types

import java.awt.{Point, Rectangle}

import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement._
import com.ui.util.random.RandomBoolean


object Invader {
    val INVADER_WIDTH : Int = 11 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH
    val INVADER_HEIGHT: Int = 8  * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT
}

abstract class Invader(topLeft: Point,
                   var isHit: Boolean = false) extends Displayable(topLeft)  {
    /**
     * if this one is hit by a missile then when moving turn it into an exploded invader (well it's hit so it should explode..)
     * else return an opposite opposite character than this instance. Opposite in this
     * context means if this is normal *invader then opposite of it would be an excited version. This will make
     * the invader animated on the screen
     *
     * @param point: the location to move this invader to
     * @return     : new  invader at a new location
     */
    def moveTo(point: Point): Invader =
        if (isHit)
            new ExplodedInvader(topLeft)
        else
            getOppositeCharacterAtPoint(point, isHit)

    def markHitByMissile = isHit = true

    def isHitByMissile = isHit == true

    override def boundingBox: Rectangle = new Rectangle(topLeft.x, topLeft.y, Invader.INVADER_WIDTH, Invader.INVADER_HEIGHT)

    def beenExplodingForTooLong(currentTime: Long): Boolean = false

    def feelLikeDroppingABomb: Boolean = new RandomBoolean().nextRandomTrueWithOneOutOfNChance(2)

    def makeInvisible: Invader = DeadInvader

    def pointsWorth:Int

    def getOppositeCharacterAtPoint(point:Point, isHit:Boolean):Invader
}
