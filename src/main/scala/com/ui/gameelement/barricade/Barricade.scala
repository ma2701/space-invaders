package com.ui.gameelement.barricade

import java.awt.{Point, Rectangle}

import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement.SingleDisplayElement


case class Barricade(tplft: Point) extends Displayable(tplft) with BarricadeParts {

    val parts : List[SingleDisplayElement] = parts(x,y)

    override def boundingBox: Rectangle = {
        val longestBlock = parts.sortWith( _.getBoundingBox.width > _.getBoundingBox.width)(0)
        val height        = parts.take(12).map(_.getBoundingBox.height).sum

        new Rectangle(x, y, longestBlock.getBoundingBox.getWidth.toInt, height)
    }
}
