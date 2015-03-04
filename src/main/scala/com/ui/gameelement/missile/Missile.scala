package com.ui.gameelement.missile

import java.awt.{Color, Graphics, Rectangle, Point}
import com.ui.gameelement.Displayable
import com.ui.gameelement.element.SingleDisplayElement

case class Missile(val head: Point) extends Displayable(head) {

    val parts = List[SingleDisplayElement]( Line(head.x, head.y) )

    def moveTo(loc: Point): Missile = new Missile(loc)
}