package com.ui.gameelement.invader

import java.awt.Color
import java.awt.Color._
import com.ui.gameelement.displayelement.SingleDisplayElement
import com.ui.gameelement.displayelement.SingleDisplayElement._


abstract class RedDisplayElement(x: Int, y: Int, width: Int, height: Int)
    extends SingleDisplayElement(x,y, width, height){
    override val color:Color = RED
}

abstract class BlackDisplayElement(x: Int, y: Int, width: Int, height: Int)
    extends SingleDisplayElement(x,y, width, height){
    override val color:Color = BLACK
}

object MysteryInvaderTop {
    val xOffset = 4;
    val yOffset = 0
}
case class MysteryInvaderTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderTop.xOffset),
    yOffset(invaderPosY, MysteryInvaderTop.yOffset),
    (5* DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderTopSupport {
    val xOffset = 3;
    val yOffset = 1
}

case class MysteryInvaderTopSupport(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderTopSupport.xOffset),
    yOffset(invaderPosY, MysteryInvaderTopSupport.yOffset),
    (7* DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderDecCover {
    val xOffset = 2;
    val yOffset = 2
}
case class MysteryInvaderDecCover(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderDecCover.xOffset),
    yOffset(invaderPosY, MysteryInvaderDecCover.yOffset),
    (9* DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderObservationDeck {
    val xOffset = 1;
    val yOffset = 3
}
case class MysteryInvaderObservationDeck(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderObservationDeck.xOffset),
    yOffset(invaderPosY, MysteryInvaderObservationDeck.yOffset),
    (11* DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderWindowOne {
    val xOffset = 3;
    val yOffset = 3
}
case class MysteryInvaderWindowOne(invaderPosX: Int, invaderPosY: Int) extends BlackDisplayElement(
    xOffset(invaderPosX, MysteryInvaderWindowOne.xOffset),
    yOffset(invaderPosY, MysteryInvaderWindowOne.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderWindowTwo {
    val xOffset = 5;
    val yOffset = 3
}
case class MysteryInvaderWindowTwo(invaderPosX: Int, invaderPosY: Int) extends BlackDisplayElement(
    xOffset(invaderPosX, MysteryInvaderWindowTwo.xOffset),
    yOffset(invaderPosY, MysteryInvaderWindowTwo.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)


object MysteryInvaderWindowThree {
    val xOffset = 7;
    val yOffset = 3
}
case class MysteryInvaderWindowThree(invaderPosX: Int, invaderPosY: Int) extends BlackDisplayElement(
    xOffset(invaderPosX, MysteryInvaderWindowThree.xOffset),
    yOffset(invaderPosY, MysteryInvaderWindowThree.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)


object MysteryInvaderWindowFour {
    val xOffset = 9;
    val yOffset = 3
}
case class MysteryInvaderWindowFour(invaderPosX: Int, invaderPosY: Int) extends BlackDisplayElement(
    xOffset(invaderPosX, MysteryInvaderWindowFour.xOffset),
    yOffset(invaderPosY, MysteryInvaderWindowFour.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderLegSupport{
    val xOffset = 0;
    val yOffset = 4
}
case class MysteryInvaderLegSupport(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderLegSupport.xOffset),
    yOffset(invaderPosY, MysteryInvaderLegSupport.yOffset),
    (13*DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderRightLegTop{
    val xOffset = 9;
    val yOffset = 5
}
case class MysteryInvaderRightLegTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderRightLegTop.xOffset),
    yOffset(invaderPosY, MysteryInvaderRightLegTop.yOffset),
    (3*DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderRightLegBottom{
    val xOffset = 10;
    val yOffset = 6
}
case class MysteryInvaderRightLegBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderRightLegBottom.xOffset),
    yOffset(invaderPosY, MysteryInvaderRightLegBottom.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderLeftLegTop{
    val xOffset = 1;
    val yOffset = 5
}
case class MysteryInvaderLeftLegTop(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderLeftLegTop.xOffset),
    yOffset(invaderPosY, MysteryInvaderLeftLegTop.yOffset),
    (3*DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderLeftLegBottom{
    val xOffset = 2;
    val yOffset = 6
}
case class MysteryInvaderLeftLegBottom(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderLeftLegBottom.xOffset),
    yOffset(invaderPosY, MysteryInvaderLeftLegBottom.yOffset),
    (DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)

object MysteryInvaderBottomHatchet{
    val xOffset = 5;
    val yOffset = 5
}
case class MysteryInvaderBottomHatchet(invaderPosX: Int, invaderPosY: Int) extends RedDisplayElement(
    xOffset(invaderPosX, MysteryInvaderBottomHatchet.xOffset),
    yOffset(invaderPosY, MysteryInvaderBottomHatchet.yOffset),
    (3*DEFAULT_ELEMENT_WIDTH), DEFAULT_ELEMENT_HEIGHT)



trait MysteryInvaderParts {
    def parts(x: Int, y: Int): List[SingleDisplayElement] =
        List[SingleDisplayElement](
            MysteryInvaderTop(x,y),
            MysteryInvaderTopSupport(x,y),
            MysteryInvaderDecCover(x,y),
            MysteryInvaderObservationDeck(x,y),
            MysteryInvaderWindowOne(x,y),
            MysteryInvaderWindowTwo(x,y),
            MysteryInvaderWindowThree(x,y),
            MysteryInvaderWindowFour(x,y),
            MysteryInvaderLegSupport(x,y),
            MysteryInvaderRightLegTop(x,y),
            MysteryInvaderRightLegBottom(x,y),
            MysteryInvaderLeftLegTop(x,y),
            MysteryInvaderLeftLegBottom(x,y),
            MysteryInvaderBottomHatchet(x,y)
        )
}