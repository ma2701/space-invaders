package com.ui.gameelement.shooter

import com.ui.gameelement.element.SingleDisplayElement
import com.ui.gameelement.element.SingleDisplayElement._


object TopSection {
    val xOffset = 4;
    val yOffset = 0
}

case class TopSection(topLeftX: Int, topLeftY: Int) extends SingleDisplayElement(
    xOffset(topLeftX, TopSection.xOffset),
    yOffset(topLeftY, TopSection.yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object TopSupport {
    val xOffset = 2;
    val yOffset = 1
}

case class TopSupport(topLeftX: Int, topLeftY: Int) extends SingleDisplayElement(
    xOffset(topLeftX, TopSupport.xOffset),
    yOffset(topLeftY, TopSupport.yOffset),
    (5* DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)



object MidSection{
    val xOffset = 1;
    val yOffset = 2
}

case class MidSection  (topLeftX: Int, topLeftY: Int) extends SingleDisplayElement(
    xOffset(topLeftX, MidSection .xOffset),
    yOffset(topLeftY, MidSection.yOffset),
    (7 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


object Bottom {
    val xOffset = 0;
    val yOffset = 3
}

case class Bottom  (topLeftX: Int, topLeftY: Int) extends SingleDisplayElement(
    xOffset(topLeftX, Bottom .xOffset),
    yOffset(topLeftY, Bottom.yOffset),
    (9 * DEFAULT_ELEMENT_WIDTH), 2* DEFAULT_ELEMENT_HEIGHT)