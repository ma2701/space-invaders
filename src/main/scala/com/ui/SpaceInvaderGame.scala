package com.ui

import com.ui.gameelement.invader.types.Invader
import com.ui.gameelement.invader.{ArmyCommander, InvaderArmy}
import java.awt._
import com.ui.gameelement.barricade.{Barricade, Barricades}
import com.ui.gameelement.player.{PlayerPositionDirector, Player}
import scala.util.Try
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.util.MissileShootingDelay.isTimeToShootOneMissile
import com.ui.gameelement.missile.Missile
import com.ui.gameelement.bomb.{Bomb, DroppingBombs}
import com.ui.gameelement.{CollidedElements, GameElementPositionDirector}
import com.ui.gameelement.CollisionDetection._

object SpaceInvaderGame {
    val DEBUG_MODE = false
}

class SpaceInvaderGame() {
    private val initialPosition:Point = new Point(0,0)
    
    private var invaderArmy            = new InvaderArmy(ArmyCommander.formAnArmy(initialPosition))
    private var barricades             = new Barricades(initialPosition)
    private var player                 = new Player(initialPosition)
    private var missilesInFlight       = new MissilesInFlight()
    private var droppingBombs          = new DroppingBombs()

    def updatedGameElements(positionMngr:GameElementPositionDirector): GameElements = {

        val gameElements        = GameElements(invaderArmy, missilesInFlight, barricades, player, droppingBombs)
        val updatedGameElements = positionMngr.updatePositionOfGameElements(gameElements)

        barricades       = updatedGameElements.barricades
        player           = updatedGameElements.player
        missilesInFlight = updatedGameElements.missilesInFlight
        droppingBombs    = updatedGameElements.droppingBombs
        invaderArmy      = updatedGameElements.invaderArmy

        droppingBombs    = droppingBombs.addToDroppingBombs(invaderArmy.dropRandomBomb(player.shootingTipPosition))

        val collidedElements = detectCollisions(GameElements(invaderArmy, missilesInFlight, barricades, player, droppingBombs))

        if(collidedElements.isPlayerShot)
            return GameElements(invaderArmy, missilesInFlight, barricades, player.copy(isHit = true), droppingBombs)

        markHitInvaders(collidedElements.shotInvaders)

        invaderArmy      = invaderArmy.makeDeadInvadersInvisible

        missilesInFlight = missilesInFlight
                           .removeMissiles(firstElementInListOfTuples(collidedElements.shotInvaders))
                           .removeMissiles(firstElementInListOfTuples(collidedElements.hitBarricadesByMissiles))

        droppingBombs    = droppingBombs.removeBombs(bombsToBeRemovedOffScreen(collidedElements))

        GameElements(
            invaderArmy,
            missilesInFlight,
            barricades,
            player,
            droppingBombs
        )
    }

    def invaderKillCount: Int = invaderArmy.allDeadInvaders.size

    def getPlayerPosition: Option[Point] = Try(player.shootingTipPosition).toOption

    def shootSingleMissileFrom(position: Point): Unit =
        if(isTimeToShootOneMissile(now) ){
            missilesInFlight = missilesInFlight.addToMissiles(new Missile(position))
        }

    def movePlayerLeft: Unit =
        player = PlayerPositionDirector.newPositionToLeft(player).map(player.moveTo).getOrElse(player)

    def movePlayerRight(screenWidth: Int): Unit =
        player = PlayerPositionDirector.newPositionToRight(player, screenWidth).map(player.moveTo).getOrElse(player)

    private def markHitInvaders(shotSoldiersAndBulletsThatKilledThem: Seq[(Missile, Invader)]) {
        shotSoldiersAndBulletsThatKilledThem.foreach {
            t =>t._2.markHitByMissile
        }
    }

    private def markHitBarricades(shotSoldiersAndBulletsThatKilledThem: Seq[(Missile, Barricade)]) {
        shotSoldiersAndBulletsThatKilledThem.foreach {
            t => println(s"marking ${t._2} hit")
        }
    }

    private def bombsToBeRemovedOffScreen(collidedElements: CollidedElements): Seq[Bomb] =
        firstElementInListOfTuples(collidedElements.hitBarricadesByBombs)

    private def firstElementInListOfTuples[E,T](list: Seq[(E,T)]):Seq[E] = list.collect{
        case t=>t._1
    }

    private def now:Long  = System.currentTimeMillis()

}
