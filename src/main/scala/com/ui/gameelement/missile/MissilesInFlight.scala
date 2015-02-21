package com.ui.gameelement.missile

import java.awt.Graphics
import com.ui.gameelement.barricade.Barricades

class MissilesInFlight(val missiles: Seq[Missile] = Nil) {

    // as missiles are fired they are added to the head hence .reverse to look at the
    // oldest missile fired
    def removeOffScreenMissile: MissilesInFlight =
        if (!missiles.isEmpty && missiles.reverse.last.head.y < 0)
            new MissilesInFlight(missiles.init) // take all but the oldest fire missile
        else this

    def updatePosition: MissilesInFlight =
        new MissilesInFlight(
            missiles.foldRight(Seq[Missile]()) {
                (missile, acc) =>
                    val loc = MissilePositionDirector.newPositionForMissile(missile)
                    missile.moveTo(loc) +: acc
            }
        )

    def removeMissile(missile: Missile): MissilesInFlight =
        new MissilesInFlight(missiles.filterNot(_ == missile))

    def removeMissiles(missilesToBeRemoved: Seq[Missile]): MissilesInFlight =
        new MissilesInFlight(this.missiles.diff(missilesToBeRemoved))

    def addToMissiles(missile: Missile): MissilesInFlight = new MissilesInFlight(missile +: missiles)

    def getMissileCount: Int = missiles.size

    def draw(g: Graphics): Unit = missiles.foreach(_.draw(g))

    def findMissilesBelowBarricades(barricades:Barricades):Seq[Missile] = {
        val targetHeight = barricades.boundingBox.y + barricades.boundingBox.height
        missiles.filter(_.head.y >= targetHeight)
    }

    def printAllMissilePositions:Unit = missiles.foreach(println)

}
