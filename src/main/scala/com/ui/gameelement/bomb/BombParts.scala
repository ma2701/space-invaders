package com.ui.gameelement.bomb

import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._
import java.awt.Color
import java.awt.Color._

trait BombParts {
    def parts(x:Int, y:Int): List[SingleDisplayElement] = List[SingleDisplayElement](
        Tail(x,y),
        Max(x,y),
        Mid(x,y),
        Min(x,y),
        Head(x,y)
    )
}

abstract class WhiteDisplayElement(x: Int, y: Int, xOffsetFromCentre: Int, yOffsetFromCentre: Int)
    extends SingleDisplayElement(x, y, xOffsetFromCentre, yOffsetFromCentre){
    override val color:Color = WHITE
}

object Tail {
    val xOffset = 1;
    val yOffset = 0
}

case class Tail(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Tail.xOffset),
    yOffset(topLeftY, Tail.yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object Max {
    val xOffset = 2;
    val yOffset = 1
}

case class Max(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Max.xOffset),
    yOffset(topLeftY, Max.yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object Mid {
    val xOffset = 1;
    val yOffset = 2
}

case class Mid (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Mid .xOffset),
    yOffset(topLeftY, Mid.yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object Min {
    val xOffset = 0;
    val yOffset = 3
}

case class Min (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Min .xOffset),
    yOffset(topLeftY, Min .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object MidSectionTwo {
    val xOffset = 0;
    val yOffset = 4
}

case class MidSectionTwo (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, MidSectionTwo .xOffset),
    yOffset(topLeftY, MidSectionTwo .yOffset),
    (17 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object Head {
    val xOffset = 1;
    val yOffset = 4
}

case class Head (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Head .xOffset),
    yOffset(topLeftY, Head .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)