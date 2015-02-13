package com.ui.gameelement.invader

import java.awt.{Point, Color, Graphics, Rectangle}
import com.ui.gameelement.element._
import com.ui.gameelement.invader.Mood._


object Invader {
    val INVADER_WIDTH: Int  = 11 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH
    val INVADER_HEIGHT: Int = 8  * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT
}

class Invader(val topLeft:Point,
              val mood:InvaderArmyMood = Normal) {

    import Invader._

    private val x = topLeft.x
    private val y = topLeft.y

    private var isDead     = false
    private var isExploded = false

    val topRightAntena          = new TopRightAntena(x, y).getBoundingBox
    val bottomRightAntena       = new BottomRightAntena(x,y).getBoundingBox
    
    val topLeftAntena           = new TopLeftAntena(x, y).getBoundingBox
    val bottomLeftAntena        = new BottomLeftAntena(x,y).getBoundingBox

    val forehead                = new Forehead(x,y).getBoundingBox
    val eyeSocket               = new EyeSocket(x,y).getBoundingBox
    val rightEye                = new RightEye(x,y).getBoundingBox
    val leftEye                 = new LeftEye(x,y).getBoundingBox
    val nose                    = new Nose(x,y).getBoundingBox
    val upperLip                = new UpperLip(x,y).getBoundingBox
    val lip                     = new Lip(x,y).getBoundingBox
    val mouth                   = new Mouth(x,y).getBoundingBox
    val loweLip                 = new LowerLip(x,y).getBoundingBox

    val leftEar                 = new LeftEar(x,y).getBoundingBox
    val rightEar                = new RightEar(x,y).getBoundingBox

    val leftEarUp               = new LeftEarUp(x,y).getBoundingBox
    val rightEarUp              = new RightEarUp(x,y).getBoundingBox

    val chin                    = new Chin(x,y).getBoundingBox

    def moveTo(point:Point): Invader = new Invader(point, mood)

    def markHitByMissile    =  isDead = true
    def isHitByMissile      =  isDead == true

    def boundingBox: Rectangle = new Rectangle(x ,y, INVADER_WIDTH, INVADER_HEIGHT)

    def draw(g:Graphics) :Unit = {
        if(isDead && !isExploded) {
            drawExploded(g)
            isExploded = true
        } else if(isExploded) {
               Unit
        } else {
            drawAntena(g)
            drawFace(g)
        }
    }

    private def drawExploded(g: Graphics) =  {
        println("drawing expoded....")
        new ExplodedInvader(topLeft).draw(g)
    }

    private def drawFace(g: Graphics) {
        g.setColor(Color.WHITE)

        drawBox(g, forehead)
        drawBox(g, eyeSocket)
        drawBox(g, nose)
        drawBox(g, upperLip)
        drawBox(g, lip)
        drawBox(g, loweLip)
        
        if(mood == Normal) {
            drawBox(g, leftEar)
            drawBox(g, rightEar)
        } else {
            drawBox(g, leftEarUp)
            drawBox(g, rightEarUp)
        }

        g.setColor(Color.BLACK)
        drawBox(g, rightEye)
        drawBox(g, leftEye)
        drawBox(g, mouth)
        drawBox(g, chin)
    }

    private def drawAntena(g: Graphics) {
        g.setColor(Color.WHITE)
        drawBox(g, topRightAntena)
        drawBox(g, bottomRightAntena)
        drawBox(g, topLeftAntena)
        drawBox(g, bottomLeftAntena)
    }

    private def drawBox(g:Graphics, rect:Rectangle):Unit = {
        g.fillRect(rect.getX.toInt, rect.getY.toInt, rect.getWidth.toInt, rect.getHeight.toInt)
    }
}
