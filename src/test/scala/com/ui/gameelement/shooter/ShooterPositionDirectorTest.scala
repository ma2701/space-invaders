package com.ui.gameelement.shooter

import org.scalatest.FunSuite
import java.awt.Point


class ShooterPositionDirectorTest extends FunSuite {

    test("given shooter at the right edge when newLocationToRight called then return None") {
        val screenWidth = 200

        val shooter = new Shooter(new Point(0,0))
        val shooterXPos = screenWidth - shooter.boundingBox.width

        assertResult(None){
            ShooterPositionDirector.newPositionToRight(
                shooter.moveTo(new Point(shooterXPos, 0)),
                screenWidth
            )
        }
    }

    test("given shooter not quite at right edge when newLocationToRight called then return Some()") {
        val screenWidth = 200

        val shooter = new Shooter(new Point(0,0))
        val shooterXPos = screenWidth - shooter.boundingBox.width - ShooterPositionDirector.SINGLE_HOP_IN_X

        assertResult(Some(new Point(shooterXPos+ShooterPositionDirector.SINGLE_HOP_IN_X,0))){
            ShooterPositionDirector.newPositionToRight(
                shooter.moveTo(new Point(shooterXPos, 0)),
                screenWidth
            )
        }
    }

    test("given shooter at left edge when newLocationToLeft called then return None") {

        val shooter = new Shooter(new Point(0,0))

        assertResult(None) {
            ShooterPositionDirector.newPositionToLeft( shooter)
        }
    }
}
