package com.ui.gameelement.invader

import java.awt.Point
import com.ui.gameelement.invader.types.MysteryInvader

object MysteryInvaderPositionDirector {
    val SINGLE_HOP_IN_X = 4

    def nextPosition(invader:MysteryInvader):Point =
        new Point(invader.topLeft.x- SINGLE_HOP_IN_X, invader.topLeft.y)
}
