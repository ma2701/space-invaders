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

    def markShotInvadersHit(missiles:Seq[Missile]):Seq[(Missile, Invader)] = {
        def findAHit(missile:Missile, soldiers:Seq[Invader]):Option[Invader]  = {
            if(soldiers == Nil) None
            else if(hasCollided(missile, soldiers.head)) Some(soldiers.head)
            else findAHit(missile, soldiers.tail)
        }

        missiles.foldLeft(List[(Missile,Invader)]()) { (acc , missile) =>
            findAHit(missile,army) match {
                case Some(soldier) =>  (missile, soldier) :: acc
                case None          => acc
            }
        }
    }

    def makeInvadersInvisible(invaders: Seq[Invader]): InvaderArmy = {
       def putInvisibilityCloakOn(soldiers:Seq[Invader], acc:Seq[Invader]):Seq[Invader] = {
           if(soldiers == Nil) acc
           else putInvisibilityCloakOn(soldiers.tail , makeInvisible(soldiers.head, acc))
       }
        val newMood = if (mood == Normal) Excited else Normal
        new InvaderArmy(putInvisibilityCloakOn(invaders, army), newMood)
    }

    private def makeInvisible(soldier: Invader, army:Seq[Invader]): Seq[Invader] =
        army.map {
        s =>
            if (s == soldier) new DarkInvader(soldier.topLeft)
            else s
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
