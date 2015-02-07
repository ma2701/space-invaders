package com.ui.gameelement.missile

import java.awt.Point

object MissilePositionDirector {

    val SINGLE_HOP_IN_Y = 3

    def moveToNewPosition(missiles:List[Missile]):List[Missile] = {
        missiles.foldRight(List[Missile]()) { ( missile , acc) =>
            val loc= new Point(missile.head.getX.toInt , missile.head.getY.toInt - SINGLE_HOP_IN_Y)
            missile.moveTo(loc) :: acc
        }
    }
}
