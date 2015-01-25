package com.ui.character.invader

import java.awt.Rectangle

object DisplayElement {
    val DEFAULT_ELEMENT_WIDTH  = 2 // PIXELS
    val DEFAULT_ELEMENT_HEIGHT = 2
    
    def xOffset(x:Int , xOffset:Double):Int = x + (xOffset * DisplayElement.DEFAULT_ELEMENT_WIDTH ).toInt
    def yOffset(y:Int , yOffset:Double):Int = y + (yOffset * DisplayElement.DEFAULT_ELEMENT_HEIGHT ).toInt
}

abstract class DisplayElement(posX:Int,
                              posY:Int,
                              width:Int = DisplayElement.DEFAULT_ELEMENT_WIDTH ,
                              height:Int = DisplayElement.DEFAULT_ELEMENT_HEIGHT){

    def getBoundingBox:Rectangle ={
        new Rectangle(posX, posY, width, height)
    }
}

import DisplayElement._
abstract class Ears(x:Int , y:Int , xOffsetFromCentre:Double, yOffsetFromCentre:Double)
    extends DisplayElement(xOffset(x, xOffsetFromCentre),yOffset(y, yOffsetFromCentre) )

object TopRightAntena{ val xOffset= 9; val yOffset= 0 }
case class TopRightAntena(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, TopRightAntena.xOffset, TopRightAntena.yOffset)

object BottomRightAntena{val xOffset= 8;  val yOffset= 1}
case class BottomRightAntena(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, BottomRightAntena.xOffset, BottomRightAntena.yOffset)

object TopLeftAntena{val xOffset=2;  val yOffset= 0}
case class TopLeftAntena(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, TopLeftAntena.xOffset, TopLeftAntena.yOffset)

object BottomLeftAntena{ val xOffset= 3; val yOffset= 1}
case class BottomLeftAntena(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, BottomLeftAntena.xOffset, BottomLeftAntena.yOffset)

object Forehead{ val xOffset= 2; val yOffset= 2}
case class Forehead(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Forehead.xOffset),
    yOffset(invaderPosY, Forehead.yOffset),
    (7*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object EyeSocket{ val xOffset= 1; val yOffset= 3}
case class EyeSocket(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, EyeSocket.xOffset),
    yOffset(invaderPosY, EyeSocket.yOffset),
    (9*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object RightEye{ val xOffset=7; val yOffset= 3}
case class RightEye(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, RightEye.xOffset),
    yOffset(invaderPosY, RightEye.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LeftEye{ val xOffset= 3; val yOffset= 3}
case class LeftEye(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, LeftEye.xOffset),
    yOffset(invaderPosY, LeftEye.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Nose{ val xOffset= 0; val yOffset= 4}
case class Nose(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Nose.xOffset),
    yOffset(invaderPosY, Nose.yOffset),
    (11*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object UpperLip{ val xOffset= 0; val yOffset= 5}
case class UpperLip(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, UpperLip.xOffset),
    yOffset(invaderPosY, UpperLip.yOffset),
    (11*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Lip{ val xOffset= 0; val yOffset=6}
case class Lip(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Lip.xOffset),
    yOffset(invaderPosY, Lip.yOffset),
    (11*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Mouth{ val xOffset= 3; val yOffset= 6}
case class Mouth(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Mouth.xOffset),
    yOffset(invaderPosY, Mouth.yOffset),
    (5*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LowerLip{ val xOffset= 3; val yOffset= 7}
case class LowerLip(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, LowerLip.xOffset),
    yOffset(invaderPosY, LowerLip.yOffset),
    (5*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LeftEar{ val xOffset= 1; val yOffset= 5}
case class LeftEar(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, LeftEar.xOffset),
    yOffset(invaderPosY, LeftEar.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , 2*DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object RightEar{ val xOffset= 9; val yOffset= 5}
case class RightEar(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, RightEar.xOffset),
    yOffset(invaderPosY, RightEar.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , 2*DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Chin{ val xOffset= 5; val yOffset= 7}
case class Chin(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Chin.xOffset),
    yOffset(invaderPosY, Chin.yOffset),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)





