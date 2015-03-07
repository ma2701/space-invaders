package com.ui

import com.ui.gameelement.invader.types.Invader
import com.ui.gameelement.invader.{ArmyCommander, InvaderArmy}
import java.awt._
import com.ui.util.InvaderArmyMoveDelay._
import com.ui.gameelement.invader.InvaderArmyPositionDirector._
import com.ui.gameelement.barricade.{Barricade, Barricades}
import com.ui.gameelement.player.{PlayerPositionDirector, Player}
import com.ui.gameelement.player.PlayerPositionDirector._
import scala.util.Try
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.util.MissileShootingDelay.isTimeToShootOneMissile
import com.ui.gameelement.missile.Missile
import com.ui.gameelement.bomb.DroppingBombs
import com.ui.gameelement.{CollisionDetection, GameElementPositionDirector}

object SpaceInvaderGame {
    val DEBUG_MODE = true
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

        val collidedElements = new CollisionDetection().detectAllCollidedElements(GameElements(invaderArmy, missilesInFlight, barricades, player, droppingBombs))

        markHitInvaders(collidedElements.shotInvaders)

        invaderArmy      = invaderArmy.makeDeadInvadersInvisible
        missilesInFlight = missilesInFlight.removeMissiles(collidedElements.shotInvaders
                                                           .collect {case t => t._1})
                                                           .removeMissiles(collidedElements.hitBarricadesByMissiles.collect{case t=> t._1})

        droppingBombs    = droppingBombs.removeMissiles(collidedElements.hitBarricadesByBombs.collect{case t=> t._1})
                           .removeMissiles(collidedElements.hitBarricadesByBombs.collect{case t=> t._1})

        GameElements(
            invaderArmy,
            missilesInFlight,
            barricades,
            player,
            droppingBombs)
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

    private def now:Long  = System.currentTimeMillis()

}
