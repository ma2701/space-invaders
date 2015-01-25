package com.ui

import java.awt.{Point, Color, Graphics, Rectangle}
import com.ui.character.invader._

object Invader {
    val INVADER_WIDTH: Int = 11 * DisplayElement.DEFAULT_ELEMENT_WIDTH
    val INVADER_HEIGHT: Int = 8 * DisplayElement.DEFAULT_ELEMENT_HEIGHT
}
class Invader(val topRight:Point) {
    import Invader._

    private val x = topRight.x
    private val y = topRight.y

    val topRightAntena   = new TopRightAntena(x, y).getBoundingBox
    val bottomRightAntena= new BottomRightAntena(x,y).getBoundingBox
    
    val topLeftAntena   = new TopLeftAntena(x, y).getBoundingBox
    val bottomLeftAntena= new BottomLeftAntena(x,y).getBoundingBox

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

    def moveTo(point:Point): Invader = new Invader(point)

    def moveTo(box:Rectangle): Invader = {
        val centre =  new Point(DisplayElement.xOffset(box.x , 5.5),
                                DisplayElement.yOffset(box.y , 4.5 )  )

        moveTo(centre)
    }

    def getBoundingBox: Rectangle = new Rectangle(
        DisplayElement.xOffset(x , -5.5) ,
        DisplayElement.yOffset(y , -4.5 ) ,
        INVADER_WIDTH,
        INVADER_HEIGHT)


    def draw(g:Graphics) :Unit = {
        drawAntena(g)
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

    def drawAntena(g: Graphics) {
        drawBox(g, topRightAntena)
        drawBox(g, bottomRightAntena)
        drawBox(g, topLeftAntena)
        drawBox(g, bottomLeftAntena)
    }

    private def drawBox(g:Graphics, rect:Rectangle):Unit = {
        g.fillRect(rect.getX.toInt, rect.getY.toInt, rect.getWidth.toInt, rect.getHeight.toInt)
    }
}
