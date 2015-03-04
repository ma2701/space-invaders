package com.ui.gameelement.invader

import com.ui.gameelement.element.SingleDisplayElement
import com.ui.gameelement.element.SingleDisplayElement._
import java.awt.Color
import java.awt.Color._

abstract class RedDisplayElement(x: Int, y: Int, xOffsetFromCentre: Double, yOffsetFromCentre: Double)
    extends SingleDisplayElement(xOffset(x, xOffsetFromCentre), yOffset(y, yOffsetFromCentre)){
    override val color:Color = RED
}

object TopRightDiagonalTop{
    val xOffset = 6;
    val yOffset = 0
}
case class TopRightDiagonalTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, TopRightDiagonalTop.xOffset),
    yOffset(invaderPosY, TopRightDiagonalTop.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object TopRightDiagonalBottom{
    val xOffset = 5;
    val yOffset = 1
}
case class TopRightDiagonalBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, TopRightDiagonalBottom.xOffset),
    yOffset(invaderPosY, TopRightDiagonalBottom.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

// top left diag
object TopLeftDiagonalTop{
    val xOffset = 2;
    val yOffset = 0
}
case class TopLeftDiagonalTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, TopLeftDiagonalTop.xOffset),
    yOffset(invaderPosY, TopLeftDiagonalTop.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object TopLeftDiagonalBottom{
    val xOffset = 3;
    val yOffset = 1
}
case class TopLeftDiagonalBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, TopLeftDiagonalBottom.xOffset),
    yOffset(invaderPosY, TopLeftDiagonalBottom.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)




// middle right diag
object MiddleRightDiagonalTop{
    val xOffset = 8;
    val yOffset = 1
}
case class MiddleRightDiagonalTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MiddleRightDiagonalTop.xOffset),
    yOffset(invaderPosY, MiddleRightDiagonalTop.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object MiddleRightDiagonalMiddle{
    val xOffset = 7;
    val yOffset = 2
}
case class MiddleRightDiagonalMiddle(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MiddleRightDiagonalMiddle.xOffset),
    yOffset(invaderPosY, MiddleRightDiagonalMiddle.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object MiddleRightDiagonalBottom{
    val xOffset = 6;
    val yOffset = 3
}
case class MiddleRightDiagonalBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MiddleRightDiagonalBottom.xOffset),
    yOffset(invaderPosY, MiddleRightDiagonalBottom.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

// middle left diag
object MiddleLeftDiagonalTop{
    val xOffset = 0;
    val yOffset = 1
}
case class MiddleLeftDiagonalTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MiddleLeftDiagonalTop.xOffset),
    yOffset(invaderPosY, MiddleLeftDiagonalTop.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object MiddleLeftDiagonalMiddle{
    val xOffset = 1;
    val yOffset = 2
}
case class MiddleLeftDiagonalMiddle(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MiddleLeftDiagonalMiddle.xOffset),
    yOffset(invaderPosY, MiddleLeftDiagonalMiddle.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object MiddleLeftDiagonalBottom{
    val xOffset = 2;
    val yOffset = 3
}
case class MiddleLeftDiagonalBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MiddleLeftDiagonalBottom.xOffset),
    yOffset(invaderPosY, MiddleLeftDiagonalBottom.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)





// mid section right
object MidSectionRight{
    val xOffset = 8;
    val yOffset = 3
}
case class MidSectionRight(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MidSectionRight.xOffset),
    yOffset(invaderPosY, MidSectionRight.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object MidSectionLeft{
    val xOffset = 0;
    val yOffset = 3
}
case class MidSectionLeft(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MidSectionLeft.xOffset),
    yOffset(invaderPosY, MidSectionLeft.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)



// middle right diag
object BottomRightDiagonalTop{
    val xOffset = 6;
    val yOffset = 4
}
case class BottomRightDiagonalTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, BottomRightDiagonalTop.xOffset),
    yOffset(invaderPosY, BottomRightDiagonalTop.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object BottomRightDiagonalMiddle{
    val xOffset = 7;
    val yOffset = 5
}
case class BottomRightDiagonalMiddle(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, BottomRightDiagonalMiddle.xOffset),
    yOffset(invaderPosY, BottomRightDiagonalMiddle.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object BottomRightDiagonalBottom{
    val xOffset = 8;
    val yOffset = 6
}
case class BottomRightDiagonalBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, BottomRightDiagonalBottom.xOffset),
    yOffset(invaderPosY, BottomRightDiagonalBottom.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

// middle left diag
object BottomLeftDiagonalTop{
    val xOffset = 2;
    val yOffset = 4
}
case class BottomLeftDiagonalTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, BottomLeftDiagonalTop.xOffset),
    yOffset(invaderPosY, BottomLeftDiagonalTop.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object BottomLeftDiagonalMiddle{
    val xOffset = 1;
    val yOffset = 5
}
case class BottomLeftDiagonalMiddle(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, BottomLeftDiagonalMiddle.xOffset),
    yOffset(invaderPosY, BottomLeftDiagonalMiddle.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)

object BottomLeftDiagonalBottom{
    val xOffset = 0;
    val yOffset = 6
}
case class BottomLeftDiagonalBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, BottomLeftDiagonalBottom.xOffset),
    yOffset(invaderPosY, BottomLeftDiagonalBottom.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT)



case class InvaderExploded(x:Int, y:Int) {
    val parts = List (
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
}
