package com

import java.awt._

import com.CollisionDetection._
import com.ScoreCalculation._
import com.sound.PlayerShooting
import com.ui.GameElements
import com.ui.gameelement.GameElementPosition
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.bomb.{Bomb, FallingBombs}
import com.ui.gameelement.invader.types.Invader
import com.ui.gameelement.invader.{ArmyCommander, InvaderArmy, InvaderArmyPositionDirector}
import com.ui.gameelement.missile.{Missile, MissilesInFlight}
import com.ui.gameelement.player.PlayerPositionDirector
import com.ui.gameelement.player.types.{ExplodedPlayer, Player, ShootingPlayer}
import com.util.MissileShootingTimer.isTimeToShootOneMissile

import scala.util.Try

object SpaceInvaderGame {
    val DEBUG_MODE = false
}

class SpaceInvaderGame() {
    private[this] val initialPosition: Point = new Point

    private[this] var invaderArmy                            = new InvaderArmy(ArmyCommander.formAnArmy(initialPosition))
    private[this] var barricades                             = new Barricades(initialPosition)
    private[this] var player        : Player                 = new ShootingPlayer(initialPosition)
    private[this] var missilesInFlight                       = new MissilesInFlight()
    private[this] var fallingBombs                           = new FallingBombs()
    private[this] var mysteryInvader: Option[Invader]        = None

    def updatedGameElements(positionMngr: GameElementPosition): GameState = {

        val gameElements   = GameElements(invaderArmy, missilesInFlight, barricades, player, fallingBombs, mysteryInvader)

        updateElementsOnScreen(
            positionMngr.repositionGameElements(gameElements)
        )

        fallingBombs = fallingBombs.addToDroppingBombs(invaderArmy.dropRandomBomb(player.shootingTipPosition))

        val collidedElements = detectCollisions(GameElements(invaderArmy, missilesInFlight, barricades, player, fallingBombs, mysteryInvader))

        markHitInvaders(collidedElements.shotInvaders)
        markMysteryInvaderHit(collidedElements.mysteryInvaderHit)

        invaderArmy = invaderArmy.makeDeadInvadersInvisible

        missilesInFlight = missilesInFlight
                           .removeMissiles(firstElementInListOfTuples(collidedElements.shotInvaders))
                           .removeMissiles(firstElementInListOfTuples(collidedElements.hitBarricadesByMissiles))

        fallingBombs    = fallingBombs.removeBombs(bombsToBeRemovedOffScreen(collidedElements))
        player           = if(collidedElements.isPlayerShot) new ExplodedPlayer(player.topLeft) else player

        val elements     = GameElements(invaderArmy, missilesInFlight, barricades, player, fallingBombs, mysteryInvader)
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
            PlayerShooting.play
        }

    def movePlayerLeft: Unit =
        player = PlayerPositionDirector.newPositionToLeft(player).map(player.moveTo).getOrElse(player)

    def movePlayerRight(screenWidth: Int): Unit =
        player = PlayerPositionDirector.newPositionToRight(player, screenWidth).map(player.moveTo).getOrElse(player)

    private def markHitInvaders(shotSoldiersAndBulletsThatKilledThem: Seq[(Missile, Invader)]) {
        shotSoldiersAndBulletsThatKilledThem.foreach {
            t =>
                t._2.markHitByMissile
               // SoundEffect.playInvaderHit
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
        fallingBombs    = updatedGameElements.droppingBombs
        invaderArmy      = updatedGameElements.invaderArmy
        mysteryInvader   = updatedGameElements.mysteryInvader
    }

    private def now: Long = System.currentTimeMillis()

}
