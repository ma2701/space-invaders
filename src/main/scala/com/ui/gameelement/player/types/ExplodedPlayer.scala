package com.ui.gameelement.player.types

import java.awt.Point
import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.player.ExplodedPlayerParts

case class ExplodedPlayer(tplft: Point,
                          val explosionTime:Long= System.currentTimeMillis()) extends Player(tplft, true) with ExplodedPlayerParts {

    val parts:List[SingleDisplayElement] = parts(x,y)

    override def getInstanceAtPosition(pos: Point): Player =
        new ExplodedPlayer(tplft, explosionTime)

    override def shootingTipPosition: Point = new Point(0,0)

    // display exploded shooter for .5 second
    override def beenExplodingForTooLong(currentTime: Long): Boolean = (currentTime - explosionTime) >= 500
}
