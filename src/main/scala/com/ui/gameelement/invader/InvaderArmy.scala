package com.ui.gameelement.invader

import java.awt.{Rectangle, Point, Graphics}
import com.ui.gameelement.invader.types.{DeadInvader, Invader}
import ArmyCommander._
import com.ui.gameelement.bomb.Bomb
import com.util.BombDropTimer._


class InvaderArmy(val army: Seq[Invader]) {

    def draw(g: Graphics): Unit = {
        army.foreach {
            invaderSoldier =>
                invaderSoldier.draw(g)
        }
    }

    def moveTo(point: Point): InvaderArmy =
        new InvaderArmy(
            moveArmy(army, allInvaderPositionsFromStartingPoint(point)))

    def makeDeadInvadersInvisible(): InvaderArmy =
        new InvaderArmy(army.map {
            invader: Invader =>
                if (invader.beenExplodingForTooLong(now))
                    invader.makeInvisible
                else invader
        })

    def dropRandomBomb(shooterPosition: Point): Option[Bomb] =
        filterSoldiersAboveShooter(shooterPosition) match {
            case head +: rest if (head.feelLikeDroppingABomb && isTimeToDropABomb(now)) =>
                Some(new Bomb(head.midPoint))
            case _ => None
        }

    /**
     * the army is made aware of where the player is. Only the invader soldiers that are
     * within a range from where the player is in X axis are allowed to drop a bomb.
     *
     * @return
     */
    def filterSoldiersAboveShooter(shooterPosition: Point): Seq[Invader] = {

        val delta = 2 * (Invader.INVADER_WIDTH / 2) + BUFFER_BETWEEN_SOLDIERS
        val range = (shooterPosition.x - delta) to (shooterPosition.x + delta)
        army.filter {
            invader =>
                invader.midPoint.x >= range.min && invader.midPoint.x <= range.max
        }
    }

    /**
     * each individual invader soldier's position
     */
    def allArmyPositions: Seq[Rectangle] = army.map(_.boundingBox)

    def allDeadInvaders: Seq[Invader]    = army.filter(_  == DeadInvader)

    def isEveryoneDead                   = allDeadInvaders.size == army.size

    def getBoundingBox: Rectangle = {
        val topLeftMostSoldier = army(0)
        val topLeftCorner = topLeftMostSoldier.topLeft
        val width  = armyWidth(Invader.INVADER_WIDTH  )
        val height = armyHeight(Invader.INVADER_HEIGHT)

        new Rectangle(topLeftCorner.x, topLeftCorner.y, width, height)
    }

    private def now: Long = System.currentTimeMillis()
}
