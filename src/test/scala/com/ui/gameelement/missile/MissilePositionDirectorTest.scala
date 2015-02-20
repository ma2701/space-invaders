package com.ui.gameelement.missile

import org.scalatest.FunSuite
import java.awt.Point


class MissilePositionDirectorTest extends FunSuite {
    
    test("can get an updated missile position") {
        val missile = new Missile(new Point(0,0))

        assertResult(new Point(0,0-MissilePositionDirector.SINGLE_HOP_IN_Y)) {
            MissilePositionDirector.newPositionForMissile(missile)
        }
    }
}

