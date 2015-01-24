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

object TopRightEar{ val xOffsetFromCentre= 2.5; val yOffsetFromCentre= -4 }
case class TopRightEar(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, TopRightEar.xOffsetFromCentre, TopRightEar.yOffsetFromCentre)

object BottomRightEar{val xOffsetFromCentre= 1.5;  val yOffsetFromCentre= -3 }
case class BottomRightEar(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, BottomRightEar.xOffsetFromCentre, BottomRightEar.yOffsetFromCentre)

object TopLeftEar{val xOffsetFromCentre= -3.5;  val yOffsetFromCentre= -4}
case class TopLeftEar(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, TopLeftEar.xOffsetFromCentre, TopLeftEar.yOffsetFromCentre)

object BottomLeftEar{ val xOffsetFromCentre= -2.5; val yOffsetFromCentre= -3}
case class BottomLeftEar(invaderPosX:Int , invaderPosY:Int) extends Ears(
    invaderPosX, invaderPosY, BottomLeftEar.xOffsetFromCentre, BottomLeftEar.yOffsetFromCentre)

object Forehead{ val xOffsetFromCentre= -3.5; val yOffsetFromCentre= -2.5}
case class Forehead(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Forehead.xOffsetFromCentre),
    yOffset(invaderPosY, Forehead.yOffsetFromCentre),
    (7*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object EyeSocket{ val xOffsetFromCentre= -4.5; val yOffsetFromCentre= -1.5}
case class EyeSocket(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, EyeSocket.xOffsetFromCentre),
    yOffset(invaderPosY, EyeSocket.yOffsetFromCentre),
    (9*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object RightEye{ val xOffsetFromCentre= 1.5; val yOffsetFromCentre= -1.5}
case class RightEye(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, RightEye.xOffsetFromCentre),
    yOffset(invaderPosY, RightEye.yOffsetFromCentre),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LeftEye{ val xOffsetFromCentre= -2.5; val yOffsetFromCentre= -1.5}
case class LeftEye(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, LeftEye.xOffsetFromCentre),
    yOffset(invaderPosY, LeftEye.yOffsetFromCentre),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Nose{ val xOffsetFromCentre= -5.5; val yOffsetFromCentre= -0.5}
case class Nose(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Nose.xOffsetFromCentre),
    yOffset(invaderPosY, Nose.yOffsetFromCentre),
    (11*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object UpperLip{ val xOffsetFromCentre= -5.5; val yOffsetFromCentre= 0.5}
case class UpperLip(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, UpperLip.xOffsetFromCentre),
    yOffset(invaderPosY, UpperLip.yOffsetFromCentre),
    (11*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Lip{ val xOffsetFromCentre= -5.5; val yOffsetFromCentre= 1.5}
case class Lip(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Lip.xOffsetFromCentre),
    yOffset(invaderPosY, Lip.yOffsetFromCentre),
    (11*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Mouth{ val xOffsetFromCentre= -2.5; val yOffsetFromCentre= 1.5}
case class Mouth(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Mouth.xOffsetFromCentre),
    yOffset(invaderPosY, Mouth.yOffsetFromCentre),
    (5*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LowerLip{ val xOffsetFromCentre= -2.5; val yOffsetFromCentre= 2.5}
case class LowerLip(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, LowerLip.xOffsetFromCentre),
    yOffset(invaderPosY, LowerLip.yOffsetFromCentre),
    (5*DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object LeftEar{ val xOffsetFromCentre= -4.5; val yOffsetFromCentre= 0.5}
case class LeftEar(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, LeftEar.xOffsetFromCentre),
    yOffset(invaderPosY, LeftEar.yOffsetFromCentre),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , 2*DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object RightEar{ val xOffsetFromCentre= 3.5; val yOffsetFromCentre= 0.5}
case class RightEar(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, RightEar.xOffsetFromCentre),
    yOffset(invaderPosY, RightEar.yOffsetFromCentre),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , 2*DisplayElement.DEFAULT_ELEMENT_HEIGHT)

object Chin{ val xOffsetFromCentre= -0.5; val yOffsetFromCentre= 2.5}
case class Chin(invaderPosX:Int , invaderPosY:Int) extends DisplayElement (
    xOffset(invaderPosX, Chin.xOffsetFromCentre),
    yOffset(invaderPosY, Chin.yOffsetFromCentre),
    (DisplayElement.DEFAULT_ELEMENT_WIDTH) , DisplayElement.DEFAULT_ELEMENT_HEIGHT)





