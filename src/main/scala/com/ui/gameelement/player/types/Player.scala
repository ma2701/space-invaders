package com.ui.gameelement.player.types

import java.awt.Point
import com.ui.gameelement.Displayable


abstract class Player(topLet:Point, var isHit: Boolean=false ) extends Displayable(topLet) {

    def shootingTipPosition:Point

    def moveTo(loc:Point) : Player = getInstanceAtPosition(loc)

    def getInstanceAtPosition(pos:Point):Player

    def beenExplodingForTooLong(currentTime: Long): Boolean = false

}


