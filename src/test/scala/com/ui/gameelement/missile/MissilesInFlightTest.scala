package com.ui.gameelement.missile


import org.scalatest.FunSuite
import java.awt.Point
import com.GameConfiguration
import GameConfiguration.currentConfig

class MissilesInFlightTest extends FunSuite {
    val initialMissilePosition: Point = new Point(10, 10)

    test("can create instance") {
        new MissilesInFlight
    }

    test("given an instance of MissileInFlight then addToMissiles adds missile to existing missiles") {
        assertResult(1){
            new MissilesInFlight()
            .addToMissiles(new Missile(new Point(0,0)))
            .missileCount
        }
    }

    test("given an instance of MissileInFlight then removeMissiles will remove the given missile ") {
        val missiles = List(
            new Missile(new Point(0, 0)),
            new Missile(initialMissilePosition))

        val missilesInFlight= new MissilesInFlight(missiles).removeMissile(missiles(0))

        assertResult(1){
            missilesInFlight.missileCount
        }
        assertResult(initialMissilePosition){
            missilesInFlight.missiles(0).topLeft
        }
    }

    test("given an instance of MissileInFlight then call to updatePosition will move missiles to a predetermined point on screen") {
        val missiles = List(new Missile(initialMissilePosition))

        val missilesInFlight= new MissilesInFlight(missiles).updatePosition

        assertResult(new Point(10, initialMissilePosition.y - currentConfig.missileVelocity)){
            missilesInFlight.missiles(0).topLeft
        }
    }

    test("given an instance of MissileInFlight then call to removeOffScreenMissile will remove the oldest shot missile if required") {

        val oldestMissileFired= new Missile(new Point(10, -1))
        val recentlyFiredMissile= new Missile(new Point(10, 200))

        val missiles = List(recentlyFiredMissile,oldestMissileFired)

        assertResult(new Point(10, 200)){
            new MissilesInFlight(missiles)
                .removeOffScreenMissile
                .missiles(0)
                .topLeft
        }
    }
}
