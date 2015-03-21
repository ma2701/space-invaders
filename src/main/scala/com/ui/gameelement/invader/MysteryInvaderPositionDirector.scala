package com.ui.gameelement.invader

import java.awt.Point
import com.ui.gameelement.invader.types.MysteryInvader
import com.ui.gameelement.invader.MysteryInvaderDirection.{LeftToRight, RightToLeft}

object MysteryInvaderPositionDirector {
    val SINGLE_HOP_IN_X = 1

    def nextPosition(invader: MysteryInvader): Point =
        invader.direction match {
            case RightToLeft =>
                new Point(invader.topLeft.x - SINGLE_HOP_IN_X, invader.topLeft.y)
            case LeftToRight =>
                new Point(invader.topLeft.x + SINGLE_HOP_IN_X, invader.topLeft.y)
        }

}
