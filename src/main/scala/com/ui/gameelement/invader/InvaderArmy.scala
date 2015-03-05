package com.ui.gameelement.invader

import java.awt.{Rectangle, Point, Graphics}
import com.ui.gameelement.invader.types.{Invader, DeadInvader}
import com.ui.gameelement.missile.Missile
import ArmyCommander._
import com.ui.gameelement.barricade.{Barricade, Barricades}


class InvaderArmy(val army: Seq[Invader]) {

    def draw(g: Graphics): Unit = {
        army.foreach {
            invaderSoldier =>
                invaderSoldier.draw(g)
        }
    }

    def moveTo(point: Point): InvaderArmy =
        new InvaderArmy(
            moveArmy(army, allInvaderPositionsFromStartingPoint(point)))


    def findShotInvaders(missiles:Seq[Missile]):Seq[(Missile, Invader)] = {
        def findAHit(missile:Missile, soldiers:Seq[Invader]):Option[Invader]  = {
            if(soldiers == Nil) None
            else if (hasCollided(missile, soldiers.head)) Some(soldiers.head)
            else findAHit(missile, soldiers.tail)
        }

        missiles.foldLeft(List[(Missile,Invader)]()) { (acc , missile) =>
            findAHit(missile,army) match {
                case Some(soldier) =>  (missile, soldier) :: acc
                case None          => acc
            }
        }
    }

    def findBarricadesHitWithMissiles(missiles:Seq[Missile], barricades:Barricades):Seq[(Missile, Barricade)] = {
        def findAHit(missile:Missile, barricades:Seq[Barricade]):Option[Barricade]  = {
            if(barricades == Nil) None
            else if (hasCollided(missile, barricades.head)) {
                Some(barricades.head)
            }
            else findAHit(missile, barricades.tail)
        }

        missiles.foldLeft(List[(Missile,Barricade)]()) { (acc , missile) =>
            findAHit(missile,barricades.covers) match {
                case Some(barricade) =>  (missile, barricade) :: acc
                case None            => acc
            }
        }
    }

    def makeDeadInvadersInvisible(): InvaderArmy =
        new InvaderArmy(army.map {
            invader: Invader =>
                if (invader.beenExplodingForTooLong(now))
                    makeInvisible(invader)
                else invader
        })


    private def makeInvisible(soldier: Invader):Invader = new DeadInvader(soldier.topLeft)

    def hasCollided(missile:Missile , soldier:Invader): Boolean = soldier.boundingBox.intersects(missile.boundingBox)

    def hasCollided(missile:Missile , barricade:Barricade): Boolean = barricade.boundingBox.intersects(missile.boundingBox)

    /**
     * each individual invader soldier's position
     * @return
     */
    def allArmyPositions: Seq[Rectangle] = army.map(_.boundingBox)

    def allDeadInvaders:Seq[Invader] = army.filter(_.isInstanceOf[DeadInvader])

    def getBoundingBox: Rectangle = {
        val topLeftSoldier = army(0)
        val topLeftCorner = topLeftSoldier.topLeft
        val width = topLeftSoldier.boundingBox.width * ArmyCommander.COL_CNT
        val height = topLeftSoldier.boundingBox.height * ArmyCommander.ROW_CNT

        new Rectangle(topLeftCorner.x, topLeftCorner.y, width, height)
    }

    private def now:Long = System.currentTimeMillis()
}
