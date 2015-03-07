package com.ui.gameelement.player

import org.scalatest.FunSuite
import java.awt.Point


class PlayerPositionDirectorTest extends FunSuite {

    test("given player at the right edge when newLocationToRight called then return None") {
        val screenWidth = 200

        val shooter = new Player(new Point(0,0))
        val shooterXPos = screenWidth - shooter.boundingBox.width

        assertResult(None){
            PlayerPositionDirector.newPositionToRight(
                shooter.moveTo(new Point(shooterXPos, 0)),
                screenWidth
            )
        }
    }

    test("given player not quite at right edge when newLocationToRight called then return Some()") {
        val screenWidth = 200

        val shooter = new Player(new Point(0,0))
        val shooterXPos = screenWidth - shooter.boundingBox.width - PlayerPositionDirector.SINGLE_HOP_IN_X

        assertResult(Some(new Point(shooterXPos+PlayerPositionDirector.SINGLE_HOP_IN_X,0))){
            PlayerPositionDirector.newPositionToRight(
                shooter.moveTo(new Point(shooterXPos, 0)),
                screenWidth
            )
        }
    }

    test("given player at left edge when newLocationToLeft called then return None") {

        val shooter = new Player(new Point(0,0))

        assertResult(None) {
            PlayerPositionDirector.newPositionToLeft( shooter)
        }
    }
}
