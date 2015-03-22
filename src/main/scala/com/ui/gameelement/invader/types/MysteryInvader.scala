package com.ui.gameelement.invader.types

import java.awt.{Rectangle, Point}
import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.invader.{MysteryInvaderMovementDirection, MysteryInvaderParts}
import com.ui.gameelement.invader.MysteryInvaderDirection.{LeftToRight, RightToLeft}
import com.ui.util.random.{RandomBoolean, RandomNumberGenerator}

object MysteryInvader {
    val INVADER_WIDTH : Int = 13 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH
    val INVADER_HEIGHT: Int = 7 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT
    val possiblePoints      = List(100, 200, 400, 800)

    def initialPositionOnRight(screenWidth: Int) = new Point(screenWidth - 10, 20)

    def initialPositionOnLeft = new Point(10, 20)

    val ODDS_OF_INSTANCE_CREATION = 1000

    /**
     * There is ~ 1 in ODDS_OF_INSTANCE_CREATION chance that this creates an instance of MysteryInvader
     * and 50% chance the created instance starts on the left side of the screen
     **/
    def maybeCreateAnInstance(screenWidth: Int): Option[MysteryInvader] = {
        val random = new RandomBoolean()

        if (random.nextRandomTrueWithOneOutOfNChance(ODDS_OF_INSTANCE_CREATION)) {
            if (random.nextRandomTrueWithOneOutOfNChance(2)) {
                Some(new MysteryInvader(initialPositionOnLeft, LeftToRight))
            } else {
                Some(new MysteryInvader(initialPositionOnRight(screenWidth), RightToLeft))
            }
        } else None
    }
}

case class MysteryInvader(tl: Point,
                          val direction: MysteryInvaderMovementDirection = RightToLeft,
                          hit: Boolean = false) extends Invader(tl, hit) with MysteryInvaderParts {

    import MysteryInvader._

    override val parts: List[SingleDisplayElement] = parts(x, y)

    override def boundingBox: Rectangle =
        new Rectangle(topLeft.x, topLeft.y, INVADER_WIDTH, INVADER_HEIGHT)

    override def getOppositeCharacterAtPoint(point: Point, isHit: Boolean): Invader =
        new MysteryInvader(point, direction, hit)

    override def pointsWorth: Int =
        possiblePoints(new RandomNumberGenerator().next(0.to(possiblePoints.size - 1)))

    def removeIfOffScreen(displayW: Int): Option[MysteryInvader] = direction match {
        case RightToLeft if (topLeft.x + this.boundingBox.width <= 0) => None
        case RightToLeft => Some(this)
        case LeftToRight if (topLeft.x >= displayW) => None
        case LeftToRight => Some(this)
    }
}