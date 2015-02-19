package com.ui

import com.ui.gameelement.invader.{Invader, DeadInvader, ArmyCommander, InvaderArmy}
import java.awt.{Rectangle, Graphics, Point}
import com.ui.util.InvaderArmyMoveDelay._
import com.ui.gameelement.invader.InvaderArmyPositionDirector._
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.shooter.{ShooterPositionDirector, Shooter}
import com.ui.gameelement.shooter.ShooterPositionDirector._
import scala.util.Try
import com.ui.gameelement.missile.{MissilePositionDirector, Missile}

class SpaceInvaderGame {

    private var invaderArmy            = new InvaderArmy(ArmyCommander.formAnArmy(new Point(0, 0)))
    private var barricades: Barricades = _
    private var shooter   : Shooter    = _

    private var missiles = List[Missile]()


    def updatedGameElements(screenWidth: Int, screenHeight: Int, g: Graphics): Unit = {

        val displayWindowBoundingBox = new Rectangle(0, 0, screenWidth, screenHeight / 2)

        displayBarricades(g, new Point(screenWidth / 5, screenHeight - (screenHeight / 5)))
        displayShooter(g, shooterInitialPosition(screenWidth, screenHeight))
        displayMissiles(g)

        val deadInvaderMissileTuple = invaderArmy.findShotInvadersAndTheMissiles(missiles)

        markHitInvaders(deadInvaderMissileTuple)

        if (isTimeToMoveArmy(System.currentTimeMillis())) {
            val point = nextPosition(displayWindowBoundingBox, invaderArmy.getBoundingBox)
            invaderArmy = invaderArmy.moveTo(point)
            invaderArmy.drawArmy(g)
        } else {
            invaderArmy.drawArmy(g)
        }

        invaderArmy = invaderArmy.makeDeadInvadersInvisible(deadInvaderMissileTuple.collect {
            case t => t._2
        })

        missiles = removeUsedMissiles(deadInvaderMissileTuple.collect {
            case t => t._1
        }).toList
    }

    def displayBarricades(g: Graphics, location: Point) {
        if (barricades == null)
            barricades = new Barricades(location)
        barricades.draw(g)
    }

    def displayShooter(g: Graphics, location: Point) {
        if (shooter == null)
            shooter = new Shooter(location)
        shooter.draw(g)
    }

    /**
     * sets the current missiles removing the one that out of screen
     * and draws the missiles
     **/
    def displayMissiles(g: Graphics): Unit = {
        missiles = MissilePositionDirector.moveToNewPosition(missiles).filter(_.head.y >= 0)
        missiles foreach (_.draw(g))
    }

    def getShooterPosition: Option[Point] = Try(shooter.tipPosition).toOption

    def shootSingleMissileFrom(position: Point): Unit = missiles = new Missile(position) :: missiles

    def moveShooterLeft: Unit =
        shooter = ShooterPositionDirector.newPositionToLeft(shooter).map(shooter.moveTo).getOrElse(shooter)

    def moveShooterRight(screenWidth: Int): Unit =
        shooter = ShooterPositionDirector.newPositionToRight(shooter, screenWidth).map(shooter.moveTo).getOrElse(shooter)

    def currentDeadInvaderCount: Int = invaderArmy.army.foldLeft(0) {
        (acc, invader) => if (invader.isInstanceOf[DeadInvader]) acc + 1 else acc
    }

    def removeUsedMissiles(missilesHitTarget: Seq[Missile]): Seq[Missile] = missiles.diff(missilesHitTarget)


    private def markHitInvaders(shotSoldiersAndBulletsThatKilledThem: Seq[(Missile, Invader)]) {
        shotSoldiersAndBulletsThatKilledThem.foreach {
            t => t._2.markHitByMissile
        }
    }

}
