package com.ui.gameelement.bomb

import java.awt.Point
import com.ui.gameelement.missile.MissilePositionDirector

object BombPositionDirector {
    // make the invader bombs drop twice as fast as players missiles .. more interesting
    val SINGLE_HOP_IN_Y = 2 * MissilePositionDirector.SINGLE_HOP_IN_Y

    def nextPosition(point: Point): Point = new Point(point.x, point.y + SINGLE_HOP_IN_Y)

}

