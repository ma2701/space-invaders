package com.ui

import com.ui.gameelement.invader.{Invader, DeadInvader, ArmyCommander, InvaderArmy}
import java.awt.{Rectangle, Graphics, Point}
import com.ui.util.InvaderArmyMoveDelay._
import com.ui.gameelement.invader.InvaderArmyPositionDirector._
import com.ui.gameelement.barricade.{Barricade, Barricades}
import com.ui.gameelement.shooter.{ShooterPositionDirector, Shooter}
import com.ui.gameelement.shooter.ShooterPositionDirector._
import scala.util.Try
import com.ui.gameelement.missile.{MissilesInFlight, Missile}

object SpaceInvaderGame {
    val DEBUG_MODE = false
}

class SpaceInvaderGame() {

    private var invaderArmy            = new InvaderArmy(ArmyCommander.formAnArmy(new Point(0, 0)))
    private var barricades             = new Barricades(new Point(0,0))
    private var shooter   : Shooter    = _

    private var missilesInFlight       = new MissilesInFlight()

    def updatedGameElements(screenWidth: Int, screenHeight: Int, g: Graphics): Unit = {

        val displayWindowBoundingBox = new Rectangle(0, 0, screenWidth, screenHeight / 2)

        displayBarricades(g, new Point(screenWidth / 5, screenHeight - (screenHeight / 4)))
        displayShooter(g, shooterInitialPosition(screenWidth, screenHeight))
        displayMissiles(g)

        val deadInvaderMissileTuple = invaderArmy.findShotInvadersAndTheMissiles(missilesInFlight.missiles)
        val hitBarricadesAndMissileTuple = invaderArmy.findHitBarricadesAndTheMissiles(missilesInFlight.missiles, barricades)

        markHitInvaders(deadInvaderMissileTuple)

        if (isTimeToMoveArmy(System.currentTimeMillis())) {
            val point   = nextPosition(displayWindowBoundingBox, invaderArmy.getBoundingBox)
            invaderArmy = invaderArmy.moveTo(point)
            invaderArmy.drawArmy(g)
        } else {
            invaderArmy.drawArmy(g)
        }

        invaderArmy     = invaderArmy.makeDeadInvadersInvisible(deadInvaderMissileTuple.collect {case t => t._2 })

        missilesInFlight = missilesInFlight.removeMissiles(deadInvaderMissileTuple
                                                           .collect {case t => t._1})
                                                           .removeMissiles(hitBarricadesAndMissileTuple.collect{case t=> t._1})
    }

    def displayBarricades(g: Graphics, location: Point): Unit =  {
        barricades = barricades.moveTo(location)
        barricades.draw(g)
    }

    def displayShooter(g: Graphics, location: Point) : Unit = {
        if (shooter == null)
            shooter = new Shooter(location)
        shooter.draw(g)
    }

    /**
     * sets the current missiles removing the one that out of screen
     * and draws the missiles
     **/
    def displayMissiles(g: Graphics): Unit = {
        missilesInFlight = missilesInFlight.updatePosition.removeOffScreenMissile
        missilesInFlight.draw(g)
    }

    def getShooterPosition: Option[Point] = Try(shooter.tipPosition).toOption

    def shootSingleMissileFrom(position: Point): Unit =
        missilesInFlight = missilesInFlight.addToMissiles(new Missile(position))

    def moveShooterLeft: Unit =
        shooter = ShooterPositionDirector.newPositionToLeft(shooter).map(shooter.moveTo).getOrElse(shooter)

    def moveShooterRight(screenWidth: Int): Unit =
        shooter = ShooterPositionDirector.newPositionToRight(shooter, screenWidth).map(shooter.moveTo).getOrElse(shooter)

    def currentDeadInvaderCount: Int = invaderArmy.army.foldLeft(0) {
        (acc, invader) => if (invader.isInstanceOf[DeadInvader]) acc + 1 else acc
    }

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

}
