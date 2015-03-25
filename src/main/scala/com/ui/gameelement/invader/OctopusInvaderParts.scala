package com.ui.gameelement.invader

import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._
import java.awt.Color
import java.awt.Color._

trait OctopusInvaderParts {
    def parts(x:Int, y:Int): List[SingleDisplayElement] = List[SingleDisplayElement](
        Crown(x,y),
        Head(x,y),
        Face(x,y),
        LeftOctopusEye(x,y),
        RightOctopusEye(x,y),
        LeftTentacleTop(x,y),
        LeftTentacleMid(x,y),
        LeftTentacleBottom(x,y),
        OctopusMouth(x,y),
        RightTentacleTop(x,y),
        RightTentacleMid(x,y),
        RightTentacleBottom(x,y)
    )
}
trait ExcitedOctopusInvaderParts {
    def parts(x:Int, y:Int): List[SingleDisplayElement] = List[SingleDisplayElement](
        Crown(x,y),
        Head(x,y),
        Face(x,y),
        LeftOctopusEye(x,y),
        RightOctopusEye(x,y),
        LeftTentacleTop(x,y),
        LeftTentacleMid(x,y),
        LeftTentacleBottomClosed(x,y),
        OctopusMouth(x,y),
        RightTentacleTop(x,y),
        RightTentacleMid(x,y),
        RightTentacleBottomClosed(x,y)
    )
}

abstract class WhiteDisplayElement(x: Int, y: Int, xOffsetFromCentre: Int, yOffsetFromCentre: Int)
    extends SingleDisplayElement(x, y, xOffsetFromCentre, yOffsetFromCentre){
    override val color:Color = WHITE
}
object Crown {
    val xOffset = 3;
    val yOffset = 0
}

case class Crown(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Crown.xOffset),
    yOffset(topLeftY, Crown.yOffset),
    (4 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object Head {
    val xOffset = 1;
    val yOffset = 1
}

case class Head(topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Head.xOffset),
    yOffset(topLeftY, Head.yOffset),
    (8* DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object Face {
    val xOffset = 0;
    val yOffset = 2
}

case class Face (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, Face .xOffset),
    yOffset(topLeftY, Face .yOffset),
    (10* DEFAULT_ELEMENT_WIDTH),3*DEFAULT_ELEMENT_HEIGHT)

object LeftOctopusEye{
    val xOffset = 1;
    val yOffset = 3
}

case class LeftOctopusEye (topLeftX: Int, topLeftY: Int) extends BlackDisplayElement(
    xOffset(topLeftX, LeftOctopusEye .xOffset),
    yOffset(topLeftY, LeftOctopusEye .yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightOctopusEye {
    val xOffset = 7;
    val yOffset = 3
}

case class RightOctopusEye  (topLeftX: Int, topLeftY: Int) extends BlackDisplayElement(
    xOffset(topLeftX, RightOctopusEye  .xOffset),
    yOffset(topLeftY, RightOctopusEye  .yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object LeftTentacleTop {
    val xOffset = 3;
    val yOffset = 5
}

case class LeftTentacleTop (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, LeftTentacleTop .xOffset),
    yOffset(topLeftY, LeftTentacleTop .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)



object LeftTentacleMid {
    val xOffset = 2;
    val yOffset = 6
}

case class LeftTentacleMid (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, LeftTentacleMid .xOffset),
    yOffset(topLeftY, LeftTentacleMid .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


object LeftTentacleBottom{
    val xOffset = 0;
    val yOffset = 7
}

case class LeftTentacleBottom (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, LeftTentacleBottom .xOffset),
    yOffset(topLeftY, LeftTentacleBottom .yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object LeftTentacleBottomClosed {
    val xOffset = 2;
    val yOffset = 7
}
case class LeftTentacleBottomClosed (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, LeftTentacleBottomClosed .xOffset),
    yOffset(topLeftY, LeftTentacleBottomClosed .yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


object OctopusMouth{
    val xOffset = 4;
    val yOffset = 6
}

case class OctopusMouth (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, OctopusMouth .xOffset),
    yOffset(topLeftY, OctopusMouth .yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightTentacleTop{
    val xOffset = 6;
    val yOffset = 5
}

case class RightTentacleTop (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, RightTentacleTop .xOffset),
    yOffset(topLeftY, RightTentacleTop .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightTentacleMid{
    val xOffset = 7;
    val yOffset = 6
}
case class RightTentacleMid (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, RightTentacleMid .xOffset),
    yOffset(topLeftY, RightTentacleMid .yOffset),
    (DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)

object RightTentacleBottom{
    val xOffset = 8;
    val yOffset = 7
}
case class RightTentacleBottom (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, RightTentacleBottom .xOffset),
    yOffset(topLeftY, RightTentacleBottom .yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)



object RightTentacleBottomClosed {
    val xOffset = 6;
    val yOffset = 7
}
case class RightTentacleBottomClosed (topLeftX: Int, topLeftY: Int) extends WhiteDisplayElement(
    xOffset(topLeftX, RightTentacleBottomClosed .xOffset),
    yOffset(topLeftY, RightTentacleBottomClosed .yOffset),
    (2 * DEFAULT_ELEMENT_WIDTH),DEFAULT_ELEMENT_HEIGHT)


