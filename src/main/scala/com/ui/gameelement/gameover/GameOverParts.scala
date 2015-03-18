package com.ui.gameelement.gameover

import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._
import com.ui.gameelement.bomb.WhiteDisplayElement
import java.awt.Color
import java.awt.Color._

trait GameOverParts {
    def parts(x: Int, y: Int): List[SingleDisplayElement] = List[SingleDisplayElement](
        GTop(x, y),
        GMid(x, y),
        GBottom(x, y),
        GHookMid(x, y),
        GHookTop(x, y),
        ATop(x, y),
        ATopSupport(x, y),
        ABridgeLeft(x, y),
        ABridgeRight(x, y),
        ALeftLeg(x, y),
        ARightLeg(x, y),
        AMidBridge(x, y),
        MTopOne(x, y),
        MTopTwo(x, y),
        MTLeftLeg(x, y),
        MMidLeg(x, y),
        MRightLeg(x, y),
        EUpright(x, y),
        ETop(x, y),
        EMid(x, y),
        EBottom(x, y),
        OLeft(x, y),
        OTop(x, y),
        OBottom(x, y),
        ORight(x, y),
        VLeft(x, y),
        VRight(x, y),
        VBottom(x, y),
        VBottomLeft(x, y),
        VBottomRight(x, y),
        E2Upright(x, y),
        E2Top(x, y),
        E2Mid(x, y),
        E2Bottom(x, y),
        RTop(x, y),
        RLeft(x, y),
        RBottom(x, y),
        RRight(x, y),
        RMid(x, y)
    )
}
abstract class GameOverDisplayElement(x: Int, y: Int, xOffsetFromCentre: Int, yOffsetFromCentre: Int)
    extends SingleDisplayElement(x, y, xOffsetFromCentre, yOffsetFromCentre){
    override val color:Color = GREEN
}

object GTop {
    val xOffset = 1;
    val yOffset = 2
}


