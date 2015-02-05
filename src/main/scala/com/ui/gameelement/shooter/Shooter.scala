package com.ui.gameelement.shooter

import java.awt.{Color, Graphics, Rectangle, Point}
import com.ui.gameelement.Displayable


class Shooter(topLeft: Point) extends Displayable(topLeft){

    import com.ui.gameelement.shooter._

    val parts = List[Rectangle] (
        TopSection(x, y).getBoundingBox,
        TopSupport(x, y).getBoundingBox,
        MidSection(x, y).getBoundingBox,
        Bottom(x, y).getBoundingBox
    )
    
    def tipPosition:Point = {
        val tip: Rectangle = parts(0)
        
        new Point(tip.getX.toInt,tip.getY.toInt)
    }

    override def draw(g:Graphics):Unit = {
        g.setColor(Color.GREEN)
        super.draw(g)
    }
}