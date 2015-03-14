package com.ui.gameelement.player.types

import com.ui.gameelement.player.PlayerParts
import com.ui.gameelement.displayelement.SingleDisplayElement
import java.awt.{Rectangle, Point}

case class ShootingPlayer(tplft: Point, hit:Boolean = false) extends Player(tplft,hit) with PlayerParts {

    val parts:List[SingleDisplayElement] = parts(x,y)

    override def shootingTipPosition:Point = {
        val tip: Rectangle = parts(0).getBoundingBox

        new Point(tip.getX.toInt,tip.getY.toInt)
    }

    def getInstanceAtPosition(pos:Point):Player = new ShootingPlayer(pos,hit)
}
