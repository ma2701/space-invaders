package com.ui.gameelement.missile

import java.awt.{Color, Graphics, Rectangle, Point}
import com.ui.gameelement.Displayable


class Missile(val head: Point) extends Displayable(head) {

     val parts = List[Rectangle] (
         Line(head.x, head.y).getBoundingBox
     )

    def moveTo(loc:Point): Missile = new Missile(loc)

    override
    def draw(g:Graphics):Unit = {
        g.setColor(Color.RED)
        super.draw(g)
    }
 }