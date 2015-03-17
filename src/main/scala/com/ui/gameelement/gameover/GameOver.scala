package com.ui.gameelement.gameover

import java.awt.{Rectangle, Point}
import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement.SingleDisplayElement

case class GameOver (tplft: Point) extends Displayable(tplft) with GameOverParts {

        val parts : List[SingleDisplayElement] = parts(x,y)

        override def boundingBox: Rectangle = {
            val longestBlock = parts.sortWith( _.getBoundingBox.width > _.getBoundingBox.width)(0)
            val width        = parts.take(12).map(_.getBoundingBox.height).sum

            new Rectangle(x, y, longestBlock.getBoundingBox.getWidth.toInt, width)
        }
}
