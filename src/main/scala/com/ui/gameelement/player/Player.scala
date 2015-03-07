package com.ui.gameelement.player

import java.awt.{Rectangle, Point}
import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement.SingleDisplayElement

case class Player(tplft: Point) extends Displayable(tplft) with PlayerParts {

    val parts:List[SingleDisplayElement] = parts(x,y)

    def shootingTipPosition:Point = {
        val tip: Rectangle = parts(0).getBoundingBox

        new Point(tip.getX.toInt,tip.getY.toInt)
    }

    def moveTo(loc:Point) : Player = new Player(loc)

}
