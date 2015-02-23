package com.ui

import com.ui.gameelement.invader.{Invader, ArmyCommander, InvaderArmy}
import java.awt._
import com.ui.util.InvaderArmyMoveDelay._
import com.ui.gameelement.invader.InvaderArmyPositionDirector._
import com.ui.gameelement.barricade.{Barricade, Barricades}
import com.ui.gameelement.shooter.{ShooterPositionDirector, Shooter}
import com.ui.gameelement.shooter.ShooterPositionDirector._
import scala.util.Try
import com.ui.gameelement.missile.MissilesInFlight
import com.ui.util.MissileShootingDelay.isTimeToShootOneMissile
import com.ui.gameelement.missile.Missile

object SpaceInvaderGame {
    val DEBUG_MODE = false
}

class SpaceInvaderGame() {
    private val initialPosition:Point = new Point(0,0)
    
    private var invaderArmy            = new InvaderArmy(ArmyCommander.formAnArmy(initialPosition))
    private var barricades             = new Barricades(initialPosition)
    private var shooter                = new Shooter(initialPosition)
    private var missilesInFlight       = new MissilesInFlight()

    def updatedGameElements(screenWidth: Int, screenHeight: Int): GameElements = {

        val displayWindowBoundingBox = new Rectangle(0, 0, screenWidth, screenHeight / 2)

        barricades       = updatedBarricadePosition(screenWidth, screenHeight)
        shooter          = updateShooterPositionIfRequired(screenWidth, screenHeight)
        missilesInFlight = updateMissilesPosition

        val deadInvaderMissileTuple      = invaderArmy.findShotInvadersAndTheMissiles(missilesInFlight.missiles)
        val hitBarricadesAndMissileTuple = invaderArmy.findHitBarricadesAndTheMissiles(missilesInFlight.missiles, barricades)

        markHitInvaders(deadInvaderMissileTuple)

        if (isTimeToMoveArmy(now)) {
            val point   = nextPosition(displayWindowBoundingBox, invaderArmy.getBoundingBox)
            invaderArmy = invaderArmy.moveTo(point)
        }

        invaderArmy     = invaderArmy.makeDeadInvadersInvisible(deadInvaderMissileTuple.collect {case t => t._2 })
        missilesInFlight = missilesInFlight.removeMissiles(deadInvaderMissileTuple
                                                           .collect {case t => t._1})
                                                           .removeMissiles(hitBarricadesAndMissileTuple.collect{case t=> t._1})

        GameElements(
            invaderArmy,
            missilesInFlight,
            barricades,
            shooter,
            invaderArmy.allDeadInvaders.size )
    }


    def updatedBarricadePosition(screenWidth: Int, screenHeight: Int): Barricades = {
        val barricadeLocation: Point = new Point(screenWidth / 5, screenHeight - (screenHeight / 4))
        barricades.moveTo(barricadeLocation)
    }

    def updateShooterPositionIfRequired(screenWidth: Int, screenHeight: Int) : Shooter =
        shooter.topLeft match {
        case p:Point if(p.x==0 && p.y==0) => shooter.moveTo(shooterInitialPosition(screenWidth, screenHeight))
        case _                            => shooter

    }

    /**
     * sets the current missiles removing the one that out of screen
     * and draws the missiles
     **/
    def updateMissilesPosition: MissilesInFlight =  missilesInFlight.updatePosition.removeOffScreenMissile

    def getShooterPosition: Option[Point] = Try(shooter.tipPosition).toOption

    def shootSingleMissileFrom(position: Point): Unit =
        if(isTimeToShootOneMissile(now) ){
            missilesInFlight = missilesInFlight.addToMissiles(new Missile(position))
        }

    def moveShooterLeft: Unit =
        shooter = ShooterPositionDirector.newPositionToLeft(shooter).map(shooter.moveTo).getOrElse(shooter)

    def moveShooterRight(screenWidth: Int): Unit =
        shooter = ShooterPositionDirector.newPositionToRight(shooter, screenWidth).map(shooter.moveTo).getOrElse(shooter)

    private def markHitInvaders(shotSoldiersAndBulletsThatKilledThem: Seq[(Missile, Invader)]) {
        shotSoldiersAndBulletsThatKilledThem.foreach {
            t => t._2.markHitByMissile
        }
    }

    private def markHitBarricades(shotSoldiersAndBulletsThatKilledThem: Seq[(Missile, Barricade)]) {
        shotSoldiersAndBulletsThatKilledThem.foreach {
            t => println(s"marking ${t._2} hit")
        }
    }

    private def now:Long  = System.currentTimeMillis()

}
