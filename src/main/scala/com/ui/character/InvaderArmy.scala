package com.ui.character

import java.awt.{Point, Graphics}
import com.ui.Invader


class InvaderArmy(val army:Seq[Invader]) {

    def drawArmy(g: Graphics ) :Unit  = {
        army.foreach { invaderSoldier =>
            invaderSoldier.draw(g)
        }
    }

    def moveTo(point:Point):InvaderArmy = {
        new InvaderArmy(ArmyCommander.moveAllArmyInYDirection( point.y,
            ArmyCommander.moveAllArmyInXDirection(point.x, army)))
    }

    /**
     * each individual invader soldier's position
     * @return
     */
    def allArmyPositions:Seq[Point] = {
        army.map { invader =>
            new Point(invader.topRight)
        }
    }
}
