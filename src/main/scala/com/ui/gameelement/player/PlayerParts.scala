package com.ui.gameelement.player

import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._
import com.ui.gameelement.barricade.GreenDisplayElement


trait PlayerParts {
    def parts(x:Int, y:Int): List[SingleDisplayElement] = List[SingleDisplayElement](
        TopSection(x, y),
        TopSupport(x, y),
        MidSection(x, y),
        Bottom(x, y)
    )
}

object TopSection {
    val xOffset = 8;
    val yOffset = 0
}
case class TopSection(topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, TopSection.xOffset),
    yOffset(topLeftY, TopSection.yOffset),
    DEFAULT_ELEMENT_WIDTH,
    DEFAULT_ELEMENT_HEIGHT)

object TopSupport {
    val xOffset = 7;
    val yOffset = 1
}

case class TopSupport(topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, TopSupport.xOffset),
    yOffset(topLeftY, TopSupport.yOffset),
    (3* DEFAULT_ELEMENT_WIDTH),3*DEFAULT_ELEMENT_HEIGHT)



object MidSection{
    val xOffset = 1;
    val yOffset = 3
}

case class MidSection  (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, MidSection .xOffset),
    yOffset(topLeftY, MidSection.yOffset),
    (15* DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


object Bottom {
    val xOffset = 0;
    val yOffset = 4
}

case class Bottom  (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, Bottom .xOffset),
    yOffset(topLeftY, Bottom.yOffset),
    (17 * DEFAULT_ELEMENT_WIDTH), 5 * DEFAULT_ELEMENT_HEIGHT)
