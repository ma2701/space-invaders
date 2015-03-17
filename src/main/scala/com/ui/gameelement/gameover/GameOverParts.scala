package com.ui.gameelement.gameover

import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._
import com.ui.gameelement.bomb.WhiteDisplayElement

trait GameOverParts {
    def parts(x:Int, y:Int): List[SingleDisplayElement] = List[SingleDisplayElement](
       GTop(x,y),
       GMid(x,y),
       GBottom(x,y),
       GHookMid(x,y),
       GHookTop(x,y),
       ATop(x,y),
       ATopSupport(x,y),
       ABridgeLeft(x,y),
       ABridgeRight(x,y),
       ALeftLeg(x,y),
       ARightLeg(x,y),
       AMidBridge(x,y),
        MTopOne(x,y),
        MTopTwo(x,y),
        MTLeftLeg(x,y),
        MMidLeg(x,y),
        MRightLeg(x,y)
    )
}

object GTop {
    val xOffset = 1;
    val yOffset = 2
}

case class GTop(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, GTop.xOffset),
    yOffset(topLeftY, GTop.yOffset),
    (3* DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object GMid {
    val xOffset = 0;
    val yOffset = 3
}

case class GMid(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, GMid.xOffset),
    yOffset(topLeftY, GMid.yOffset),
    (DEFAULT_ELEMENT_WIDTH),3*DEFAULT_ELEMENT_HEIGHT)

object GBottom {
    val xOffset = 1;
    val yOffset = 6
}

case class GBottom(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, GBottom.xOffset),
    yOffset(topLeftY, GBottom.yOffset),
    (3*DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object GHookMid {
    val xOffset = 3;
    val yOffset = 5
}

case class GHookMid(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, GHookMid.xOffset),
    yOffset(topLeftY, GHookMid.yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object GHookTop {
    val xOffset = 2;
    val yOffset = 4
}

case class GHookTop(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, GHookTop.xOffset),
    yOffset(topLeftY, GHookTop.yOffset),
    (2*DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object ATop {
    val xOffset = 6;
    val yOffset = 2
}

case class ATop (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, ATop .xOffset),
    yOffset(topLeftY, ATop .yOffset),
    (2*DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object ATopSupport {
    val xOffset = 5;
    val yOffset = 3
}

case class ATopSupport (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, ATopSupport .xOffset),
    yOffset(topLeftY, ATopSupport .yOffset),
    (4*DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object ABridgeLeft {
    val xOffset = 5;
    val yOffset = 4
}

case class ABridgeLeft (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, ABridgeLeft .xOffset),
    yOffset(topLeftY, ABridgeLeft .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object ABridgeRight {
    val xOffset = 8;
    val yOffset = 4
}

case class ABridgeRight (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, ABridgeRight .xOffset),
    yOffset(topLeftY, ABridgeRight .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object ARightLeg {
    val xOffset = 8;
    val yOffset = 5
}

case class ARightLeg (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, ARightLeg .xOffset),
    yOffset(topLeftY, ARightLeg .yOffset),
    (DEFAULT_ELEMENT_WIDTH),2*DEFAULT_ELEMENT_HEIGHT)

object ALeftLeg {
    val xOffset = 5;
    val yOffset = 5
}

case class ALeftLeg (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, ALeftLeg .xOffset),
    yOffset(topLeftY, ALeftLeg .yOffset),
    (DEFAULT_ELEMENT_WIDTH),2*DEFAULT_ELEMENT_HEIGHT)

object AMidBridge {
    val xOffset = 6;
    val yOffset = 5
}

case class AMidBridge (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, AMidBridge .xOffset),
    yOffset(topLeftY, AMidBridge .yOffset),
    (2*DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object MTopOne {
    val xOffset =10;
    val yOffset =2
}

case class MTopOne (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, MTopOne .xOffset),
    yOffset(topLeftY, MTopOne .yOffset),
    (2*DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object MTopTwo {
    val xOffset =13;
    val yOffset =2
}

case class MTopTwo (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, MTopTwo .xOffset),
    yOffset(topLeftY, MTopTwo .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object MTLeftLeg {
    val xOffset =10;
    val yOffset =3
}

case class MTLeftLeg (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, MTLeftLeg .xOffset),
    yOffset(topLeftY, MTLeftLeg .yOffset),
    (DEFAULT_ELEMENT_WIDTH),4*DEFAULT_ELEMENT_HEIGHT)

object MMidLeg {
    val xOffset =12;
    val yOffset =3
}

case class MMidLeg  (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, MMidLeg  .xOffset),
    yOffset(topLeftY, MMidLeg  .yOffset),
    (DEFAULT_ELEMENT_WIDTH),4*DEFAULT_ELEMENT_HEIGHT)

object MRightLeg {
    val xOffset =14;
    val yOffset =3
}

case class MRightLeg   (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, MRightLeg   .xOffset),
    yOffset(topLeftY, MRightLeg   .yOffset),
    (DEFAULT_ELEMENT_WIDTH),4*DEFAULT_ELEMENT_HEIGHT)
