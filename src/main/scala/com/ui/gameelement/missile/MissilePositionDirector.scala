package com.ui.gameelement.missile

import java.awt.Point

object MissilePositionDirector {

    val SINGLE_HOP_IN_Y = 3

    def newPositionForMissile(missile:Missile):Point =
        new Point(missile.head.getX.toInt , missile.head.getY.toInt - SINGLE_HOP_IN_Y)
}
