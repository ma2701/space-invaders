package com.ui

import java.awt.{Color, Graphics, Rectangle}
import com.ui.character.invader._

class Invader(val x:Int, val y:Int) {

    val topRightEar   = new TopRightEar(x, y).getBoundingBox
    val bottomRightEar= new BottomRightEar(x,y).getBoundingBox
    
    val topLeftEar   = new TopLeftEar(x, y).getBoundingBox
    val bottomLeftEar= new BottomLeftEar(x,y).getBoundingBox

    val forehead  = new Forehead(x,y).getBoundingBox
    val eyeSocket = new EyeSocket(x,y).getBoundingBox
    val rightEye  = new RightEye(x,y).getBoundingBox
    val leftEye  = new LeftEye(x,y).getBoundingBox
    val nose = new Nose(x,y).getBoundingBox
    val upperLip= new UpperLip(x,y).getBoundingBox
    val lip = new Lip(x,y).getBoundingBox
    val mouth = new Mouth(x,y).getBoundingBox
    val loweLip = new LowerLip(x,y).getBoundingBox
    val leftEar = new LeftEar(x,y).getBoundingBox
    val rightEar = new RightEar(x,y).getBoundingBox
    val chin = new Chin(x,y).getBoundingBox

    def moveTo(x:Int, y:Int): Invader = new Invader(x,y)

    def getBoundingBox: Rectangle = new Rectangle(
        DisplayElement.xOffset(x , -5.5) ,
        DisplayElement.yOffset(y , -4.5 ) ,
        11 * DisplayElement.DEFAULT_ELEMENT_WIDTH,
        8 * DisplayElement.DEFAULT_ELEMENT_HEIGHT)


    def draw(g:Graphics) :Unit = {
        drawEars(g)
        drawFace(g)
    }


    def drawFace(g: Graphics) {
        g.setColor(Color.RED)

        drawBox(g, forehead)
        drawBox(g, eyeSocket)
        drawBox(g, nose)
        drawBox(g, upperLip)
        drawBox(g, lip)
        drawBox(g, loweLip)

        g.setColor(Color.BLACK)
        drawBox(g, rightEye)
        drawBox(g, leftEye)
        drawBox(g, mouth)

        drawBox(g, leftEar)
        drawBox(g, rightEar)
        drawBox(g, chin)
    }

    def drawEars(g: Graphics) {
        drawBox(g, topRightEar)
        drawBox(g, bottomRightEar)
        drawBox(g, topLeftEar)
        drawBox(g, bottomLeftEar)
    }

    private def drawBox(g:Graphics, rect:Rectangle):Unit = {
        g.fillRect(rect.getX.toInt, rect.getY.toInt, rect.getWidth.toInt, rect.getHeight.toInt)
    }
}
