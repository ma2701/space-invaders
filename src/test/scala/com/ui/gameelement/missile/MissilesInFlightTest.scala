package com.ui.gameelement.missile

import org.scalatest.FunSuite
import java.awt.Point


class MissilesInFlightTest extends FunSuite {

    test("can create instance") {
        new MissilesInFlight
    }

    test("can add a missile") {
        assertResult(1){
            new MissilesInFlight().addToMissiles(new Missile(new Point(0,0))).getMissileCount
        }
    }

    test("can remove a missile") {
        val missiles = List(
            new Missile(new Point(0, 0)),
            new Missile(new Point(10, 10)))

        val missilesInFlight= new MissilesInFlight(missiles).removeMissile(missiles(0))

        assertResult(1){
            missilesInFlight.getMissileCount
        }
        assertResult(new Point(10, 10)){
            missilesInFlight.missiles(0).topLeft
        }
    }

    test("can move all missiles to point x,y on screen") {
        val missiles = List(new Missile(new Point(10, 10)))

        val missilesInFlight= new MissilesInFlight(missiles).updatePosition

        assertResult(new Point(10, 7)){
            missilesInFlight.missiles(0).topLeft
        }
    }

    test("can remove missile that is off screen") {

        val missiles = List(new Missile(new Point(10, -1)))

        val missilesInFlight= new MissilesInFlight(missiles).removeOffScreenMissile

        assertResult(0){
            missilesInFlight.missiles.size
        }
    }

    test("can remove the oldest missile fired off screen") {

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
