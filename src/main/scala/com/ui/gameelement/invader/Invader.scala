package com.ui.gameelement.invader

import java.awt.{Point, Color, Graphics, Rectangle}
import com.ui.gameelement.element._
import com.ui.gameelement.invader.Mood._


object Invader {
    val INVADER_WIDTH:  Int  = 11 * SingleDisplayElement.DEFAULT_ELEMENT_WIDTH
    val INVADER_HEIGHT: Int  = 8  * SingleDisplayElement.DEFAULT_ELEMENT_HEIGHT
}

case class Invader(val topLeft:Point,
                   val mood:InvaderArmyMood = Normal,
                   var isHit:Boolean = false) {

    import Invader._

    protected val x = topLeft.x
    protected val y = topLeft.y

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
    val loweLipOpenLeft         = new LowerLipOpenLeft(x,y).getBoundingBox
    val loweLipOpenRight        = new LowerLipOpenRight(x,y).getBoundingBox

    val leftEar                 = new LeftEar(x,y).getBoundingBox
    val rightEar                = new RightEar(x,y).getBoundingBox

    val leftEarUp               = new LeftEarUp(x,y).getBoundingBox
    val rightEarUp              = new RightEarUp(x,y).getBoundingBox

    val chin                    = new Chin(x,y).getBoundingBox

    def moveTo(point:Point): Invader =
        if(isHit)
            new ExplodingInvader(topLeft)
        else
            new Invader(point,  if(mood == Normal ) Excited else Normal, this.isHit )

    def markHitByMissile    =  isHit = true
    def isHitByMissile      =  isHit == true

    def boundingBox: Rectangle = new Rectangle(x ,y, INVADER_WIDTH, INVADER_HEIGHT)

    def draw(g:Graphics) :Unit = {
        drawAntena(g)
        drawFace(g)
    }

    def beenExplodingForTooLong(currentTime:Long):Boolean = false

    private def drawFace(g: Graphics) {
        g.setColor(Color.WHITE)

        drawBox(g, forehead)
        drawBox(g, eyeSocket)
        drawBox(g, nose)
        drawBox(g, upperLip)
        drawBox(g, lip)

        if(mood == Normal) {
            drawBox(g, loweLip)
            drawBox(g, leftEar)
            drawBox(g, rightEar)
        } else {
            drawBox(g, leftEarUp)
            drawBox(g, rightEarUp)
            drawBox(g, loweLipOpenLeft)
            drawBox(g, loweLipOpenRight)
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

class ExplodingInvader(tl:Point,
                       val explosionTime:Long= System.currentTimeMillis())  extends Invader(tl) {

    override def draw(g:Graphics) :Unit = new ExplodedInvader(topLeft).draw(g)
    override def moveTo(point:Point): Invader = new ExplodingInvader(point, explosionTime)
    override def boundingBox: Rectangle = new ExplodedInvader(topLeft).boundingBox

    /**
     * want to show an exploding invader only for one frame and then mark it dead. this is calculating
     * if the explosion has been displayed on screen long enough
     */
    override def beenExplodingForTooLong(currentTime:Long):Boolean = (currentTime - explosionTime) >= 333
}

class DeadInvader(tl:Point) extends Invader(tl) {
    override def draw(g:Graphics) :Unit = Unit
    override def moveTo(point:Point): Invader = new DeadInvader(point)
    override def boundingBox: Rectangle = new Rectangle(0 ,0, 0, 0)
}