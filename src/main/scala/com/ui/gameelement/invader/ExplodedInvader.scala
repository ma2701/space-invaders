package com.ui.gameelement.invader

import java.awt.Point
import com.ui.gameelement.Displayable
import com.ui.gameelement.element.SingleDisplayElement

class ExplodedInvader (topLeft: Point) extends Displayable(topLeft) {
    override val parts = List[SingleDisplayElement](
        new TopRightDiagonalTop(x,y),
        new TopRightDiagonalBottom(x,y),
        new TopLeftDiagonalTop(x,y),
        new TopLeftDiagonalBottom(x,y),
        new MiddleRightDiagonalTop(x,y),
        new MiddleRightDiagonalMiddle(x,y),
        new MiddleRightDiagonalBottom(x,y),

        new MiddleLeftDiagonalTop(x,y),
        new MiddleLeftDiagonalMiddle(x,y),
        new MiddleLeftDiagonalBottom(x,y),

        new MidSectionRight(x,y),
        new MidSectionLeft(x,y),
        new BottomRightDiagonalTop(x,y),
        new BottomRightDiagonalMiddle(x,y),
        new BottomRightDiagonalBottom(x,y),

        new BottomLeftDiagonalTop(x,y),
        new BottomLeftDiagonalMiddle(x,y),
        new BottomLeftDiagonalBottom(x,y)

    )
}
