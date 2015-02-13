package com.ui.gameelement.invader

import java.awt.{Rectangle, Point, Graphics}
import com.ui.gameelement.invader.Mood.{Excited, Normal}
import com.ui.gameelement.missile.Missile


class InvaderArmy(val army: Seq[Invader], val mood: InvaderArmyMood = Normal) {

    def drawArmy(g: Graphics): Unit = {
        army.foreach {
            invaderSoldier =>
                invaderSoldier.draw(g)
        }
    }

    def moveTo(point: Point): InvaderArmy = {
        val newMood = if (mood == Normal) Excited else Normal
        new InvaderArmy(ArmyCommander.formAnArmy(point, newMood), newMood)
    }

    def markShotSoldiersHit(missiles:Seq[Missile]):Unit = {
        missiles.foreach { missile =>
            army.foreach { invader =>
                if(hasCollided(missile , invader))  invader.markHitByMissile
            }
        }
    }

    def hasCollided(missile:Missile , soldier:Invader): Boolean = soldier.boundingBox.intersects(missile.boundingBox)

    /**
     * each individual invader soldier's position
     * @return
     */
    def allArmyPositions: Seq[Rectangle] = army.map(_.boundingBox)


    def getBoundingBox: Rectangle = {
        val topLeftSoldier = army(0)
        val topLeftCorner = topLeftSoldier.topLeft
        val width = topLeftSoldier.boundingBox.width * ArmyCommander.COL_CNT
        val height = topLeftSoldier.boundingBox.height * ArmyCommander.ROW_CNT

        new Rectangle(topLeftCorner.x, topLeftCorner.y, width, height)
    }
}
