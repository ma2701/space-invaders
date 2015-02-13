package com.ui.gameelement.invader

import java.awt.{Graphics, Color, Rectangle, Point}
import com.ui.gameelement.Displayable

class ExplodedInvader (topLeft: Point) extends Displayable(topLeft) {
    override val color: Color = Color.RED

    override val parts = List(
        new TopRightDiagonalTop(x,y).getBoundingBox,
        new TopRightDiagonalBottom(x,y).getBoundingBox,
        new TopLeftDiagonalTop(x,y).getBoundingBox,
        new TopLeftDiagonalBottom(x,y).getBoundingBox,
        new MiddleRightDiagonalTop(x,y).getBoundingBox,
        new MiddleRightDiagonalMiddle(x,y).getBoundingBox,
        new MiddleRightDiagonalBottom(x,y).getBoundingBox,

        new MiddleLeftDiagonalTop(x,y).getBoundingBox,
        new MiddleLeftDiagonalMiddle(x,y).getBoundingBox,
        new MiddleLeftDiagonalBottom(x,y).getBoundingBox,

        new MidSectionRight(x,y).getBoundingBox,
        new MidSectionLeft(x,y).getBoundingBox,
        new BottomRightDiagonalTop(x,y).getBoundingBox,
        new BottomRightDiagonalMiddle(x,y).getBoundingBox,
        new BottomRightDiagonalBottom(x,y).getBoundingBox,

        new BottomLeftDiagonalTop(x,y).getBoundingBox,
        new BottomLeftDiagonalMiddle(x,y).getBoundingBox,
        new BottomLeftDiagonalBottom(x,y).getBoundingBox

    )

    override
    def draw(g: Graphics): Unit = {
        g.setColor(color)
        super.draw(g)
    }
}
