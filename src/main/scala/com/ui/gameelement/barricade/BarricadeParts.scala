package com.ui.gameelement.barricade

import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._
import java.awt.Color
import java.awt.Color._

trait BarricadeParts {
    def parts(x:Int, y:Int): List[SingleDisplayElement] = List[SingleDisplayElement](
        TopSection(x, y),
        TopSectionTwo(x, y),
        TopSectionThree(x, y),

        MidSectionOne(x, y),
        MidSectionTwo(x, y),
        MidSectionThree(x, y),
        MidSectionFour(x, y),

        LeftLegOne(x, y),
        LeftLegTwo(x, y),
        LeftLegThree(x, y),
        LeftLegFour(x, y),
        LeftLegFive(x, y),

        RightLegOne(x, y),
        RightLegTwo(x, y),
        RightLegThree(x, y),
        RightLegFour(x, y),
        RightLegFive(x, y)
    )
}

abstract class GreenDisplayElement(x: Int, y: Int, xOffsetFromCentre: Int, yOffsetFromCentre: Int)
    extends SingleDisplayElement(x, y, xOffsetFromCentre, yOffsetFromCentre){
    override val color:Color = GREEN
}

object TopSection {
    val xOffset = 3;
    val yOffset = 0
}

case class TopSection(topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, TopSection.xOffset),
    yOffset(topLeftY, TopSection.yOffset),
    (11 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object TopSectionTwo {
    val xOffset = 2;
    val yOffset = 1
}

case class TopSectionTwo(topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, TopSectionTwo.xOffset),
    yOffset(topLeftY, TopSectionTwo.yOffset),
    (13 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object TopSectionThree {
    val xOffset = 1;
    val yOffset = 2
}

case class TopSectionThree (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, TopSectionThree .xOffset),
    yOffset(topLeftY, TopSectionThree .yOffset),
    (15 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object MidSectionOne {
    val xOffset = 0;
    val yOffset = 3
}

case class MidSectionOne (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, MidSectionOne .xOffset),
    yOffset(topLeftY, MidSectionOne .yOffset),
    (17 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object MidSectionTwo {
    val xOffset = 0;
    val yOffset = 4
}

case class MidSectionTwo (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, MidSectionTwo .xOffset),
    yOffset(topLeftY, MidSectionTwo .yOffset),
    (17 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object MidSectionThree {
    val xOffset = 0;
    val yOffset = 5
}

case class MidSectionThree (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, MidSectionThree .xOffset),
    yOffset(topLeftY, MidSectionThree .yOffset),
    (17 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)



object MidSectionFour {
    val xOffset = 0;
    val yOffset = 6
}

case class MidSectionFour (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, MidSectionFour .xOffset),
    yOffset(topLeftY, MidSectionFour .yOffset),
    (17 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


object LeftLegOne{
    val xOffset = 0;
    val yOffset = 7
}

case class LeftLegOne (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, LeftLegOne .xOffset),
    yOffset(topLeftY, LeftLegOne .yOffset),
    (6 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)



object LeftLegTwo{
    val xOffset = 0;
    val yOffset = 8
}

case class LeftLegTwo (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, LeftLegTwo .xOffset),
    yOffset(topLeftY, LeftLegTwo .yOffset),
    (5 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object LeftLegThree{
    val xOffset = 0;
    val yOffset = 9
}

case class LeftLegThree (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, LeftLegThree .xOffset),
    yOffset(topLeftY, LeftLegThree .yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object LeftLegFour{
    val xOffset = 0;
    val yOffset = 10
}
case class LeftLegFour (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, LeftLegFour .xOffset),
    yOffset(topLeftY, LeftLegFour .yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object LeftLegFive{
    val xOffset = 0;
    val yOffset = 11
}
case class LeftLegFive (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, LeftLegFive .xOffset),
    yOffset(topLeftY, LeftLegFive .yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


object RightLegOne{
    val xOffset = 11;
    val yOffset = 7
}

case class RightLegOne (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, RightLegOne .xOffset),
    yOffset(topLeftY, RightLegOne .yOffset),
    (6 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightLegTwo{
    val xOffset = 12;
    val yOffset = 8
}

case class RightLegTwo (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, RightLegTwo .xOffset),
    yOffset(topLeftY, RightLegTwo .yOffset),
    (5 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightLegThree{
    val xOffset = 13;
    val yOffset = 9
}

case class RightLegThree (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, RightLegThree .xOffset),
    yOffset(topLeftY, RightLegThree .yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightLegFour{
    val xOffset = 13;
    val yOffset = 10
}
case class RightLegFour (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, RightLegFour .xOffset),
    yOffset(topLeftY, RightLegFour .yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightLegFive{
    val xOffset = 13;
    val yOffset = 11
}
case class RightLegFive (topLeftX: Int, topLeftY: Int) extends GreenDisplayElement(
    xOffset(topLeftX, RightLegFive .xOffset),
    yOffset(topLeftY, RightLegFive .yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


