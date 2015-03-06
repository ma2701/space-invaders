package com.ui.gameelement.bomb

import java.awt.{Point, Rectangle}

import com.ui.gameelement.Displayable
import com.ui.gameelement.displayelement.SingleDisplayElement


case class Bomb(tplft: Point) extends Displayable(tplft) with BombParts {

    val parts : List[SingleDisplayElement] = parts(x,y)

    def tip :Int = y + boundingBox.height

    def moveTo(loc: Point): Bomb = new Bomb(loc)

    override def boundingBox: Rectangle =
        new Rectangle(
            x,
            y,
            3 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH,
            5 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

}
