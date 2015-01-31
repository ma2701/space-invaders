package com.ui.character

import java.awt.{Rectangle, Point, Graphics}
import com.ui.Invader
import com.ui.character.Mood.{Excited, Normal}


class InvaderArmy(val army:Seq[Invader], val mood:InvaderMood=Normal) {

    def drawArmy(g: Graphics ) :Unit  = {
        army.foreach { invaderSoldier =>
            invaderSoldier.draw(g)
        }
    }

    def moveTo(point:Point):InvaderArmy = {
        val newMood = if(mood == Normal) Excited else Normal
        new InvaderArmy(ArmyCommander.formAnArmy(point,newMood), newMood)
    }

    /**
     * each individual invader soldier's position
     * @return
     */
    def allArmyPositions:Seq[Point] = {
        army.map { invader =>
            new Point(invader.topLeft)
        }
    }

    def getBoundingBox:Rectangle = {
        val topLeftSoldier = army(0)
        val topLeftCorner = topLeftSoldier.topLeft
        val width  = topLeftSoldier.boundingBox.width * ArmyCommander.COL_CNT
        val height = topLeftSoldier.boundingBox.height* ArmyCommander.ROW_CNT

        new Rectangle(topLeftCorner.x,topLeftCorner.y, width,height)
    }

}