case class GTop(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, GTop.xOffset),
    yOffset(topLeftY, GTop.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object GMid {
    val xOffset = 0;
    val yOffset = 3
}

case class GMid(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, GMid.xOffset),
    yOffset(topLeftY, GMid.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 3 * DEFAULT_ELEMENT_HEIGHT)

object GBottom {
    val xOffset = 1;
    val yOffset = 6
}

case class GBottom(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, GBottom.xOffset),
    yOffset(topLeftY, GBottom.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object GHookMid {
    val xOffset = 3;
    val yOffset = 5
}

case class GHookMid(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, GHookMid.xOffset),
    yOffset(topLeftY, GHookMid.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object GHookTop {
    val xOffset = 2;
    val yOffset = 4
}

case class GHookTop(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, GHookTop.xOffset),
    yOffset(topLeftY, GHookTop.yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ATop {
    val xOffset = 6;
    val yOffset = 2
}

case class ATop(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ATop.xOffset),
    yOffset(topLeftY, ATop.yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ATopSupport {
    val xOffset = 5;
    val yOffset = 3
}

case class ATopSupport(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ATopSupport.xOffset),
    yOffset(topLeftY, ATopSupport.yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ABridgeLeft {
    val xOffset = 5;
    val yOffset = 4
}

case class ABridgeLeft(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ABridgeLeft.xOffset),
    yOffset(topLeftY, ABridgeLeft.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ABridgeRight {
    val xOffset = 8;
    val yOffset = 4
}

case class ABridgeRight(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ABridgeRight.xOffset),
    yOffset(topLeftY, ABridgeRight.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ARightLeg {
    val xOffset = 8;
    val yOffset = 5
}

case class ARightLeg(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ARightLeg.xOffset),
    yOffset(topLeftY, ARightLeg.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 2 * DEFAULT_ELEMENT_HEIGHT)

object ALeftLeg {
    val xOffset = 5;
    val yOffset = 5
}

case class ALeftLeg(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ALeftLeg.xOffset),
    yOffset(topLeftY, ALeftLeg.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 2 * DEFAULT_ELEMENT_HEIGHT)

object AMidBridge {
    val xOffset = 6;
    val yOffset = 5
}

case class AMidBridge(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, AMidBridge.xOffset),
    yOffset(topLeftY, AMidBridge.yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MTopOne {
    val xOffset = 10;
    val yOffset = 2
}

case class MTopOne(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, MTopOne.xOffset),
    yOffset(topLeftY, MTopOne.yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MTopTwo {
    val xOffset = 13;
    val yOffset = 2
}

case class MTopTwo(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, MTopTwo.xOffset),
    yOffset(topLeftY, MTopTwo.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MTLeftLeg {
    val xOffset = 10;
    val yOffset = 3
}

case class MTLeftLeg(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, MTLeftLeg.xOffset),
    yOffset(topLeftY, MTLeftLeg.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 4 * DEFAULT_ELEMENT_HEIGHT)

object MMidLeg {
    val xOffset = 12;
    val yOffset = 3
}

case class MMidLeg(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, MMidLeg.xOffset),
    yOffset(topLeftY, MMidLeg.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 4 * DEFAULT_ELEMENT_HEIGHT)

object MRightLeg {
    val xOffset = 14;
    val yOffset = 3
}

case class MRightLeg(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, MRightLeg.xOffset),
    yOffset(topLeftY, MRightLeg.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 4 * DEFAULT_ELEMENT_HEIGHT)

object EUpright {
    val xOffset = 16;
    val yOffset = 2
}

case class EUpright(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, EUpright.xOffset),
    yOffset(topLeftY, EUpright.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 5 * DEFAULT_ELEMENT_HEIGHT)

object ETop {
    val xOffset = 17;
    val yOffset = 2
}

case class ETop(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ETop.xOffset),
    yOffset(topLeftY, ETop.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object EMid {
    val xOffset = 17;
    val yOffset = 4
}

case class EMid(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, EMid.xOffset),
    yOffset(topLeftY, EMid.yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object EBottom {
    val xOffset = 17;
    val yOffset = 6
}

case class EBottom(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, EBottom.xOffset),
    yOffset(topLeftY, EBottom.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object OLeft {
    val xOffset = 23;
    val yOffset = 3
}

case class OLeft(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, OLeft.xOffset),
    yOffset(topLeftY, OLeft.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 3 * DEFAULT_ELEMENT_HEIGHT)

object OTop {
    val xOffset = 24;
    val yOffset = 2
}

case class OTop(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, OTop.xOffset),
    yOffset(topLeftY, OTop.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object OBottom {
    val xOffset = 24;
    val yOffset = 6
}

case class OBottom(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, OBottom.xOffset),
    yOffset(topLeftY, OBottom.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object ORight {
    val xOffset = 27;
    val yOffset = 3
}

case class ORight(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, ORight.xOffset),
    yOffset(topLeftY, ORight.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 3 * DEFAULT_ELEMENT_HEIGHT)

object VLeft {
    val xOffset = 29;
    val yOffset = 2
}

case class VLeft(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, VLeft.xOffset),
    yOffset(topLeftY, VLeft.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 3 * DEFAULT_ELEMENT_HEIGHT)

object VRight {
    val xOffset = 33;
    val yOffset = 2
}

case class VRight(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, VRight.xOffset),
    yOffset(topLeftY, VRight.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 3 * DEFAULT_ELEMENT_HEIGHT)

object VBottom {
    val xOffset = 31;
    val yOffset = 6
}

case class VBottom(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, VBottom.xOffset),
    yOffset(topLeftY, VBottom.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object VBottomRight {
    val xOffset = 32;
    val yOffset = 5
}

case class VBottomRight(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, VBottomRight.xOffset),
    yOffset(topLeftY, VBottomRight.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object VBottomLeft {
    val xOffset = 30;
    val yOffset = 5
}

case class VBottomLeft(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, VBottomLeft.xOffset),
    yOffset(topLeftY, VBottomLeft.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object E2Upright {
    val xOffset = 35;
    val yOffset = 2
}

case class E2Upright(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, E2Upright.xOffset),
    yOffset(topLeftY, E2Upright.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 5 * DEFAULT_ELEMENT_HEIGHT)

object E2Top {
    val xOffset = 36;
    val yOffset = 2
}

case class E2Top(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, E2Top.xOffset),
    yOffset(topLeftY, E2Top.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object E2Mid {
    val xOffset = 36;
    val yOffset = 4
}

case class E2Mid(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, E2Mid.xOffset),
    yOffset(topLeftY, E2Mid.yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object E2Bottom {
    val xOffset = 36;
    val yOffset = 6
}

case class E2Bottom(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, E2Bottom.xOffset),
    yOffset(topLeftY, E2Bottom.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object RTop {
    val xOffset = 42;
    val yOffset = 2
}

case class RTop(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, RTop.xOffset),
    yOffset(topLeftY, RTop.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object RLeft {
    val xOffset = 41;
    val yOffset = 2
}

case class RLeft(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, RLeft.xOffset),
    yOffset(topLeftY, RLeft.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 5 * DEFAULT_ELEMENT_HEIGHT)

object RRight {
    val xOffset = 45;
    val yOffset = 5
}

case class RRight(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, RRight.xOffset),
    yOffset(topLeftY, RRight.yOffset),
    (DEFAULT_ELEMENT_WIDTH), 2 * DEFAULT_ELEMENT_HEIGHT)

object RBottom {
    val xOffset = 42;
    val yOffset = 4
}

case class RBottom(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, RBottom.xOffset),
    yOffset(topLeftY, RBottom.yOffset),
    (3 * DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object RMid {
    val xOffset = 45;
    val yOffset = 3
}

case class RMid(topLeftX: Int, topLeftY: Int) extends GameOverDisplayElement(
    xOffset(topLeftX, RMid.xOffset),
    yOffset(topLeftY, RMid.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)