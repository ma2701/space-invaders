package com.ui.gameelement.shooter

import java.awt.{Rectangle, Point}
import com.ui.gameelement.Displayable
import com.ui.gameelement.element.SingleDisplayElement


class Shooter(topLeft: Point) extends Displayable(topLeft) with ShooterParts {

    val parts:List[SingleDisplayElement] = parts(x,y)

    def tipPosition:Point = {
        val tip: Rectangle = parts(0).getBoundingBox

        new Point(tip.getX.toInt,tip.getY.toInt)
    }

    def moveTo(loc:Point) : Shooter = new Shooter(loc)

}
