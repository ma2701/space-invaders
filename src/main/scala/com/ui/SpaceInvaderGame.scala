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

    def updatedGameElements(screenWidth: Int, screenHeight: Int): GameElements = {

        val displayWindowBoundingBox = new Rectangle(0, 0, screenWidth, screenHeight / 2)

        barricades       = updatedBarricadePosition(screenWidth, screenHeight)
        player           = updatePlayerPositionIfRequired(screenWidth, screenHeight)
        missilesInFlight = updateMissilesPosition
        droppingBombs    = droppingBombs.addToDroppingBombs(invaderArmy.dropRandomBomb(player.tipPosition))
        droppingBombs    = updateBombsPosition(screenHeight)

        val deadInvaderMissileTuple      = invaderArmy.findShotInvaders(missilesInFlight.missiles)
        val hitBarricadesAndMissileTuple = invaderArmy.findBarricadesHitWithMissiles(missilesInFlight.missiles, barricades)

        markHitInvaders(deadInvaderMissileTuple)

        if (isTimeToMoveArmy(now))
            invaderArmy = invaderArmy.moveTo(nextPosition(displayWindowBoundingBox, invaderArmy.getBoundingBox))

        invaderArmy      = invaderArmy.makeDeadInvadersInvisible
        missilesInFlight = missilesInFlight.removeMissiles(deadInvaderMissileTuple
                                                           .collect {case t => t._1})
                                                           .removeMissiles(hitBarricadesAndMissileTuple.collect{case t=> t._1})

        GameElements(
            invaderArmy,
            missilesInFlight,
            barricades,
            player,droppingBombs,
            invaderArmy.allDeadInvaders.size )
    }

    def updatedBarricadePosition(screenWidth: Int, screenHeight: Int): Barricades = {
        val barricadeLocation: Point = new Point(screenWidth / 5, screenHeight - (screenHeight / 4))
        barricades.moveTo(barricadeLocation)
    }

    def updatePlayerPositionIfRequired(screenWidth: Int, screenHeight: Int) : Player =
        player.topLeft match {
        case p:Point if(p.x==0 && p.y==0) => player.moveTo(playerInitialPosition(screenWidth, screenHeight))
        case _                            => player

    }

    /**
     * sets the current missiles removing the one that out of screen
     * and draws the missiles
     **/
    def updateMissilesPosition: MissilesInFlight =  missilesInFlight.updatePosition.removeOffScreenMissile

    def updateBombsPosition(windowHeight:Int ): DroppingBombs  =  droppingBombs.updatePosition.removeOffScreenBombs(windowHeight)

    def getPlayerPosition: Option[Point] = Try(player.tipPosition).toOption

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
