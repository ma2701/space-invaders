package com.ui

import com.ui.gameelement.invader.{ArmyCommander, InvaderArmy}
import java.awt.{Rectangle, Graphics, Point}
import com.ui.util.InvaderArmyMoveDelay._
import com.ui.gameelement.invader.InvaderArmyDirection._
import com.ui.gameelement.barricade.Barricades
import com.ui.gameelement.shooter.Shooter


class SpaceInvaderGame {

    private var invaderArmy            = new InvaderArmy(ArmyCommander.formAnArmy(new Point(0, 0)))
    private var barricades: Barricades = _
    private var shooter    : Shooter     = _

    def updatedGameElements(screenWidth: Int, screenHeight: Int, g: Graphics): Unit = {
        val displayWindowBoundingBox = new Rectangle(0, 0, screenWidth, screenHeight / 2)

        displayBarricades(g, new Point(screenWidth / 5, screenHeight - (screenHeight / 5)))
        displayPlayer(g, new Point(screenWidth / 5, screenHeight - (screenHeight / 9)))

        if (isTimeToMoveArmy(System.currentTimeMillis())) {
            val point = whereToNext(displayWindowBoundingBox, invaderArmy.getBoundingBox)

            invaderArmy = invaderArmy.moveTo(point)
            invaderArmy.drawArmy(g)

        } else {

            invaderArmy.drawArmy(g)
        }

    }

    def displayBarricades(g: Graphics, location: Point) {
        if (barricades == null)
            barricades = new Barricades(location)
        barricades.draw(g)
    }

    def displayPlayer(g: Graphics, location: Point) {
        if (shooter == null)
            shooter = new Shooter(location)
        shooter.draw(g)
    }


}
