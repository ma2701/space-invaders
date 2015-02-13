package com.ui

import com.ui.gameelement.invader.{ArmyCommander, InvaderArmy}
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
    private var shooter    : Shooter   = _

    private var missiles= List[Missile]()


    def updatedGameElements(screenWidth: Int, screenHeight: Int, g: Graphics): Unit = {
        val displayWindowBoundingBox = new Rectangle(0, 0, screenWidth, screenHeight / 2)

        displayBarricades(g, new Point(screenWidth / 5, screenHeight - (screenHeight / 5)))
        displayShooter(g,shooterInitialPosition(screenWidth,screenHeight))
        displayMissiles(g)

        if (isTimeToMoveArmy(System.currentTimeMillis())) {
            val point = nextPosition(displayWindowBoundingBox, invaderArmy.getBoundingBox)

            invaderArmy = invaderArmy.moveTo(point)
            invaderArmy.markShotSoldiersHit(missiles)
            invaderArmy.drawArmy(g)

        } else {

            invaderArmy.markShotSoldiersHit(missiles)
            invaderArmy.drawArmy(g)
        }
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
     * sets the current missiles (filtering the ones that out of screen)
     * and draws the missiles
     * */
    def displayMissiles(g: Graphics) :Unit = {
        missiles = MissilePositionDirector.moveToNewPosition(missiles).filter(_.head.y >= 0)
        missiles foreach(_.draw(g))
    }

    def getShooterPosition: Option[Point] =  Try(shooter.tipPosition).toOption

    def shootSingleMissileFrom(position:Point):Unit = missiles =  new Missile(position) :: missiles

    def moveShooterLeft:Unit  =
        shooter = ShooterPositionDirector.newPositionToLeft(shooter).map(shooter.moveTo).getOrElse(shooter)

    def moveShooterRight(screenWidth: Int):Unit =
        shooter = ShooterPositionDirector.newPositionToRight(shooter, screenWidth).map(shooter.moveTo).getOrElse(shooter)
}
