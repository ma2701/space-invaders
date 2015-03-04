package com.ui.gameelement.invader

import com.ui.gameelement.element.SingleDisplayElement
import com.ui.gameelement.element.SingleDisplayElement._
import java.awt.Color
import java.awt.Color._

abstract class Antena(x: Int, y: Int, xOffsetFromCentre: Double, yOffsetFromCentre: Double)
    extends SingleDisplayElement(xOffset(x, xOffsetFromCentre), yOffset(y, yOffsetFromCentre)){
    override val color:Color = WHITE
}

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

case class Forehead(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, Forehead.xOffset),
    yOffset(invaderPosY, Forehead.yOffset),
    (7 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT) {
    override val color: Color = WHITE
}


object EyeSocket {
    val xOffset = 1;
    val yOffset = 3
}

case class EyeSocket(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, EyeSocket.xOffset),
    yOffset(invaderPosY, EyeSocket.yOffset),
    (9 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object RightEye {
    val xOffset = 7;
    val yOffset = 3
}

case class RightEye(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, RightEye.xOffset),
    yOffset(invaderPosY, RightEye.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = BLACK
}

object LeftEye {
    val xOffset = 3;
    val yOffset = 3
}

case class LeftEye(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, LeftEye.xOffset),
    yOffset(invaderPosY, LeftEye.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = BLACK
}

object Nose {
    val xOffset = 1;
    val yOffset = 4
}

case class Nose(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, Nose.xOffset),
    yOffset(invaderPosY, Nose.yOffset),
    (9 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object UpperLip {
    val xOffset = 2;
    val yOffset = 5
}

case class UpperLip(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, UpperLip.xOffset),
    yOffset(invaderPosY, UpperLip.yOffset),
    (7 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object Lip {
    val xOffset = 2;
    val yOffset = 6
}
case class Lip(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, Lip.xOffset),
    yOffset(invaderPosY, Lip.yOffset),
    (7 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object Mouth {
    val xOffset = 3;
    val yOffset = 6
}
case class Mouth(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, Mouth.xOffset),
    yOffset(invaderPosY, Mouth.yOffset),
    (5 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = BLACK
}

object LowerLip {
    val xOffset = 3;
    val yOffset = 7
}

case class LowerLip(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, LowerLip.xOffset),
    yOffset(invaderPosY, LowerLip.yOffset),
    (5 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object LowerLipOpenLeft {
    val xOffset = 1;
    val yOffset = 7
}
case class LowerLipOpenLeft(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, LowerLipOpenLeft.xOffset),
    yOffset(invaderPosY, LowerLipOpenLeft.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}


object LowerLipOpenRight {
    val xOffset = 9;
    val yOffset = 7
}
case class LowerLipOpenRight(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, LowerLipOpenRight.xOffset),
    yOffset(invaderPosY, LowerLipOpenRight.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}


object LeftEar {
    val xOffset = 0;
    val yOffset = 4
}

case class LeftEar(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, LeftEar.xOffset),
    yOffset(invaderPosY, LeftEar.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object LeftEarUp {
    val xOffset = 0;
    val yOffset = 1
}
case class LeftEarUp(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, LeftEarUp.xOffset),
    yOffset(invaderPosY, LeftEarUp.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object RightEar {
    val xOffset = 10;
    val yOffset = 4
}

case class RightEar(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, RightEar.xOffset),
    yOffset(invaderPosY, RightEar.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}


object RightEarUp {
    val xOffset = 10;
    val yOffset = 1
}

case class RightEarUp(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, RightEarUp.xOffset),
    yOffset(invaderPosY, RightEarUp.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), 3 * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = WHITE
}

object Chin {
    val xOffset = 5;
    val yOffset = 7
}

case class Chin(invaderPosX: Int, invaderPosY: Int) extends SingleDisplayElement(
    xOffset(invaderPosX, Chin.xOffset),
    yOffset(invaderPosY, Chin.yOffset),
    (SingleDisplayElement.DEFAULT_ELEMENT_WIDTH), SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT){
    override val color: Color = BLACK
}
