package com.ui

import com.ui.gameelement.invader.types.Invader
import com.ui.gameelement.invader.{InvaderArmyPositionDirector, ArmyCommander, InvaderArmy}
import java.awt._
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.player.PlayerPositionDirector
import scala.util.Try
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.util.MissileShootingDelay.isTimeToShootOneMissile
import com.ui.gameelement.missile.Missile
import com.ui.gameelement.bomb.{Bomb, DroppingBombs}
import com.ui.gameelement.{CollidedElements, GameElementPositionManager}
import com.ui.gameelement.CollisionDetection._
import com.ui.ScoreCalculation._
import com.ui.gameelement.player.types.{ExplodedPlayer, ShootingPlayer, Player}

object SpaceInvaderGame {
    val DEBUG_MODE = false
}

class SpaceInvaderGame() {
    private[this] val initialPosition: Point = new Point(0, 0)

    private[this] var invaderArmy                            = new InvaderArmy(ArmyCommander.formAnArmy(initialPosition))
    private[this] var barricades                             = new Barricades(initialPosition)
    private[this] var player        : Player                 = new ShootingPlayer(initialPosition)
    private[this] var missilesInFlight                       = new MissilesInFlight()
    private[this] var droppingBombs                          = new DroppingBombs()
    private[this] var mysteryInvader: Option[Invader]        = None

    def updatedGameElements(positionMngr: GameElementPositionManager): GameState = {

        val gameElements   = GameElements(invaderArmy, missilesInFlight, barricades, player, droppingBombs, mysteryInvader)

        updateElementsOnScreen(positionMngr.updatePositionOfGameElements(gameElements))

        droppingBombs = droppingBombs.addToDroppingBombs(invaderArmy.dropRandomBomb(player.shootingTipPosition))

        val collidedElements = detectCollisions(GameElements(invaderArmy, missilesInFlight, barricades, player, droppingBombs, mysteryInvader))

        markHitInvaders(collidedElements.shotInvaders)
        markMysteryInvaderHit(collidedElements.mysteryInvaderHit)

        invaderArmy = invaderArmy.makeDeadInvadersInvisible

        missilesInFlight = missilesInFlight
                           .removeMissiles(firstElementInListOfTuples(collidedElements.shotInvaders))
                           .removeMissiles(firstElementInListOfTuples(collidedElements.hitBarricadesByMissiles))

        droppingBombs    = droppingBombs.removeBombs(bombsToBeRemovedOffScreen(collidedElements))
        player           = if(collidedElements.isPlayerShot) new ExplodedPlayer(player.topLeft) else player

        val elements     = GameElements(invaderArmy, missilesInFlight, barricades, player, droppingBombs, mysteryInvader)
        val pntWonRound  = calculatePointsWon(shotInvaders(collidedElements))

        GameState(elements, pntWonRound, isTimeToResetGame)
    }

    def invaderKillCount = invaderArmy.allDeadInvaders.size

    def isTimeToResetGame= (invaderArmy.isEveryoneDead) || (player.isHit && player.beenExplodingForTooLong(now))

    def resetAll:SpaceInvaderGame= {
        InvaderArmyPositionDirector.resetAll
        new SpaceInvaderGame
    }

    def getPlayerPosition: Option[Point] = Try(player.shootingTipPosition).toOption

    def shootSingleMissileFrom(position: Point): Unit =
        if (isTimeToShootOneMissile(now)) {
            missilesInFlight = missilesInFlight.addToMissiles(new Missile(position))
        }

    def movePlayerLeft: Unit =
        player = PlayerPositionDirector.newPositionToLeft(player).map(player.moveTo).getOrElse(player)

    def movePlayerRight(screenWidth: Int): Unit =
        player = PlayerPositionDirector.newPositionToRight(player, screenWidth).map(player.moveTo).getOrElse(player)

    private def markHitInvaders(shotSoldiersAndBulletsThatKilledThem: Seq[(Missile, Invader)]) {
        shotSoldiersAndBulletsThatKilledThem.foreach {
            t => t._2.markHitByMissile
        }
    }

    private def markMysteryInvaderHit(possibleHit: Option[(Missile, Invader)]) = {
        possibleHit.map { t =>
            t._2.markHitByMissile
        }
    }

    private def shotInvaders(collidedElements: CollidedElements): Seq[Invader] =
        collidedElements.mysteryInvaderHit.map{t=> Seq(t._2)}.getOrElse(Nil) ++
            secondElementInListOfTuples(collidedElements.shotInvaders)

    private def bombsToBeRemovedOffScreen(collidedElements: CollidedElements): Seq[Bomb] =
        firstElementInListOfTuples(collidedElements.hitBarricadesByBombs)

    private def firstElementInListOfTuples[E, T](list: Seq[(E, T)]): Seq[E] = list.collect {
        case t => t._1
    }

    private def secondElementInListOfTuples[E, T](list: Seq[(E, T)]): Seq[T] = list.collect {
        case t => t._2
    }

    private def updateElementsOnScreen(updatedGameElements: GameElements)= {
        barricades       = updatedGameElements.barricades
        player           = updatedGameElements.player
        missilesInFlight = updatedGameElements.missilesInFlight
        droppingBombs    = updatedGameElements.droppingBombs
        invaderArmy      = updatedGameElements.invaderArmy
        mysteryInvader   = updatedGameElements.mysteryInvader
    }

    private def now: Long = System.currentTimeMillis()

}
