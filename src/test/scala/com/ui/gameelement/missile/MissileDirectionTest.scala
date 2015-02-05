package com.ui.gameelement.missile

import org.scalatest.FunSuite
import java.awt.Point


class MissileDirectionTest extends FunSuite {
    
    test("can an array of missles of size 0") {
        val missile = Nil

        assertResult(Nil) {
            MissileDirection.move(missile)
        }
    }


    test("can move an array of 1 missile") {
        val missile = List(new Missile(new Point(0,0)))
        val missileMoved = MissileDirection.move(missile)

        assert(1== missileMoved.size )
        assertResult(new Point(0, -MissileDirection.SINGLE_HOP_IN_Y)){
            missileMoved.head.head
        }
    }

}

