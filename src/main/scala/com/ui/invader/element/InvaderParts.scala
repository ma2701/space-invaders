package com.ui.invader.element


import DisplayElement._

abstract class Antena(x: Int, y: Int, xOffsetFromCentre: Double, yOffsetFromCentre: Double)
    extends DisplayElement(xOffset(x, xOffsetFromCentre), yOffset(y, yOffsetFromCentre))

object TopRightAntena {
    val xOffset = 8;
    val yOffset = 0
}

case class TopRightAntena(invaderPosX: Int, invaderPosY: Int) extends Antena(
    invaderPosX, invaderPosY, TopRightAntena.xOffset, TopRightAntena.yOffset)

object BottomRightAntena {
    val xOffset = 7;
    val yOffset = 1
}

case class BottomRightAntena(invaderPosX: Int, invaderPosY: Int) extends Antena(
    invaderPosX, invaderPosY, BottomRightAntena.xOffset, BottomRightAntena.yOffset)

object TopLeftAntena {
    val xOffset = 2;
    val yOffset = 0
}

case class TopLeftAntena(invaderPosX: Int, invaderPosY: Int) extends Antena(
    invaderPosX, invaderPosY, TopLeftAntena.xOffset, TopLeftAntena.yOffset)

object BottomLeftAntena {
    val xOffset = 3;
    val yOffset = 1
}

case class BottomLeftAntena(invaderPosX: Int, invaderPosY: Int) extends Antena(
    invaderPosX, invaderPosY, BottomLeftAntena.xOffset, BottomLeftAntena.yOffset)

object Forehead {
    val xOffset = 2;
    val yOffset = 2
}

case class Forehead(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, Forehead.xOffset),
    yOffset(invaderPosY, Forehead.yOffset),
    (7 * DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object EyeSocket {
    val xOffset = 1;
    val yOffset = 3
}

case class EyeSocket(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, EyeSocket.xOffset),
    yOffset(invaderPosY, EyeSocket.yOffset),
    (9 * DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object RightEye {
    val xOffset = 7;
    val yOffset = 3
}

case class RightEye(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, RightEye.xOffset),
    yOffset(invaderPosY, RightEye.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LeftEye {
    val xOffset = 3;
    val yOffset = 3
}

case class LeftEye(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, LeftEye.xOffset),
    yOffset(invaderPosY, LeftEye.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Nose {
    val xOffset = 1;
    val yOffset = 4
}

case class Nose(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, Nose.xOffset),
    yOffset(invaderPosY, Nose.yOffset),
    (9 * DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object UpperLip {
    val xOffset = 2;
    val yOffset = 5
}

case class UpperLip(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, UpperLip.xOffset),
    yOffset(invaderPosY, UpperLip.yOffset),
    (7 * DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Lip {
    val xOffset = 2;
    val yOffset = 6
}

case class Lip(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, Lip.xOffset),
    yOffset(invaderPosY, Lip.yOffset),
    (7 * DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Mouth {
    val xOffset = 3;
    val yOffset = 6
}

case class Mouth(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, Mouth.xOffset),
    yOffset(invaderPosY, Mouth.yOffset),
    (5 * DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LowerLip {
    val xOffset = 3;
    val yOffset = 7
}

case class LowerLip(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, LowerLip.xOffset),
    yOffset(invaderPosY, LowerLip.yOffset),
    (5 * DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LeftEar {
    val xOffset = 0;
    val yOffset = 4
}

case class LeftEar(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, LeftEar.xOffset),
    yOffset(invaderPosY, LeftEar.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LeftEarUp {
    val xOffset = 0;
    val yOffset = 1
}
case class LeftEarUp(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, LeftEarUp.xOffset),
    yOffset(invaderPosY, LeftEarUp.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object RightEar {
    val xOffset = 10;
    val yOffset = 4
}

case class RightEar(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, RightEar.xOffset),
    yOffset(invaderPosY, RightEar.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * DisplayElement.DEFAULT_ELEMENT_HEIGHT)


object RightEarUp {
    val xOffset = 10;
    val yOffset = 1
}

case class RightEarUp(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, RightEarUp.xOffset),
    yOffset(invaderPosY, RightEarUp.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Chin {
    val xOffset = 5;
    val yOffset = 7
}

case class Chin(invaderPosX: Int, invaderPosY: Int) extends DisplayElement(
    xOffset(invaderPosX, Chin.xOffset),
    yOffset(invaderPosY, Chin.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH), DisplayElement.DEFAULT_ELEMENT_HEIGHT)
